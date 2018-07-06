package com.thread.lib;

/**
 * ���մ󶥶ѵķ�ʽ������
 * @author Administrator
 *
 */
public class HeapSort {

	//
	public static void heapSort(int []nums) {
		//�ѵĵ���
		int len=nums.length;
		for(int j=0; j<nums.length; j++) {			
		

			for(int i=(nums.length-1)/2; i>=0; i--) {
				createHeap(nums, i, len);
			}
			//�����Ѷ�������Ԫ�ص�λ��
			int temp=nums[0];
			nums[0]=nums[nums.length-j-1];
			nums[nums.length-j-1]=temp;
			len--;
		}
		
	}
	
	//һ�ζ�����
	public static void createHeap(int []nums, int pos, int len) {
		
		int temp=nums[pos];
		int child;
		for( ; 2*pos+1<len; ) {
			child=2*pos+1;
			//�����������ӽڵ���бȽ�
			if(child+1<len && nums[child]<nums[child+1]) {
				child++;
			}
			//�Ƚϸ��ͺ��ӽڵ��Ƿ���Ҫ����
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
