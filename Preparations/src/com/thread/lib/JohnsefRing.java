package com.thread.lib;

import java.util.ArrayList;
import java.util.List;

public class JohnsefRing {

	/**
	 * 使用动态数组来模拟整个过程
	 * @param ring
	 * @param k
	 * @return
	 */
	public static List<Integer> johnsefRing(List<Integer> ring, int k){
		List<Integer> res=new ArrayList<Integer>();
		int begin=0;
		
		while(!ring.isEmpty()) {
			//得到出列的人的下标；
			int index=(begin+k) % ring.size();
			index=index-1;
			if(index<0) {
				index=ring.size()-1;
			}
			//出列
			int temp=ring.remove(index);
			res.add(temp);
			
			//这块这样写的原因是他前面的元素被移除掉了，所以不需要索引加1了，保持原状即可
			begin=index;
		}
		return res;
	}
	
	/**
	 * 返回最后一个出列人的索引
	 * 因为每次队列的长度都-1
	 * @param m
	 * @param k
	 * @return
	 */
	public static int johnsefRing(int m, int k) {
		
		int out=0;
		for(int size=2; size<=m; size++) {
			out=(out+k) % size;
			System.out.print(out+"\t");
		}
		return out+1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ring=new ArrayList<Integer>();
		for(int i=1; i<=8; i++) {
			ring.add(i);
		}
		int k=6;
//		List<Integer> res=JohnsefRing.johnsefRing(ring, k);
//		System.out.println(res);
		
		int last=JohnsefRing.johnsefRing(8, 6);
		System.out.println();
		System.out.println(last);
	}

}
