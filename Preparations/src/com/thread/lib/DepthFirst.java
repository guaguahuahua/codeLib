package com.thread.lib;

import java.util.LinkedList;
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
			//在当前节点周围有没有未访问过的节点
			boolean find=false;
			for(int col=0; col<array[row].length; col++) {
				//如果两个节点之间有路径，并且没有被访问过，
				if(array[row][col]!=m && flag[col]==false) {
					//将该节点添加到栈中
					stack.push(col);
					System.out.print((char) ('A'+col)+ "\t");
					//标记该节点已访问
					flag[col]=true;
					//被访问的节点数目增加
					nodes++;
					//修改标记，不用出栈
					find=true;
					row=stack.peek();
					break;
				}
			}
			//如果当前节点的邻接顶点被访问过了，那么回溯
			if(find==false) {
				row=stack.pop();
			}
		}
	}

	/**
	 * 广度优先遍历
	 * @param array
	 * @param entrance	开始节点
	 */
	public static void breadthFirst(int [][]array, int entrance) {
		LinkedList<Integer> queue=new LinkedList<Integer>();
		boolean []flag=new boolean[array.length];
		//已访问的节点数目
		int nodes=1;
		flag[entrance]=true;
		//开始节点
		int row=entrance;
		queue.add(entrance);
		System.out.print((char) ('A'+entrance)+"\t");
		
		while(!queue.isEmpty()) {
			row=queue.poll();
			for(int col=0; col<array[row].length; col++) {
				//如果当前节点没有被访问过，并且和当前顶点之间存在路径
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
