package com.ji.study;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxMin {

	public static void main(String[] args) {
		String numStr = "1 2 3 4";
		System.out.println(solution(numStr));
	}

	public static String solution(String s) {
		String answer = "";
		
		String[] numStrArr = s.split(" ");
		
		List<Integer> numList = Stream.of(numStrArr).parallel().map(Integer::parseInt).collect(Collectors.toList());
		
		answer +=String.valueOf(Collections.min(numList))+" "+String.valueOf(Collections.max(numList));
		
		return answer;
	}

}
