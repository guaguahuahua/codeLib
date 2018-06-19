package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock {

	final static int LEN=10;
	Lock lock=new ReentrantLock();
	Condition full=lock.newCondition();
	Condition empty=lock.newCondition();
	int []array=new int[LEN];
	int count=0;
	int putptr=0;
	int getptr=0;
			
	
	public void put(int data){
		lock.lock();
		try {
			while(count==array.length) {
				full.await();
			}
			System.out.println("put data:"+data);
			array[putptr]=data;
			putptr++;
			count++;
			empty.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int get() {
		lock.lock();
		int getItem=Integer.MIN_VALUE;
		try {
			while(getptr==putptr) {
				empty.wait();
			}
			getItem=array[getptr];
			getptr++;
			full.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return getItem;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadLock tlock=new ThreadLock();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<LEN; i++) {
					tlock.put(i);
				}
			}			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<LEN; i++) {
					System.out.println("get data:"+tlock.get());
				}				
			}			
		}).start();
		
	}
}
