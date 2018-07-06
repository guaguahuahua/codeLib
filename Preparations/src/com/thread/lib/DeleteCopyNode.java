package com.thread.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.datastruct.ListNode;

public class DeleteCopyNode {
	//left逐个遍历， 如果相同right指针向后移动
    public ListNode deleteDuplication_1(ListNode pHead){

        if(pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode left=pHead, right=left.next;
        ListNode pre;
        while(left!=null) {
        	while(left.val==right.val) {
        		right=right.next;
        	}
        	pre=left;
        	left=right;
        	right=right.next;
        }
        return pHead;
    }
	
    
    public ListNode deleteDuplication_2(ListNode pHead){
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	while(pHead!=null) {
    		if(!list.contains(pHead.val)) {
    			list.add(pHead.val);
    		}else {
    			list.remove((Object) pHead.val);
    		}
    		pHead=pHead.next;
    	}
    	
    	ListNode head=null;
    	if(list.size()!=0) {
	    	//如果最后存在不重复的节点
	    	head=new ListNode(list.get(0));
	    	ListNode pre=head;
	    	for(int i=1; i<list.size(); i++) {
	    		ListNode node=new ListNode(list.get(i));
	    		pre.next=node;
	    		pre=node;
	    	}
    	}

    	return head;    	
    }
    
    
    public ListNode deleteDuplication_3(ListNode pHead){
    	
    	if(pHead==null || pHead.next==null) {
    		return pHead;
    	}
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	ListNode head=pHead, second=pHead, third=pHead;
    	while(pHead!=null) {
    		map.put(pHead.val, map.getOrDefault(pHead.val, 0)+1);
    		pHead=pHead.next;
      	}
    	ListNode res=null, pre;
    	pre=res;
    	for(Entry<Integer, Integer> en : map.entrySet()) {
    		if(en.getValue()==1) {
    			res=new ListNode(en.getKey());
    		}
    	}
    	
    	
    	return null;
    }
    
    /**
     * 遍历一次使用map记录每个值出现的次数，list记录节点的值，最后使用list重建
     * 链表
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead){
    	
    	if(pHead==null || pHead.next==null) {
    		return pHead;
    	}
    	
    	List<Integer> list=new ArrayList<Integer>();
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	//
    	while(pHead!=null) {
    		map.put(pHead.val, map.getOrDefault(pHead.val, 0)+1);
    		if(!list.contains(pHead.val)) {
    			list.add(pHead.val);	
    		}
    		pHead=pHead.next;
    	}
    	//去重
    	for(Entry<Integer, Integer> en : map.entrySet()) {
    		
    		if(en.getValue()>=2) {
    			list.remove((Object) en.getKey());
    		}
    	}
    	ListNode head=null;
    	ListNode pre;
    	if(list.size()!=0) {
        	head=new ListNode(list.get(0));
        	pre=head;
    	}else {
    		return head;
    	}
    	
    	for(int i=1; i<list.size(); i++) {
    		ListNode node=new ListNode(list.get(i));
    		pre.next=node;
    		pre=node;
    	}
    	return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 2 3 3 4 4 5----->1 2 5
//		ListNode n1=new ListNode(1);
//		ListNode n2=new ListNode(2);
//		ListNode n3=new ListNode(3);
//		ListNode n4=new ListNode(3);
//		ListNode n5=new ListNode(4);
//		ListNode n6=new ListNode(4);
//		ListNode n7=new ListNode(5);
//		
//		n1.next=n2;
//		n2.next=n3;
//		n3.next=n4;
//		n4.next=n5;
//		n5.next=n6;
//		n6.next=n7;
		
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(1);
		ListNode n4=new ListNode(1);
		ListNode n5=new ListNode(1);
		ListNode n6=new ListNode(1);
		ListNode n7=new ListNode(1);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		
		DeleteCopyNode dcn=new DeleteCopyNode();
		ListNode res=dcn.deleteDuplication(n1);
		while(res!=null) {
			System.out.print(res.val+"\t");
			res=res.next;
		}
	}

}
