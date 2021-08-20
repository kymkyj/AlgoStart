package com.ji.dfs;

public class MakeBigNumber {

	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
	}

	public static String solution(String number, int k) {
		 StringBuilder answer = new StringBuilder();

		 // String[] numberArr = number.split(""); 시간 초과 발생!!!
			char[] numberArr = number.toCharArray();

			int startIndex = 0;
			for (int i = 0; i < numberArr.length - k; i++) {
				char maxNum ='0';

				for (int j = startIndex; j <= k + i; j++) {
					if (numberArr[j]> maxNum) {
						maxNum = numberArr[j];
						//이미 선택한 최대값을 지나치기 위해서 초기화
						startIndex = j + 1;
					}
				}
				answer.append(String.valueOf(maxNum));
			}

			return answer.toString();
	}

}
