package com.thread.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ������������
 * @author Administrator
 *
 */
public class ProducerAndConsumer {

	private int yu=12;
	int count=0;
	int index=0;
	int once=1;
	public boolean hasResource=false;
	
	public synchronized void producer() {
		//�������Դ����ô�������߳�
		try {
			if(hasResource==true) {
				wait();
			}
			int i=0;
			while(i<once) {
				index++;
				System.out.println("producer puts"+index);
				i++;
			}
			hasResource=true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
	}
	
	public synchronized void consumer() {
		//���û����Դ����ô�������߳�
		try {
			if(hasResource==false) {
				wait();
			}
			int i=0;
			while(i<once) {
				System.out.println("consumer gets"+index);
				i++;
			}
			hasResource=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerAndConsumer pc=new ProducerAndConsumer();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<12; i++) {
					pc.producer();
				}
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<12; i++) {
					pc.consumer();
				}
			}
			
		}).start();
		
		List list=Collections.synchronizedList(new ArrayList());
		Map map=Collections.synchronizedMap(new HashMap());
	}

}
