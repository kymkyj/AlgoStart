package com.ji.study;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(solution(1234156));
	}

	public static int solution(int n) {
		int answer = 0;
		
		// f(3) = f(1)+f(2) = 1+1 = 2이므로 숫자 초기화
		int oldBeforeNum = 1;
		int beforeNum = 1;

		if (n == 1 || n == 2) {
			return 1;
		} else {
			for (int i = 3; i <= n; i++) {
				answer = (oldBeforeNum + beforeNum) % 1234567;
				oldBeforeNum = beforeNum;// 전전수
				beforeNum = answer;// 전수
			}
			return answer;
		}
		
	}

}
