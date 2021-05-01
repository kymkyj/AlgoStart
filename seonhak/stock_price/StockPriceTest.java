package com.ji.study;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class StockPriceTest {
	@Test
	void test() {

		StockPrice test = new StockPrice();

		assertEquals(new int[] { 4, 3, 1, 1, 0 }, test.solution(new int[] { 1, 2, 3, 2, 3 }));
		assertEquals(new int[] { 2, 1, 1, 0 }, test.solution(new int[] { 498, 501, 470, 489 }));

	}

}
