package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 포도주 시식
 * @author ji
 *
 */
public class WineTasting {

	static Integer[] dp;
	static int[] wineAmountArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int wineCount = Integer.valueOf(br.readLine());
		
		wineAmountArr = new int[wineCount+1];
		dp = new Integer[wineCount+1];
		
		for(int i=1; i<wineCount+1; i++) {
			wineAmountArr[i] = Integer.valueOf(br.readLine());
		}
		dp[0] = 0;
		dp[1] = wineAmountArr[1];
		
		if(wineCount > 1) {
			dp[2] = wineAmountArr[1] + wineAmountArr[2];
		}

		bw.write(String.valueOf(recur(wineCount)));
		
		//Bottom-Up
//		dp[1] = wineAmountArr[1];
//		if (wineCount > 1) {
//			dp[2] = wineAmountArr[1] + wineAmountArr[2];
//		}
//		for (int i = 3; i <= wineCount; i++) {
//			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wineAmountArr[i], dp[i - 3] + wineAmountArr[i - 1] + wineAmountArr[i]));
//		}
//		System.out.println(dp[wineCount]);
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	//Top-Down
	static int recur(int N) {
		
		//각 노드의 이전의 최대값과 비교, 조합 가능한 최대값을 저장
		if(dp[N] == null) {
			dp[N] = Math.max(
										Math.max( recur(N - 2),  recur(N - 3) + wineAmountArr[N - 1] ) 
										+ wineAmountArr[N]
										, 
										recur(N - 1)
									 );
		}
		
		return dp[N];
	}
	

}
