package com.thread.lib;

import java.io.PipedOutputStream;

public class CharThread implements Runnable{

	private PipedOutputStream po;
	private TwoThreadPrint_3 ttp=new TwoThreadPrint_3();
	
	public CharThread(PipedOutputStream po) {
		this.po=po;
		ttp.setPo(po);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub	

//		for(int i=0; i<15; i++) {
			ttp.chars();	
//		}		
	}

}
