package com.thread.lib;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageQueue {
	
	/**
	 * �����Ϣ�Ķ��У����û��ʹ��LinkedList ԭ���Ƕ��߳�ʹ�øö��е�ʱ����Ҫ����ͬ����Ҫô�Զ���һ�����У�ʹ�ö��е�
	 * ��Ӻͳ��Ӷ���ͬ���ģ��������ʹ��ֱ�ӵ�ConcurrentLinkedQueue��ʵ�ֲ���ͬ������
	 */
//	ConcurrentLinkedQueue<Integer> queue=new ConcurrentLinkedQueue<Integer>(); 
	MyLinkedList ml=new MyLinkedList();
	static int start=0;
	
	/**
	 * ������Ϣ
	 */
	public void sender() {
		try {
			
			for(; start<20; start++) {
//				queue.add(start);
				ml.add(start);
				System.out.println("sender puts "+start);
//				System.out.println("sender, ����Ԫ�ص�����Ϊ��"+queue.size());
				System.out.println("sender, ����Ԫ�ص�����Ϊ��"+ml.size());
				Thread.sleep(2000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	public void receiver() {
		try {
			
//			//����Ϣ������ȡ��Ϣ���д���
//			while(queue.size()>0) {
//				if(queue.isEmpty()) {
//					Thread.sleep(2000);
//				}
//				int temp=queue.poll();
//				System.out.println("receiver gets "+temp);
//				System.out.println("receiver, ����Ԫ�ص�����Ϊ��"+queue.size());
//				Thread.sleep(3000);
//			}
			
			while(ml.size()>0) {
				if(ml.isEmpty()) {
					Thread.sleep(2000);
				}
				int temp=ml.poll();
				System.out.println("receiver gets "+temp);
				System.out.println("receiver, ����Ԫ�ص�����Ϊ��"+ml.size());
				Thread.sleep(3000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MessageQueue mq=new MessageQueue();
		//������
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mq.sender();
			}
			
		}).start();
		
		
		//������
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mq.receiver();
			
			}
			
		}).start();
	}

}
