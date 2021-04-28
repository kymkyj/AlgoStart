package com.ji.study;

public class StockPrice {
	public static void main(String[] args) {

		int[] prices = { 1, 2, 3, 2, 3 };
		int[] result = solution(prices);

		for (int pri : result) {
			System.out.println(pri);
		}
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int count = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			count = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] <= prices[j]) {
					count++;
				} else {
					// 반대의 경우 값 유지 했기 때문에 count
					count++;
					break;
				}
			}
			answer[i] = count;
		}

		// 마지막 가격에 대한 상승/하강은 검사할 필요없음!!
		answer[prices.length - 1] = 0;

		return answer;
	}

}
