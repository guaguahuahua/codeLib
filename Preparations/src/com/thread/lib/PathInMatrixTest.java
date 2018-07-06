package com.thread.lib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PathInMatrixTest {

	PathInMatrix pim=new PathInMatrix();
	
	@Test
	void test() {
		char []matrix= {'a', 'b', 'c', 'e',
						's', 'f', 'c', 's',
						'a', 'd', 'e', 'e'
					   };
		char []str= {'a', 'b', 'c', 'b'};	
		boolean res=pim.hasPath(matrix, 3, 4, str);
		assertFalse(res);
	}
	
	@Test
	void test1() {
		char []matrix= {'a', 'b', 'c', 'e',
						's', 'f', 'c', 's',
						'a', 'd', 'e', 'e'
					   };
		char []str= {'b', 'c', 'c', 'e', 'd'};
		boolean res=pim.hasPath(matrix, 3, 4, str);
		assertTrue(res);
	}
	
	@Test
	void test2() {
		char []matrix= {'a', 'b', 'c', 'e',
						's', 'f', 'c', 's',
						'a', 'd', 'e', 'e'
					   };
		char []str= {'s', 'e', 'e'};
		boolean res=pim.hasPath(matrix, 3, 4, str);
		assertTrue(res);
	}
}
