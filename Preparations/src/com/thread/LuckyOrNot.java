package com.thread;

import java.util.Arrays;

/**
 * ����и�����Ҫ�Ķ����������˳�ӵĻ��� ��ô����֪���ƵĿ�ʼ�ͽ���������Ԫ��
 * ����⣬������5���ƻ��Ǹ�����ƣ�����ͳһ�Ľⷨ��Ҳ���ǣ����Ȼ��������˳�ӵ�һ������
 * ���磺5���Ƶ� 1��2��3��4��5����ô���ǵĲ�delta��4���������Ҫ��鵽������˳�ӣ���ô�Ǵ�С��֮��Ĳ�ֵ
 * ����С�ڵ������delta�������㣻
 * �������ƣ�����������˳�Ӷ��ǿ��԰��������ķ�ʽ��ʵ�ֵ�
 * @author Administrator
 *
 */
public class LuckyOrNot {

    public boolean isContinuous(int [] numbers) {
    	Arrays.sort(numbers);
    	int index=0;
    	boolean flag=false;
    	for(int i=0; i<numbers.length; i++) {
    		if(numbers[i]!=0) {
	    		if(i+1<numbers.length && numbers[i+1]==numbers[i]) {
					return false;
				}
	    		if(flag==false) {
	    			index=i;
	    			flag=true;
	    		}
    			
    		}
    	}
    	//�����Ϊ�˱���ȫ����0�����
    	if(index==numbers.length) {
    		return true;
    	}
    	int delta=numbers[numbers.length-1]-numbers[index];
    	if(delta<=4) {
    		return true;
    	}
		return false;
    }
	
	public static void main(String[] args) {
//		int []numbers= {0,0,1,3,5};
//		int []numbers= {0,0,0,0,0};
//		int []numbers= {1,0,0,1,0};
		int []numbers= {1,1,1,3,4};
		LuckyOrNot lon=new LuckyOrNot();
		System.out.println(lon.isContinuous(numbers));
	}
}
