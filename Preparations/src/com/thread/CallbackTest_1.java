package com.thread;

public class CallbackTest_1 implements Finished {

	@Override
	public boolean sendMessage(String str) {
		// TODO Auto-generated method stub
		System.out.println("回调接口成功， 收到了"+str);
		return true;
	}

}
