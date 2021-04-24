package com.ji.study;

import java.util.ArrayList;
import java.util.List;

public class FindPrime {

	/**
	 * 소수는 1과 자기 자신으로만 나누어지는 수임
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String input = "1276543";
		System.out.println(solution(input));

	}

	public static int solution(String numbers) {
		int answer = 0;

		// 숫자 조합 저장 리스트
		List<Integer> makeNumber = new ArrayList<Integer>();
		List<Integer> onlyNumber = new ArrayList<Integer>();

		// input 숫자 초기화
		char[] numToArr = numbers.toCharArray();
		Integer len = numToArr.length;

		// dfs를 이용한 입력된 숫자가 조합할 수 있는 모든 경우의 수 저장
		dfs(0, initNodeValue(numToArr, len), new int[len], new boolean[len], makeNumber);

		// 중복 숫자 제거
		for (Integer num : makeNumber) {
			if (!onlyNumber.contains(num))
				onlyNumber.add(num);
		}

		// 소수인 경우
		for (Integer num : onlyNumber) {
			if (isPrimeNumber(num))
				answer++;
		}

		return answer;
	}

	public static int[] initNodeValue(char[] numToArr, Integer numLength) {
		int[] result = new int[numLength];
		for (int i = 0; i < numLength; i++) {
			String numStr = String.valueOf(numToArr[i]);
			result[i] = Integer.valueOf(numStr);
		}
		return result;
	}

	public static void dfs(int n, int[] arr, int[] result, boolean[] visit, List<Integer> makeNumber) {
		if (n == arr.length) {// 입력된 숫자 길이 만큼의 경우의 숫자들

			// 모든 경우의 숫자들에서 한자리씩 감소하는 경우의 숫자 예외 처리
			int resultLength = result.length;
			while (resultLength > 0) {
				String numStr = "";
				for (int i = 0; i < resultLength; i++) {
					numStr += result[i];
				}

				if (numStr != "")
					makeNumber.add(Integer.valueOf(numStr));

				resultLength--;
			}

		} else {

			for (int i = 0; i < arr.length; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[n] = arr[i];
					dfs(n + 1, arr, result, visit, makeNumber);
					visit[i] = false;
				}
			}

		}
	}

	public static boolean isPrimeNumber(int number) {
		boolean result = true;

		if (number == 1 || number == 0)
			return false;

		for (int i = 2; i < number; i++) {
			if (number % i == 0) { // 나누어 떨어지는 지 확인
				result = false;
				break;
			}
		}
		return result;
	}

}
