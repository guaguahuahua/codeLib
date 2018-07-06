package com.thread.lib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegexMathing_1Test {
	RegexMatching_1 rm=new RegexMatching_1();
	
	@Test
	void test() {
		String s1="aaa";
		String s2="ab*ac*a";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertTrue(res);
	}

	@Test
	void test1() {
		String s1="aaa";
		String s2="a.a";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test2() {
		String s1="aa.a";
		String s2="ab*a";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertFalse(res);
	}
	
	@Test
	void test3() {
		String s1="aa.a";
		String s2="a*a";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertFalse(res);
	}
	
	@Test
	void test4() {
		String s1="";
		String s2="_";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertFalse(res);
	}
	
	@Test
	void test5() {
		String s1="";
		String s2="";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test6() {
		String s1=".";
		String s2="";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertFalse(res);
	}
	
	@Test
	void test7() {
		String s1=" ";
		String s2=" ";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test8() {
		String s1="a";
		String s2="..*";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test9() {
		String s1="";
		String s2=".";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertFalse(res);
	}
	
	@Test
	void test10() {
		String s1="";
		String s2="c*";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertTrue(res);
	}
	
	@Test
	void test11() {
		String s1="a";
		String s2="a.";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertFalse(res);
	}
	
	@Test
	void test12() {
		String s1="a";
		String s2="a*";
		boolean res=rm.match(s1.toCharArray(), s2.toCharArray());
		assertTrue(res);
	}
}
