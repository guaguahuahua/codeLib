package com.thread.lib;

import java.util.ArrayList;
import java.util.LinkedList;

import com.datastruct.TreeNode;

public class KthMinValueInBinTree {

	//提取中序二叉树中的第k小的节点
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null) {
        	return null;
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        lor(pRoot, list);
        //参数k发生越界
        if(k>list.size() || k<=0) {
        	return null;
        }
    	return new TreeNode(list.get(k-1));
    }	
    
    //中序遍历的结果
    public void lor(TreeNode pRoot, ArrayList<Integer> list) {
    	if(pRoot!=null) {
    		lor(pRoot.left, list);
    		list.add(pRoot.val);
    		lor(pRoot.right, list);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1=new TreeNode(5);
		TreeNode n2=new TreeNode(3);
		TreeNode n3=new TreeNode(7);
		TreeNode n4=new TreeNode(2);
		TreeNode n5=new TreeNode(4);
		TreeNode n6=new TreeNode(6);
		TreeNode n7=new TreeNode(8);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		
		KthMinValueInBinTree kvb=new KthMinValueInBinTree();
		TreeNode r=kvb.KthNode(n1, 0);
		System.out.println(r.val);
		
	}

}
