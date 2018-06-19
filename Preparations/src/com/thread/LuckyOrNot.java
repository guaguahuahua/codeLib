package com.thread;

import java.util.Arrays;

/**
 * 这块有个很重要的东西，如果是顺子的话， 那么可以知道牌的开始和结束的最终元素
 * 这道题，无论是5张牌还是更多的牌，都是统一的解法，也就是，首先获得牌数的顺子的一个序列
 * 比如：5张牌的 1，2，3，4，5，那么他们的差delta是4，所以如果要想抽到的牌是顺子，那么非大小王之间的差值
 * 必须小于等于这个delta才能满足；
 * 依次类推，其他牌数的顺子都是可以按照这样的方式来实现的
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
    	//这块是为了避免全部是0的情况
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
