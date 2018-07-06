package com.thread.lib;

public class JoinTest implements Runnable{

	private String whose;
	
	public void setWhose(String whose) {
		this.whose=whose;
	}
	
	public JoinTest(String name) {
		this.whose=name;
	}

	public JoinTest() {}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println(whose+" is in charge now!");
		}		
	}

}
