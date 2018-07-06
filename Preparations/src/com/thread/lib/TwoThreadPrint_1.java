package com.thread.lib;

public class TwoThreadPrint_1 {
	
	int  nStart=1;
	char cStart='a';
	int delta=2;
	boolean cprint=false;

	public synchronized void chars() {
		try {
			if(cprint==false) {
				wait();
			}
			int i=0;
			while(i<delta) {
				System.out.print(cStart+"\t");
				i++;
				cStart++;
			}
			
			cprint=false;
			notify();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void nums() {
		try {
			if(cprint==true) {
				wait();
			}
			int i=0;
			while(i<delta) {
				System.out.print(nStart+"\t");
				i++;
				nStart++;
			}
			
			cprint=true;
			notify();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoThreadPrint_1 ttp=new TwoThreadPrint_1();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<15; i++) {
					ttp.chars();
				}
			}
			
		}).start();
		
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<15; i++) {
					ttp.nums();
				}
			}
			
		}).start();
	}

}
