package com.thread.lib;

/**
 * 按照大顶堆的方式来进行
 * @author Administrator
 *
 */
public class HeapSort {

	//
	public static void heapSort(int []nums) {
		//堆的调整
		int len=nums.length;
		for(int j=0; j<nums.length; j++) {			
		

			for(int i=(nums.length-1)/2; i>=0; i--) {
				createHeap(nums, i, len);
			}
			//交换堆顶和排序元素的位置
			int temp=nums[0];
			nums[0]=nums[nums.length-j-1];
			nums[nums.length-j-1]=temp;
			len--;
		}
		
	}
	
	//一次堆排序
	public static void createHeap(int []nums, int pos, int len) {
		
		int temp=nums[pos];
		int child;
		for( ; 2*pos+1<len; ) {
			child=2*pos+1;
			//总是用最大的子节点进行比较
			if(child+1<len && nums[child]<nums[child+1]) {
				child++;
			}
			//比较根和孩子节点是否需要调整
			if(temp<nums[child]) {
				nums[pos]=nums[child];
			}else {
				break;
			}
			pos=child;
		}
		nums[pos]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {5,2,1,6,8};
		int len=nums.length;
		heapSort(nums);
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
	}
 
}
