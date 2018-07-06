package com.thread;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringToIntegerTest {
	
	StringToInteger sti=new StringToInteger();
	
	@Test
	void test() {
		String str="+1234";
		int res=sti.StrToInt(str);
		assertEquals(1234, res);
	}

	@Test
	void test1() {
		String str="+12";
		int res=sti.StrToInt(str);
		assertEquals(12, res);
	}
	
	@Test
	void test2() {
		String str="+1";
		int res=sti.StrToInt(str);
		assertEquals(1, res);
	}
	
	@Test
	void test3() {
		String str="+";
		int res=sti.StrToInt(str);
		assertEquals(0, res);
	}
	
	@Test
	void test4() {
		String str="-116";
		int res=sti.StrToInt(str);
		System.out.println(res);
		assertEquals(-116, res);
	}
	
	@Test
	void test5() {
		String str="123e4";
		int res=sti.StrToInt(str);
		assertEquals(0, res);
	}
	
	@Test
	void test6() {
		String str="";
		int res=sti.StrToInt(str);
		assertEquals(0, res);
	}
	
	@Test
	void test7() {
		String str=" ";
		int res=sti.StrToInt(str);
		assertEquals(0, res);
	}
	
	@Test
	void test8() {
		String str="0";
		int res=sti.StrToInt(str);
		assertEquals(0, res);
	}
}
