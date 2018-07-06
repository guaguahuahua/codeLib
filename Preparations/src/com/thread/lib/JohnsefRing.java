package com.thread.lib;

import java.util.ArrayList;
import java.util.List;

public class JohnsefRing {

	/**
	 * ʹ�ö�̬������ģ����������
	 * @param ring
	 * @param k
	 * @return
	 */
	public static List<Integer> johnsefRing(List<Integer> ring, int k){
		List<Integer> res=new ArrayList<Integer>();
		int begin=0;
		
		while(!ring.isEmpty()) {
			//�õ����е��˵��±ꣻ
			int index=(begin+k) % ring.size();
			index=index-1;
			if(index<0) {
				index=ring.size()-1;
			}
			//����
			int temp=ring.remove(index);
			res.add(temp);
			
			//�������д��ԭ������ǰ���Ԫ�ر��Ƴ����ˣ����Բ���Ҫ������1�ˣ�����ԭ״����
			begin=index;
		}
		return res;
	}
	
	/**
	 * �������һ�������˵�����
	 * ��Ϊÿ�ζ��еĳ��ȶ�-1
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
