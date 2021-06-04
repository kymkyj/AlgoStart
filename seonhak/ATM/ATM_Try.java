package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ATM_Try {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int personCount = Integer.valueOf(br.readLine());
		String[] delayTime = br.readLine().split(" ");

		int[] personNumber = new int[personCount];
		int[] delayTimeNum = new int[personCount];
		for (int i = 0; i < personCount; i++) {
			personNumber[i] = i;
			delayTimeNum[i] = Integer.valueOf(delayTime[i]);
		}

		// dfs를 이용한 입력된 숫자가 조합할 수 있는 모든 경우의 수 저장
		dfs(0, personNumber, new int[personCount], new boolean[personCount], delayTimeNum);

		bw.write(String.valueOf(min));

		br.close();
		bw.flush();
		bw.close();
	}

	public static void dfs(int n, int[] arr, int[] result, boolean[] visit, int[] delayTimeNum) {
		if (n == arr.length) {

			int sumListResult = 0; 
			int sum = 0;
			for (int res : result) {
				sum += delayTimeNum[res];
				sumListResult += sum;
			}

			if (min > sumListResult)
				min = sumListResult;

		} else {

			for (int i = 0; i < arr.length; i++) {
				
				if (!visit[i]) {
					visit[i] = true;
					result[n] = arr[i];
					dfs(n + 1, arr, result, visit, delayTimeNum);
					visit[i] = false;
				}
				
			}

		}
	}

}
