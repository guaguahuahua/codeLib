package com.thread;

public class TestCallback implements Runnable{

	private boolean ans=false;
	
	private CallbackTest_1 call;
	
	//构造方法
	public TestCallback(CallbackTest_1 call) {
		this.call=call;
	}
	
	public void setAns(boolean ans) {
		this.ans=ans;
	}
	
	public boolean getAns() {
		return ans;
	}
	
	public void handler(CallbackTest_1 call) {
		
		new Thread(new Runnable() {
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ans=call.sendMessage("线程睡眠结束！");
				System.out.println(ans);
			}
			
		}).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ans=call.sendMessage("线程睡眠结束！");
		System.out.println(ans);
	}

}
