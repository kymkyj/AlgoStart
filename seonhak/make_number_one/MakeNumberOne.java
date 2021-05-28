package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeNumberOne {

	static Integer[] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int inputNumber = Integer.valueOf(br.readLine());
		
		dp = new Integer[inputNumber + 1];
		dp[0] = dp[1] = 0;
		
		int result = recur(inputNumber);
		
		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();

	}

	public static int recur(int N) {
		 
		if (dp[N] == null) {
			// 6으로 나눠지는 경우 
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		
		return dp[N];
	}
	

//	static int recur(int N, int count) {
//		// N이 2 미만인 경우 누적된 count값을 반환
//		if (N < 2) {
//			return count;
//		}
//		return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));
// 
//	}

}
