package com.ji.study;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Solution_42839_Test {

	@Test
	void test() {
		
		Solution_42839 test = new Solution_42839();
		
		assertEquals(3, test.solution("17"));
		assertEquals(2, test.solution("011"));
		assertEquals(1, test.solution("2"));
		assertEquals(12, test.solution("7843"));
		assertEquals(0, test.solution("9999999"));
		assertEquals(1336, test.solution("1276543"));
		
	}

}
