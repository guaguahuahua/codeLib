package com.thread.lib;

import com.datastruct.ListNode;

public class EntranceOfLinkedList {

    public ListNode EntryNodeOfLoop(ListNode pHead)    {
    	//头结点为空或者是单个节点
    	if(pHead==null || pHead.next==null) {
    		return null;
    	}
    	
    	ListNode s=pHead, f=pHead;
    	while(f!=null && f.next!=null) {
    		s=s.next;
    		f=f.next.next;
    		if(s==f) {
    			break;
    		}
    	}
    	
    	//判断是否有环
    	if(s!=null && f!=null && s==f) {
    		s=pHead;
    		while(s!=f) {
    			s=s.next;
    			f=f.next;
    		}
    	}
        return s;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n5;
		EntranceOfLinkedList el=new EntranceOfLinkedList();
		ListNode res=el.EntryNodeOfLoop(n1);
		if(res!=null) {
			System.out.println(res.val);	
		}else {
			System.out.println(res);
		}
		
	}

}
