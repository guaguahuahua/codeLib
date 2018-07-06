package com.thread;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplication {

	/**
	 * ��������ظ���Ԫ�أ���ô����true������false
	 * @param numbers
	 * @param length
	 * @param duplication	���ص�һ���ظ���Ԫ�أ�������ĳ���ֻ��1
	 * @return
	 */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	boolean flag=false;
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	for(int i=0; i<length; i++) {
    		int times=map.getOrDefault(numbers[i], 0);
    		//�ҵ��˵�һ���ظ���Ԫ��
    		if(times==1) {
    			flag=true;
    			duplication[0]=numbers[i];
    			break;
    		}
    		map.put(numbers[i], times+1);
    	}    	
        return flag;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []numbers={2,3,1,0,2,5,3};
		int []numbers={2,2,2,2,1};
		FirstDuplication fd=new FirstDuplication();
		int [] duplication=new int[1];
		fd.duplicate(numbers, numbers.length, duplication);
		System.out.println(duplication[0]);		
	}

}
