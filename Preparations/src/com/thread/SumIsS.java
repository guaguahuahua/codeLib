package com.thread;

import java.util.ArrayList;

public class SumIsS {

	
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> in=new ArrayList<Integer>();
    	if(sum<=2) {
    		return out;
    	}
    	//使用辅助数组
    	int numbers=sum/2+1;
    	int []nums=new int [numbers];
    	for(int i=0; i<nums.length; i++) {
    		nums[i]=i+1;
    	}
    	
    	//使用滑动窗口的方式
    	int left=0; int right=left+1;
    	in.add(nums[left]);
    	int ts=1;
    	while(right<nums.length) {
    		in.add(nums[right]);
    		ts=ts+nums[right];
    		if(ts==sum) {
    			out.add(new ArrayList<Integer>(in));
    		}else if(ts>sum) {
    			while(ts>sum) {
    				int temp=in.remove(0);
    				left++;
    				ts=ts-temp;
    			}
        		if(ts==sum) {
        			out.add(new ArrayList<Integer>(in));
        		}
    		}
    		right++;
    	}    	
    	
        return out;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=15;
		SumIsS sis=new SumIsS();
		ArrayList<ArrayList<Integer>> res=sis.FindContinuousSequence(sum);
		System.out.println(res);
	}

}
