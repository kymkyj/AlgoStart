package com.ji.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.ji.study.Cache;

public class CacheTest {
	
	@Test
	void test() {
		
		Cache test = new Cache();
		
		assertEquals(50, test.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		assertEquals(21, test.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		assertEquals(60, test.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		assertEquals(52, test.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		assertEquals(25, test.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		assertEquals(16, test.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
		
	}

}
