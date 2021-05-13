package com.ji.study;

import java.util.ArrayList;
import java.util.List;

public class Printer {

	public static void main(String[] args) {

		int[] priori = { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		System.out.println("result : " + solution(priori, location));

	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;

		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < priorities.length; i++) {
			list.add(new int[] {i, priorities[i]});
		}

		List<int[]> result = getCompareNum(list);
		for (int j = 0; j < result.size(); j++) {
			if (result.get(j)[0] == location)
				answer = j;
		}

		return answer + 1;
	}

	public static List<int[]> getCompareNum(List<int[]> list) {

		for (int i = 0; i < list.size() - 1; i++) {
			for (int k = i + 1; k < list.size(); k++) {
				// 중요도가 높은 인쇄물이 있을 경우
				if (list.get(i)[1] < list.get(k)[1]) {
					return getCompareNum(shiftLastIndex(list, i));
				}
			}
		}
		
		return list;
		
	}

	// 가장 앞에 있는 대기 목록을 뒤로 이동
	public static List<int[]> shiftLastIndex(List<int[]> list, int moveIndex) {
		list.add(list.get(moveIndex));
		list.remove(moveIndex);
		return list;
	}

}
