package com.ji.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.ji.study.RecommNewId;

public class RecommNewIdTest {
	
	@Test
	void test() {
		
		RecommNewId test = new RecommNewId();
		
		assertEquals("bat.y.abcdefghi", test.solution("...!@BaT#*..y.abcdefghijklm"));
		assertEquals("z--", test.solution("z-+.^."));
		assertEquals("aaa", test.solution("=.="));
		assertEquals("123_.def", test.solution("123_.def"));
		assertEquals("abcdefghijklmn", test.solution("abcdefghijklmn.p"));
		
	}

}
