package com.thread.lib;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageQueue {
	
	/**
	 * 存放消息的队列，这块没有使用LinkedList 原因是多线程使用该队列的时候需要进行同步，要么自定义一个队列，使得队列的
	 * 入队和出队都是同步的，否则就是使用直接的ConcurrentLinkedQueue来实现并发同步队列
	 */
//	ConcurrentLinkedQueue<Integer> queue=new ConcurrentLinkedQueue<Integer>(); 
	MyLinkedList ml=new MyLinkedList();
	static int start=0;
	
	/**
	 * 发送消息
	 */
	public void sender() {
		try {
			
			for(; start<20; start++) {
//				queue.add(start);
				ml.add(start);
				System.out.println("sender puts "+start);
//				System.out.println("sender, 队列元素的数量为："+queue.size());
				System.out.println("sender, 队列元素的数量为："+ml.size());
				Thread.sleep(2000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	public void receiver() {
		try {
			
//			//从消息队列中取消息进行处理
//			while(queue.size()>0) {
//				if(queue.isEmpty()) {
//					Thread.sleep(2000);
//				}
//				int temp=queue.poll();
//				System.out.println("receiver gets "+temp);
//				System.out.println("receiver, 队列元素的数量为："+queue.size());
//				Thread.sleep(3000);
//			}
			
			while(ml.size()>0) {
				if(ml.isEmpty()) {
					Thread.sleep(2000);
				}
				int temp=ml.poll();
				System.out.println("receiver gets "+temp);
				System.out.println("receiver, 队列元素的数量为："+ml.size());
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
		//发送者
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mq.sender();
			}
			
		}).start();
		
		
		//接收者
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mq.receiver();
			
			}
			
		}).start();
	}

}
