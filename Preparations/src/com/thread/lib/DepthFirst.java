package com.thread.lib;

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
			for(int col=0; col<array[row].length; col++) {
				//��������ڵ�֮����·��������û�б����ʹ����������Լ�
				if(array[row][col]!=m && array[row][col]!=0 && flag[col]==false) {
					//���ýڵ���ӵ�ջ��
					stack.push(col);
					System.out.print((char) ('A'+col)+ "\t");
					//��Ǹýڵ��ѷ���
					flag[col]=true;
					nodes++;
					row=stack.pop();
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]array=
			{
					{0, m, 5, 30, m, m},
					{2, 0, m,  m, 8, m},
					{m, 15,0,  m, m, 7},
					{m, m, m,  0, m, m},
					{m, m, m,  4, 0, m},
					{m, m, m, 10,18, 0}
		};
		DepthFirst.depthFirst(array, 0);
	}

}
