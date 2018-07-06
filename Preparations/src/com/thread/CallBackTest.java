package com.thread;

/**
 * 测试在run方法结束之后
 * 运行回调的方法
 * @author Administrator
 *
 */
public class CallBackTest implements Runnable{

	private boolean flag=false;
	
	

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始执行耗时运算");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("运行结束");
		setFlag(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallBackTest cb=new CallBackTest();
		System.out.println("before :"+cb.isFlag());
		new Thread(new CallBackTest()).start();
		System.out.println("after :"+cb.isFlag());
	}
}
