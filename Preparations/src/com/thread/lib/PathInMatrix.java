package com.thread.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 在矩阵中寻找一条包含给定字符的路径
 * 这块的矩阵使用一维的数组表示
 * @author Administrator
 *
 */
public class PathInMatrix {

	
    public boolean hasPath_1(char[] matrix, int rows, int cols, char[] str){
    	if(matrix.length==0 || str.length==0) {
    		return false;
    	}
    	//因为字符矩阵是无序的，所以需要顺序查找
    	List<Integer> index=new ArrayList<Integer>();
    	int i;
    	for(i=0; i<matrix.length; i++) {
    		if(matrix[i]==str[0]) {
    			index.add(i);
    		}
    	}
    	//如果矩阵中不存在路径的起始点，也可能存在多个
    	if(index.size()<=0) {
    		return false;
    	}
    	
    	for(int oi=0; oi<index.size(); oi++) {
    	
	    	boolean []flag=new boolean[matrix.length];
	    	//从初始位置开始寻找
	    	int row=index.get(oi) / cols;
	    	int col=index.get(oi) % cols;
	    	//路径的索引
	    	int si=1;
	    	//四个方向的行号列号
	    	int mr=row-1;
	    	int mc=col-1;
	    	int pr=row+1;
	    	int pc=col+1;
	    	//我们在这块假定的是4个方向中只有一个才满足，现实中可能是4个方向上多个满足
	    	while(si<str.length) {
	    		boolean up=false, right=false, down=false, left=false;
	    		int pos;
	    		//上面这个方向
	        	if(mr>=0) {
	        		pos=mr*cols+col;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			up=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//右侧
	        	if(pc<cols) {
	        		pos=row*cols+pc;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			right=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//下侧
	        	if(pr<rows) {
	        		pos=pr*cols+col;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			down=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//左侧
	        	if(mc>=0) {
	        		pos=row*cols+mc;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			left=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//如果四个方向上都没有匹配的元素
	        	if(up==false && right==false && down==false && left==false) {
	        		break;
	        	}
	        	if(up==true) {
	        		row--;
	        	}
	        	if(down==true) {
	        		row++;
	        	}
	        	if(left==true) {
	        		col--;
	        	}
	        	if(right==true) {
	        		col++;
	        	} 
	        	
	        	mr=row-1;
	        	mc=col-1;
	        	pr=row+1;
	        	pc=col+1;
	    	}
	    	if(si>=str.length) {
	    		return true;
	    	}
    	}
    	return false;
    }
	
    
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
    	char [][] m=new char[rows][cols];
    	for(int i=0; i<matrix.length; i++) {
    		
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []matrix= {'a', 'b', 'c', 'e',
						's', 'f', 'c', 's',
						'a', 'd', 'e', 'e'
					   };
		char []str= {'b', 'c', 'c', 'e', 'd'};
//		char []str= {'a', 'b', 'c', 'b'};
		PathInMatrix pim=new PathInMatrix();
		boolean res=pim.hasPath(matrix, 3, 4, str);
		System.out.println(res);
	}

}
