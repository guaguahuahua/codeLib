package com.thread.lib;

import java.util.LinkedList;

/**
 * 机器人的运动范围
 * @author Administrator
 *
 */
public class RobotMoveArea {

    public int movingCount(int threshold, int rows, int cols){
    	
    	int count=0;
    	if(rows==0 && cols==0 || threshold<0) {
    		return count;
    	}
    	boolean [][]flag=new boolean[rows][cols];
    	//使用队列实现广度优先遍历，分别存放数组的横纵坐标
    	LinkedList<int []> queue=new LinkedList<int []>();
    	//初始化队列
    	queue.add(new int[] {0, 0});
    	flag[0][0]=true;
    	count++;
    	
    	while(!queue.isEmpty()) {
    		//得到第一个位置
    		int []index=queue.poll();
    		int r=index[0], c=index[1];
    		//判断上下左右四个方向    		    		
			//up
			if(r-1>=0 && flag[r-1][c]==false) {
				//判断该位置的横纵坐标数位之和，如果不大于给定的阈值，那么添加到队列中
				int s=sum(r-1, c);
				if(s<=threshold) {
					queue.add(new int[] {r-1, c});
					flag[r-1][c]=true;
					count++;
				}
			}
			//right;
			if(c+1<cols && flag[r][c+1]==false) {
				int s=sum(r, c+1);
				if(s<=threshold) {
					queue.add(new int[] {r, c+1});
					flag[r][c+1]=true;
					count++;
				}				
			}
			//down
			if(r+1<rows && flag[r+1][c]==false) {
				int s=sum(r+1, c);
				if(s<=threshold) {
					queue.add(new int[] {r+1, c});
					flag[r+1][c]=true;
					count++;
				}
			}
			//left
			if(c-1>=0 && flag[r][c-1]==false) {
				int s=sum(r, c-1);
				if(s<=threshold) {
					queue.add(new int[] {r, c-1});
					flag[r][c-1]=true;
					count++;
				}
			}
    	}
        return count;
    }
    
    public int sum(int a, int b) {
    	int s=0;
    	int t;
    	while(a!=0) {
    		t=a % 10;
    		s=s+t;
    		a=a / 10;
    	}
    	while(b!=0) {
    		t=b % 10;
    		s=s+t;
    		b=b / 10;
    	}
    	return s;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a=12;
//		int b=13;
		RobotMoveArea rm=new RobotMoveArea();
//		int r=rm.movingCount(7, 8, 8);
		int r=rm.movingCount(-10, 8, 8);
		System.out.println(r);
	}

}
