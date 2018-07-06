package com.thread.lib;

import java.util.ArrayList;

/**
 * 使用堆排序
 * @author Administrator
 *
 */
public class SlideWindow {

    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	if(num.length<size || num.length==0 || size==0) {
    		return res;
    	}
    	//初始化窗口的数组
    	int[] sub=new int[size];
    	for(int i=0; i<size; i++) {
    		sub[i]=num[i];
    	}
    	//标记要替换的元素的位置
    	int left=0, right=size;
    	
    	while(right<=num.length) {
        	//一次堆排序
        	for(int i=(sub.length-1)/2; i>=0; i--) {
            	createHeap(sub, i, sub.length);
        	}
        	//取窗口中最大值
        	res.add(sub[0]);
        	if(right>=num.length) {
        		break;
        	}
        	//窗口移动
        	int index=find(sub, num[left]);
        	sub[index]=num[right];
        	right++;
        	left++;
    	}    	
        return res;
    }
	
    //创建堆，这块不用作调整，不用添加第三个参数
    public void createHeap(int []num, int pos, int len){
    	
    	int temp=num[pos];
    	int child;
    	for(; 2*pos+1<len; ) {
    		//获得孩子节点索引
    		child=2*pos+1;
    		//获取孩子节点中的较大值
    		if(child+1<len && num[child]<num[child+1]) {
    			child++;
    		}
    		//获取
    		if(temp<num[child]) {
    			num[pos]=num[child];
    		}else {
    			break;
    		}
    		pos=child;
    	}
    	num[pos]=temp;
    }
    
    
    public int find(int []num, int des) {
    	for(int i=0; i<num.length; i++) {
    		if(num[i]==des) {
    			return i;
    		}
    	}
    	return -1;
    } 
    
    //使用二分法找到需要替换的元素
    public int binFind(int []num, int des) {
    	int l=0;
    	int r=num.length-1;
    	int mid;
    	while(l<r) {
    		mid=l+(r-l)/2;
    		if(num[mid]==des) {
    			return mid;
    		}else if(num[mid]<des) {
    			l=mid+1;
    		}else {
    			r=mid-1;
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []num={2,3,4,2,6,2,5,1};
		int []num={};
		SlideWindow sw=new SlideWindow();
		ArrayList<Integer> r=sw.maxInWindows(num, 3);
		System.out.println(r);
	}

}
