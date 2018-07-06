package com.thread.lib;

import java.util.Stack;

public class DepthFirst {
	
	private static final int m=Integer.MAX_VALUE;
	
	/**
	 * 图的深度优先遍历
	 * @param array
	 * @param entrance 入口
	 */
	public static void depthFirst(int [][]array, int entrance) {
		Stack<Integer> stack=new Stack<Integer>();
		//标记数组
		boolean []flag=new boolean[array.length];
		flag[entrance]=true;
		System.out.print((char) ('A'+entrance)+ "\t");
		//统计访问过的节点的数
		int nodes=1;
		
		int row=entrance;
		while(nodes<array.length) {
			for(int col=0; col<array[row].length; col++) {
				//如果两个节点之间有路径，并且没有被访问过，不访问自己
				if(array[row][col]!=m && array[row][col]!=0 && flag[col]==false) {
					//将该节点添加到栈中
					stack.push(col);
					System.out.print((char) ('A'+col)+ "\t");
					//标记该节点已访问
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
