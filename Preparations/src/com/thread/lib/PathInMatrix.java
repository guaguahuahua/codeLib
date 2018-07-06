package com.thread.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * �ھ�����Ѱ��һ�����������ַ���·��
 * ���ľ���ʹ��һά�������ʾ
 * @author Administrator
 *
 */
public class PathInMatrix {

	
    public boolean hasPath_1(char[] matrix, int rows, int cols, char[] str){
    	if(matrix.length==0 || str.length==0) {
    		return false;
    	}
    	//��Ϊ�ַ�����������ģ�������Ҫ˳�����
    	List<Integer> index=new ArrayList<Integer>();
    	int i;
    	for(i=0; i<matrix.length; i++) {
    		if(matrix[i]==str[0]) {
    			index.add(i);
    		}
    	}
    	//��������в�����·������ʼ�㣬Ҳ���ܴ��ڶ��
    	if(index.size()<=0) {
    		return false;
    	}
    	
    	for(int oi=0; oi<index.size(); oi++) {
    	
	    	boolean []flag=new boolean[matrix.length];
	    	//�ӳ�ʼλ�ÿ�ʼѰ��
	    	int row=index.get(oi) / cols;
	    	int col=index.get(oi) % cols;
	    	//·��������
	    	int si=1;
	    	//�ĸ�������к��к�
	    	int mr=row-1;
	    	int mc=col-1;
	    	int pr=row+1;
	    	int pc=col+1;
	    	//���������ٶ�����4��������ֻ��һ�������㣬��ʵ�п�����4�������϶������
	    	while(si<str.length) {
	    		boolean up=false, right=false, down=false, left=false;
	    		int pos;
	    		//�����������
	        	if(mr>=0) {
	        		pos=mr*cols+col;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			up=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//�Ҳ�
	        	if(pc<cols) {
	        		pos=row*cols+pc;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			right=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//�²�
	        	if(pr<rows) {
	        		pos=pr*cols+col;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			down=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//���
	        	if(mc>=0) {
	        		pos=row*cols+mc;
	        		if(flag[pos]==false && matrix[pos]==str[si]) {
	        			si++;
	        			left=true;
	        			flag[pos]=true;
	        		}
	        	}
	        	//����ĸ������϶�û��ƥ���Ԫ��
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
