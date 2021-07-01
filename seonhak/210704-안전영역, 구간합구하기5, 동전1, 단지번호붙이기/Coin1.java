package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 동전1
 * @author ji
 *
 */
public class Coin1 {

	static int[] dp;
	static int[] coinTypes;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] condition = br.readLine().split(" ");
		int coinType = Integer.valueOf(condition[0]);
		int targetNum = Integer.valueOf(condition[1]);
		
		coinTypes = new int[coinType+1];
		dp = new int[targetNum + 1];
		dp[0] = 1;
		
		for(int i=1; i <= coinType; i++) {
			coinTypes[i] = Integer.valueOf(br.readLine());
			for(int j=coinTypes[i]; j <= targetNum; j++) {
				//dp 안에 각 동전 금액에 따라서 targetNumber가 되는 과정을 dp에 저장하여 처리
				dp[j] += dp[j - coinTypes[i]];
			}
		}
		
		bw.write(String.valueOf(dp[targetNum]));
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
}
