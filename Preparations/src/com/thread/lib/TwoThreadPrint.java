package com.thread.lib;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadPrint {

	Lock lock=new ReentrantLock();
	Condition nums=lock.newCondition();
	Condition chars=lock.newCondition();
	boolean flag=false;
	//每次允许打印的个数
	int delta=2;
	//两个线程打印的开始元素
	int start=1;
	char cStart='a';
	
	public void nums() {
		lock.lock();
		try {
			if(flag==false) {
				nums.await();
			}
			int i=0;
			while(i<delta) {
				System.out.print(start+"\t");
				i++;
				start++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			flag=false;
			chars.signal();
			lock.unlock();
		}
	}
	
	public void chars() {
		lock.lock();
		try {
			if(flag==true) {
				chars.await();
			}
			int i=0;
			while(i<delta) {
				System.out.print(cStart+"\t");
				i++;
				cStart++;
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			flag=true;
			nums.signal();
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoThreadPrint tp=new TwoThreadPrint();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<15; i++) {
					tp.chars();
				}
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<15; i++) {
					tp.nums();
				}
			}
			
		}).start();
	}

}
