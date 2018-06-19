package com.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到排序数组中和为sum的两个数，如果有多个，那么输出乘积最小的那个
 * @author Administrator
 *
 */
public class SumIsS_II {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	int left=0, right=array.length-1;
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	int multi=Integer.MAX_VALUE;
    	while(left<=right) {
    		int ts=array[left]+array[right];
    		if(ts==sum) {
    			int temp=array[left]*array[right];
    			if(temp<multi) {
    				multi=temp;
    				res.add(array[left]);
    				res.add(array[right]);
    			}
    			left++;
    			right--;
    		}else if(ts<sum){
    			left++;
    		}else if(ts>sum) {
    			right--;
    		}
    	}
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int sum=15;
		SumIsS_II sis=new SumIsS_II();
		ArrayList<?> res=sis.FindNumbersWithSum(array, sum);
		System.out.println(res);
	}

}
