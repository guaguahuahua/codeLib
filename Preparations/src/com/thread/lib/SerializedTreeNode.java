package com.thread.lib;

import com.datastruct.TreeNode;

/**
 * 使用某种特殊的分隔符，分隔符左右两侧的元素就是
 * @author Administrator
 *
 */
public class SerializedTreeNode {

	
    String Serialize(TreeNode root) {
    	String res="";

		return res;        
    }
    
    TreeNode Deserialize(String str) {

		return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t=new TreeNode(33);
		TreeNode tl=new TreeNode(31);
		TreeNode tr=new TreeNode(32);
		t.left=tl;
		t.right=tr;
		SerializedTreeNode st=new SerializedTreeNode();
		String r=st.Serialize(t);
		String []infors=r.split("\\;+");
		for(int i=0; i<infors.length; i++) {
			System.out.println(infors[i]);
		}
		
		System.out.println(tl.hashCode());
	}

}
