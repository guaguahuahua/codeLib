package com.thread.lib;

public class JoinNow {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JoinTest jt=new JoinTest("zhou");
		Thread f=new Thread(jt);
		f.start();
		
		jt=new JoinTest("wang");
		Thread s=new Thread(jt);
		s.start();
		
		jt=new JoinTest("yin");
		Thread t=new Thread(jt);
		t.start();
		
		try {
//			f.join();
//			s.join();
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<10; i++) {
			System.out.println("main thread is in charge now !");	
		}		
	}

}
