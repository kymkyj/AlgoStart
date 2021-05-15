package com.ji.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeMinMum {
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2};
		int[] B = new int[] {3,4};
		System.out.println(solution(A, B));
	}
	
	public static int solution(int[] A, int[] B) {
		int answer = 0;
		
		List<Integer> descending = new ArrayList<Integer>();
		List<Integer> ascending = new ArrayList<Integer>();
		
		for(int a: A)
			descending.add(a);
		Collections.sort(descending, Collections.reverseOrder());
		for(int b: B)
			ascending.add(b);
		Collections.sort(ascending);
		
		int sum = 0;
		for(int i=0; i < ascending.size();i++) {
			sum =sum+ascending.get(i)*descending.get(i);
		}

		answer = sum;
		return answer;
	}

}
