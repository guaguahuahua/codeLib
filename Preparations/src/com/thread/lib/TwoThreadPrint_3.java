package com.thread.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TwoThreadPrint_3 {
	
	private char cStart='a';
	private int  nStart=1;
	private int delta=2;
	private boolean cprint=true;
	private PipedOutputStream po;
	private PipedInputStream pi;
	
	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public PipedOutputStream getPo() {
		return po;
	}

	public void setPo(PipedOutputStream po) {
		this.po = po;
	}
	
	public PipedInputStream getPi() {
		return pi;
	}

	public void setPi(PipedInputStream pi) {
		this.pi = pi;
	}


	
	public synchronized void chars() {
		try {
			if(cprint==false) {
				wait();
			}
			//��ӡ�ַ�
			int i=0;
			while(i<delta) {
				System.out.print(cStart+"\t");
				i++;
				cStart++;
			}
			//������һ���̷߳�������
			String infors="";
			infors=infors+nStart+"\t";
			nStart++;
			infors=infors+nStart+"\t";
			nStart++;
			po.write(infors.getBytes());
			po.flush();
			po.close();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cprint=false;
			notify();
		}
	} 
	
	
	public synchronized void nums() {
		try {
			if(cprint==true) {
				wait();
			}
			//��������һ���̵߳�������������д�ӡ
			BufferedReader br=new BufferedReader(new InputStreamReader(pi));
			String s="";
			while((s=br.readLine())!=null) {
				System.out.print(s);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cprint=true;
			notify();
		}
	}
}
