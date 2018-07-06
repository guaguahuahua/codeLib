package com.thread.lib;

import java.util.LinkedList;

public class MiddleNum {

	LinkedList<Integer> list=new LinkedList<Integer>();

	//使用二分法找到最合适的插入位置
    public void Insert(Integer num) {
    	if(list.size()==0) {
    		list.add(num);
    		return ;
    	}
        int index=binFind(num, list);
        list.add(index, num);
    }
    
    public int binFind(Integer num, LinkedList<Integer> list) {
    	int left=0;
    	int right=list.size();
    	int mid=0;
    	while(left<=right) {
    		mid=left+(right-left)/2;
    		if(mid<list.size() && list.get(mid)==num) {
    			return mid;
    		}else if(mid<list.size() && list.get(mid)<num) {
    			left=mid+1;
    		}else {
    			right=mid-1;
    		}
    	}
    	return left;
    }

    public Double GetMedian() {
    	int size=list.size();
    	//长度为偶数
    	if(size>>1<<1==size) {
    		return ((double) list.get(size/2)+ (double) list.get(size/2-1))/2;
    	}else {
    		return (double) list.get(size/2);
    	}
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(-1);
		
		MiddleNum mn=new MiddleNum();
		for(int i=0; i<list.size(); i++) {
			mn.Insert(list.get(i));
			System.out.println(mn.GetMedian());
		}
		
		for(int i=0; i<mn.list.size(); i++) {
			System.out.print(mn.list.get(i)+"\t");
		}
	}

}
