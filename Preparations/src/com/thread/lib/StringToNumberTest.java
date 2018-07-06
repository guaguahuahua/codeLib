package com.thread.lib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringToNumberTest {

	StringToNumber stn=new StringToNumber();
	
	@Test
	void test() {
		String s="+100";
		boolean res=stn.isNumeric(s.toCharArray());
		assertTrue(res);
	}

	@Test
	void test1() {
		String s="5e2";
		boolean res=stn.isNumeric(s.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test2() {
		String s="-123";
		boolean res=stn.isNumeric(s.toCharArray());
		assertTrue(res);
	}

	@Test
	void test3() {
		String s="3.1232";
		boolean res=stn.isNumeric(s.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test4() {
		String s="-1E-16";
		boolean res=stn.isNumeric(s.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test5() {
		String s="12e";
		boolean res=stn.isNumeric(s.toCharArray());
		assertFalse(res);
	}
	
	@Test
	void test6() {
		String s="1a3.14";
		boolean res=stn.isNumeric(s.toCharArray());
		assertFalse(res);
	}
	@Test
	void test7() {
		String s="1.2.3";
		boolean res=stn.isNumeric(s.toCharArray());
		assertFalse(res);
	}
	@Test
	void test8() {
		String s="+-5";
		boolean res=stn.isNumeric(s.toCharArray());
		assertFalse(res);
	}
	@Test
	void test9() {
		String s="12e+4.3";
		boolean res=stn.isNumeric(s.toCharArray());
		assertFalse(res);
	}
	
}
