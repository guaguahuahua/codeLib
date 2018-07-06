package com.thread.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TwoThreadPrint_2 {
	
	int cStart='a';
	int nStart=1;
	int delta=5;
	
	static int terminal=15;
	boolean cprint=false;
	
	public synchronized void chars(PipedOutputStream po) {
		
		try {
			if(cprint==true) {
				wait();
			}
			int i=0;
			while(i<delta) {
				System.out.print((char) cStart+"\t");
				cStart++;
				i++;
			}
			
			i=0;
			String s="";
			while(i<delta) {
				s=s+nStart+"\t";
				nStart++;
				i++;
			}
			po.write(s.getBytes());
			po.flush();
			po.close();
			cprint=true;		
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
	}
	
	
	public synchronized void nums(PipedInputStream pi) {
		try {
			if(cprint==false) {
				wait();
			}
			
			BufferedReader br=new BufferedReader(new InputStreamReader(pi));
			String s="";
			while((s=br.readLine())!=null) {
				System.out.print(s);
			}
			cprint=true;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoThreadPrint_2 ttp=new TwoThreadPrint_2();
				
		PipedOutputStream po=new PipedOutputStream();
		PipedInputStream pi=new PipedInputStream();
		
		try {
			po.connect(pi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ttp.nums(pi);

			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ttp.chars(po);
			}
			
		}).start();


	}
}
