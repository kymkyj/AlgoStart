package com.ji.study;

public class NumberExpression {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

	public static int solution(int n) {

		int count = 0;
		
		int startIndex = 1;
		while (startIndex <= n) {

			int sum = 0;
			for (int i = startIndex; i <= n; i++) {
				// 하나씩 증가하면 더해봄
				sum += i;
				
				if (sum == n)
					count++;
				if (sum >= n) {
					startIndex++;
					break;
				}

			}

		}

		return count;
	}

}
