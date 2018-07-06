package com.thread.lib;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirst {
	
	private static final int m=Integer.MAX_VALUE;
	
	/**
	 * ͼ��������ȱ���
	 * @param array
	 * @param entrance ���
	 */
	public static void depthFirst(int [][]array, int entrance) {
		Stack<Integer> stack=new Stack<Integer>();
		//�������
		boolean []flag=new boolean[array.length];
		flag[entrance]=true;
		System.out.print((char) ('A'+entrance)+ "\t");
		//ͳ�Ʒ��ʹ��Ľڵ����
		int nodes=1;

		int row=entrance;
		while(nodes<array.length) {
			//�ڵ�ǰ�ڵ���Χ��û��δ���ʹ��Ľڵ�
			boolean find=false;
			for(int col=0; col<array[row].length; col++) {
				//��������ڵ�֮����·��������û�б����ʹ���
				if(array[row][col]!=m && flag[col]==false) {
					//���ýڵ���ӵ�ջ��
					stack.push(col);
					System.out.print((char) ('A'+col)+ "\t");
					//��Ǹýڵ��ѷ���
					flag[col]=true;
					//�����ʵĽڵ���Ŀ����
					nodes++;
					//�޸ı�ǣ����ó�ջ
					find=true;
					row=stack.peek();
					break;
				}
			}
			//�����ǰ�ڵ���ڽӶ��㱻���ʹ��ˣ���ô����
			if(find==false) {
				row=stack.pop();
			}
		}
	}

	/**
	 * ������ȱ���
	 * @param array
	 * @param entrance	��ʼ�ڵ�
	 */
	public static void breadthFirst(int [][]array, int entrance) {
		LinkedList<Integer> queue=new LinkedList<Integer>();
		boolean []flag=new boolean[array.length];
		//�ѷ��ʵĽڵ���Ŀ
		int nodes=1;
		flag[entrance]=true;
		//��ʼ�ڵ�
		int row=entrance;
		queue.add(entrance);
		System.out.print((char) ('A'+entrance)+"\t");
		
		while(!queue.isEmpty()) {
			row=queue.poll();
			for(int col=0; col<array[row].length; col++) {
				//�����ǰ�ڵ�û�б����ʹ������Һ͵�ǰ����֮�����·��
				if(array[row][col]!=m && flag[col]==false) {
					queue.add(col);
					nodes++;
					flag[col]=true;
					System.out.print((char) ('A'+col)+"\t");
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]array=
			{
					{m, m, 5, 30, m, m},
					{2, m, m,  m, 8, m},
					{m, 15,m,  m, m, 7},
					{m, m, m,  m, m, m},
					{m, m, m,  4, m, m},
					{m, m, m, 10,18, m}
		};
//		DepthFirst.depthFirst(array, 0);
		DepthFirst.breadthFirst(array, 0);
	}

}
