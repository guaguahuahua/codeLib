package com.thread.lib;

import java.util.ArrayList;
import java.util.List;

import com.datastruct.TreeLinkNode;
/**
 * �Ƚ�����Դ��
 * @author Administrator
 *
 */
public class BinTreeNextNode {

	List<Integer> list;
    public TreeLinkNode GetNext_1(TreeLinkNode pNode){
    	
    	if(pNode==null) {
    		return pNode;
    	}
    	//��ȡԭʼ�ڵ��ָ��
    	TreeLinkNode tln=pNode;
    	
    	//����������Դ���ҵ���һ�����ڵ�
    	while(pNode.next!=null) {
    		pNode=pNode.next;
    	}    	
    	list=new ArrayList<Integer>();
    
    	//�����������Ľ��
    	lor(pNode, list);
    	int i;
    	for(i=0; i<list.size(); i++) {
    		if(tln.val==list.get(i)) {
    			break;
    		}
    	}
    	
    	//���ؽ��
    	if(i+1<list.size()) {
    		return new TreeLinkNode(list.get(i+1));
    	}
        return null;
    }
    
    //ʹ����������ķ�ʽ���
    public void lor(TreeLinkNode pNode, List<Integer> list) {
    	if(pNode!=null) {
    		lor(pNode.left, list);
    		list.add(pNode.val);
    		lor(pNode.right, list);
    	}
    }
	
    
    public TreeLinkNode GetNext(TreeLinkNode pNode){
    	
    	if(pNode==null) {
    		return pNode;
    	}
    	//�������������
    	if(pNode.right!=null) {
    		pNode=pNode.right;
    		while(pNode.left!=null) {
    			pNode=pNode.left;
    		}
    		return pNode;
    	}
    	
    	//�����������ڣ�����Ϊ������һ������
    	if(pNode.next!=null) {
    		TreeLinkNode parent=pNode.next;
    		//��ǰ�ڵ�Ϊ������
    		if(parent.left==pNode) {
    			return parent;
    		}
    		
    		//��ǰ�ڵ�Ϊ������
        	if(parent.right==pNode) {
        		while(pNode!=null) {
        			if(pNode.next.next.left==pNode) {
        				return pNode.next;
        			}
        			pNode=pNode.next;
        		}
        	}
    	}    	
    	return null;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode n1=new TreeLinkNode('a');
		TreeLinkNode n2=new TreeLinkNode('b');
		TreeLinkNode n3=new TreeLinkNode('c');
		TreeLinkNode n4=new TreeLinkNode('d');
		TreeLinkNode n5=new TreeLinkNode('e');
		TreeLinkNode n6=new TreeLinkNode('f');
		TreeLinkNode n7=new TreeLinkNode('g');
		TreeLinkNode n8=new TreeLinkNode('h');
		TreeLinkNode n9=new TreeLinkNode('i');
		
		n1.left=n2;
		n1.right=n3;		
		n2.left=n4;
		n2.right=n5;		
		n3.left=n6;
		n3.right=n7;
		n5.left=n8;
		n5.right=n9;
		
		n1.next=null;
		n2.next=n1;
		n3.next=n1;
		n4.next=n2;
		n5.next=n2;
		n6.next=n3;
		n6.next=n3;
		n8.next=n5;
		n9.next=n5;
		
		BinTreeNextNode btn=new BinTreeNextNode();
		TreeLinkNode tln=btn.GetNext(n6); //n2,
		System.out.println((char) tln.val);
		
//		for(int i=0; i<btn.list.size(); i++) {
//			System.out.print((char) btn.list.get(i).intValue()+"\t");
//		}
//		System.out.println();
	}

}
