package com.thread;

public class CallbackTest_1 implements Finished {

	@Override
	public boolean sendMessage(String str) {
		// TODO Auto-generated method stub
		System.out.println("�ص��ӿڳɹ��� �յ���"+str);
		return true;
	}

}
