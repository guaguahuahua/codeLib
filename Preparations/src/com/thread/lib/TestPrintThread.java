package com.thread.lib;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPrintThread {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PipedInputStream pi=new PipedInputStream();
		PipedOutputStream po=new PipedOutputStream();
		
		pi.connect(po);
		
		CharThread ct=new CharThread(po);
		new Thread(ct).start();
		
		NumThread nt=new NumThread(pi);
		new Thread(nt).start();
	}

}
