package com.thread.lib;

import java.util.LinkedList;

/**
 * ʵ��ͬ����linkedList
 * ��Ϊֻ�������߳���ʹ�øö�����Դ������ʹ�õ���notify������notifyAll�������
 * @author Administrator
 *
 */
public class MyLinkedList {

	private LinkedList<Integer> queue=new LinkedList<Integer>();
	private boolean hold=false;
	
	public synchronized void add(int num) {

		try {
			//������̳߳�����������ô���еȴ�״̬
			if(hold==true) {
				wait();
			}
			//���û���̳߳��������
			queue.add(num);
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
		
	}
	
	public synchronized int poll() {

		//������в�Ϊ��
		int res=0;
		//����������߳�����ʹ�ö���
		try {
			//�������߳���ʹ��
			if(hold==true) {
				wait();
			}
			//��������Ѿ�Ϊ�գ�ֱ���˳�
			if(queue.isEmpty()) {
				return -1;
			}
			//���в�Ϊ�գ�����
			res=queue.poll();
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}		
		return res;
	}
	
	
	public synchronized int size() {
		int size=0;
		try {
			if(hold==true) {
				wait();
			}
			size=queue.size();
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
		return size;
	}
	
	public synchronized boolean isEmpty() {
		boolean res=false;
		try {
			if(hold==true) {
				wait();
			}
			res=queue.isEmpty();
			hold=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
		return res;
	}
}
