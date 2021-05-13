package com.ji.study;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PrinterTest {

	@Test
	void test() {

		Printer test = new Printer();

		assertEquals(5, test.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
		assertEquals(1, test.solution(new int[] { 2, 1, 3, 2 }, 2));
		assertEquals(6, test.solution(new int[] { 2,2,2,1,3,4 }, 3));

	}

}
