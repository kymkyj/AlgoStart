package com.ji.study;

import java.util.ArrayList;
import java.util.List;

public class Solution_43165_Try {

	public static void main(String[] args) {

		int[] numbers = { 6,2,3,6,7,1};
		int target = 7;

		solution(numbers, target);
		System.out.println("결과 : "+solution(numbers, target));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		List<String> makeNumber = new ArrayList<String>();
		List<String> makeOnlyNumber = new ArrayList<String>();
		int len = numbers.length;
		dfs(0, initNodeValue(numbers, len), new int[len], new boolean[len], makeNumber);

		for (String number : makeNumber) {
			if (!makeOnlyNumber.contains(number))
				makeOnlyNumber.add(number);
		}

		
		List<Integer> markList = new ArrayList<Integer>();
		for (int i = 0; i < len - 1; i++) {
			markList.add(0);
		}
		
		int count = 0;
		int markIndex=markList.size()-1;
		while(true) {
			
			for (String number : makeOnlyNumber) {
				char[] signNumArr = number.toCharArray();
				int calcu = Character.getNumericValue(signNumArr[0]);
				for (int i = 1, j = 1; i < signNumArr.length-1; i++, j++) {
					if (markList.get(j-1).equals(1))
						calcu = calcu + Character.getNumericValue(signNumArr[i]);
					else
						calcu = calcu - Character.getNumericValue(signNumArr[i]);
					
				}
				if(markList.get(markList.size()-1).equals(1))
					calcu = calcu + Character.getNumericValue(signNumArr[signNumArr.length-1]);
				else
					calcu = calcu - Character.getNumericValue(signNumArr[signNumArr.length-1]);
				
				if(calcu == target) {
					count++;
					break;
				}
			}
			
			
			int sum = 0;
			for(Integer markNum : markList) {
				sum+=markNum;
			}
			if(sum == markList.size())
				break;
			
			markList.remove(markIndex);
			markList.add(markIndex, 1);
			
			markIndex--;
		}
		
		answer= count;
		return answer;
	}

	public static int[] initNodeValue(int[] numToArr, Integer numLength) {
		int[] result = new int[numLength];
		for (int i = 0; i < numLength; i++) {
			String numStr = String.valueOf(numToArr[i]);
			result[i] = Integer.valueOf(numStr);
		}
		return result;
	}

	public static void dfs(int n, int[] arr, int[] result, boolean[] visit, List<String> makeNumber) {

		if (n == arr.length) {

			String numStr = "";
			int resultLength = result.length;
			for (int i = 0; i < resultLength; i++) {
				numStr += result[i];
			}
			makeNumber.add(numStr);
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

}
