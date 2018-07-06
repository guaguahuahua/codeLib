package com.thread.lib;

import java.util.ArrayList;
import java.util.LinkedList;

import com.datastruct.TreeNode;

public class PrintBinTree {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    	LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
    	ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
    	
    	if(pRoot==null) {
    		return out;
    	}
    	//头结点添加到队列中
    	queue.add(pRoot);
    	while(!queue.isEmpty()) {
    		//存放一层节点的数组
    		ArrayList<Integer> in=new ArrayList<Integer>();
    		//打印这一层
    		int size=queue.size();
    		int i=0;
    		while(i<size) {
	    		TreeNode t=queue.poll();
	    		in.add(t.val);
	    		if(t.left!=null) {
	    			queue.add(t.left);
	    		}
	    		if(t.right!=null) {
	    			queue.add(t.right);
	    		}
    			i++;
    		}    	
    		out.add(in);
    	}
    	return out;    
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1=new TreeNode('a');
		TreeNode n2=new TreeNode('b');
		TreeNode n3=new TreeNode('c');
		TreeNode n4=new TreeNode('d');
		TreeNode n5=new TreeNode('e');
		TreeNode n6=new TreeNode('f');
		TreeNode n7=new TreeNode('g');
		TreeNode n8=new TreeNode('h');
		TreeNode n9=new TreeNode('i');
		
		n1.left=n2;
		n1.right=n3;		
		n2.left=n4;
		n2.right=n5;		
		n3.left=n6;
		n3.right=n7;
		n5.left=n8;
		n5.right=n9;
		
		PrintBinTree pbt=new PrintBinTree();
		ArrayList<ArrayList<Integer>> r=pbt.Print(n1);
		System.out.println(r);
	}

}
