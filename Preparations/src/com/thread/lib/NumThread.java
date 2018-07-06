package com.thread.lib;

import java.io.PipedInputStream;

public class NumThread implements Runnable{

	private PipedInputStream pi;
	private TwoThreadPrint_3 ttp=new TwoThreadPrint_3();
	
	public NumThread(PipedInputStream pi) {
		this.pi=pi;
		ttp.setPi(pi);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
//		for(int i=0; i<15; i++) {
			ttp.nums();	
//		}		
	}

}
