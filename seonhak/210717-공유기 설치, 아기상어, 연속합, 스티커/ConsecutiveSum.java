package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConsecutiveSum {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer numberCount = Integer.valueOf(br.readLine());

		int[] dp = new int[numberCount];
		int[] numbersArr = new int[numberCount];

		String[] inputNumbers = br.readLine().split(" ");
		for (int i = 0; i < numberCount; i++)
			numbersArr[i] = Integer.valueOf(inputNumbers[i]);
		
		dp[0] = numbersArr[0];
		int max = numbersArr[0];
		//bottom-up
		for(int i =1 ; i<numberCount; i++ ) {
				dp[i] = Math.max(dp[i-1]+numbersArr[i], numbersArr[i]);
				
				max = Math.max(max, dp[i]);
		}

		bw.write(String.valueOf(max));

		br.close();
		bw.flush();
		bw.close();
	}

}
