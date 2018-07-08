package com.thread.lib;

import java.util.LinkedList;

/**
 * 实现同步的linkedList
 * 因为只有两个线程在使用该队列资源，所以使用的是notify而不是notifyAll这个方法
 * @author Administrator
 *
 */
public class MyLinkedList {

	private LinkedList<Integer> queue=new LinkedList<Integer>();
	private boolean hold=false;
	
	public synchronized void add(int num) {

		try {
			//如果有线程持有了锁，那么进行等待状态
			if(hold==true) {
				wait();
			}
			//如果没有线程持有这个锁
			queue.add(num);
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
		
	}
	
	public synchronized int poll() {

		//如果队列不为空
		int res=0;
		//如果其他的线程正在使用队列
		try {
			//其他的线程在使用
			if(hold==true) {
				wait();
			}
			//如果队列已经为空，直接退出
			if(queue.isEmpty()) {
				return -1;
			}
			//队列不为空，出队
			res=queue.poll();
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}		
		return res;
	}
	
	
	public synchronized int size() {
		int size=0;
		try {
			if(hold==true) {
				wait();
			}
			size=queue.size();
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
		return size;
	}
	
	public synchronized boolean isEmpty() {
		boolean res=false;
		try {
			if(hold==true) {
				wait();
			}
			res=queue.isEmpty();
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
		return res;
	}
}
