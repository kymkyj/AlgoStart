package com.ji.algo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼
 * @author seonhak
 * @date 2021. 10. 1.
 */
public class MenuRenewal {

	static List<StrVO> biggestOrderList = new ArrayList<StrVO>();
	static Integer maxOrderCnt;

	public static void main(String[] args) throws IOException {

//		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
//		int[] course = { 2, 3, 4 };

//		String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//		int[] course = { 2,3,5 };

		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = { 2,3,4 };

		for (String res : solution(orders, course)) {
			System.out.print(res + " ");
		}

	}

	public static String[] solution(String[] orders, int[] course) throws IOException {

		String[] answer = {};
		List<String> result = new ArrayList<>();

		for (int cour : course) {
			
			biggestOrderList = new ArrayList<StrVO>();
			maxOrderCnt = Integer.MIN_VALUE;
			for (String order : orders) {
				char[] arr = order.toCharArray();
				boolean[] visited = new boolean[order.length()];
				combination(arr, visited, 0, 0, cour, orders);
			}
			
			for (StrVO orderInfo : biggestOrderList) {
				if (orderInfo.cnt == maxOrderCnt) {
					if (!result.contains(orderInfo.str))
						result.add(orderInfo.str);
				}
			}

		}

		Collections.sort(result);
		
		answer = new String[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}

	public static void combination(char[] arr, boolean[] visited, int idx, int n, int r, String[] orders)
			throws IOException {
		if (n == r) {
			
			Arrays.sort(arr); //순서 보장!!!
			
			String str = "";
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					str += arr[i];
				}
			}

			int sameOrder = 0;
			for (String order : orders) {
				int cnt = 0;
				for (char st : str.toCharArray()) {
					for (char ch : order.toCharArray()) {
						if (st == ch) //동일한 문자열 있는지 검사
							cnt++; 
					}
				}
				
				//만들 수 있는 문자열 중에서 r개 이상 문자열이 같은 경우
				if (cnt >= r) 
					sameOrder++;
			}

			// 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만
			if (sameOrder >= 2) {
				biggestOrderList.add(new StrVO(str, sameOrder));
				if (maxOrderCnt <= sameOrder) //최대 주문 갯수 저장
					maxOrderCnt = sameOrder;
			}
			
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			combination(arr, visited, i, n + 1, r, orders);
			visited[i] = false;
		}
	}

}

class StrVO {
	String str;
	int cnt;

	public StrVO(String str, int cnt) {
		super();
		this.str = str;
		this.cnt = cnt;
	}

}
