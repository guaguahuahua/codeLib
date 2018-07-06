package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CallbackCheck {

	//线程同步锁
	ReentrantLock lock=new ReentrantLock();
	Condition locator=lock.newCondition();
	Condition other=lock.newCondition();
	
	//回调方法
	CallbackTest_1 ct=new CallbackTest_1();
	TestCallback tb=new TestCallback(ct);
	
	//模拟定位
	public void locate() {
		lock.lock();
		System.out.println("this is locate thread !");
		try {
			if(tb.getAns()==true) {
				locator.wait();
			}
			Thread t=new Thread(tb);
			t.start();
			t.join();
			Thread.sleep(1000);			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			tb.setAns(true);
			other.signal();
			lock.unlock();
		}
		System.out.println("locate thread ends\n");
	}
	
	//模拟后续的线程
	public void others() {
		lock.lock();
		System.out.println("this is other-threads !");
		
		try {
			while(tb.getAns()==false) {
				other.wait();
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			locator.signal();
			lock.unlock();			
		}
		System.out.println("other-threads ends\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallbackCheck cbk=new CallbackCheck();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				cbk.locate();
			}
		}).start();
				
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				cbk.others();
			}
		}).start();
		
	}

}
