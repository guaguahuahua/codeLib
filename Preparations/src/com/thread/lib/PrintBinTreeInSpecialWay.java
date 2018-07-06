package com.thread.lib;

import java.util.ArrayList;
import java.util.Stack;

import com.datastruct.TreeNode;



public class PrintBinTreeInSpecialWay {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
    	if(pRoot==null) {
    		return out;
    	}
    	//如果根节点不为空
    	Stack<TreeNode> list=new Stack<TreeNode>();
    	Stack<TreeNode> list1=new Stack<TreeNode>();
    	list.add(pRoot);
    	boolean ltor=true;
    	while(!list.isEmpty() || !list1.isEmpty()) {
    		ArrayList<Integer> in=new ArrayList<Integer>();
    		//从左向右打印
    		if(ltor==true) {
    			//打印这一层的所有元素
    			int size=list.size();
    			int i=0;
    			while(i<size) {
    				TreeNode t=list.pop();
    				in.add(t.val);
    				System.out.println((char) t.val);
    				if(t.left!=null) {
    					System.out.println((char) t.left.val);
    					list1.push(t.left);
    				}
    				if(t.right!=null) {
    					list1.push(t.right);
    					System.out.println((char) t.right.val);
    				}
    				i++;
    			}
    			ltor=false;
    		//从右向左打印	
    		}else {
       			int size=list1.size();
    			int i=0;
    			while(i<size) {
    				TreeNode t=list1.pop();
    				in.add(t.val);
    				System.out.println((char) t.val);
    				if(t.right!=null) {
    					list.add(t.right);
    					System.out.println((char) t.right.val);
    				}
    				if(t.left!=null) {
    					list.add(t.left);
    					System.out.println((char) t.left.val);
    				}
    				i++;
    			}
    			ltor=true;
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
		
		PrintBinTreeInSpecialWay ps=new PrintBinTreeInSpecialWay();
		ArrayList<ArrayList<Integer>> res=ps.Print(n1);
		for(ArrayList<Integer> arr : res) {
			for(int i=0; i<arr.size(); i++) {
				System.out.print((char) arr.get(i).intValue()+"\t");
			}
			System.out.println();
		}
	}

}
