package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 구간합구하기5
 * @author ji
 *
 */
public class IntervalSum5 {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] sizeSumCountStr = br.readLine().split(" ");
		int gridSize = Integer.valueOf(sizeSumCountStr[0]);
		int sumCount = Integer.valueOf(sizeSumCountStr[1]);

		int[][] numbersMap = new int[gridSize+1][gridSize+1];
		int[][] dp = new int[gridSize+1][gridSize+1];


		for (int i = 1; i <= gridSize; i++) {
			String[] points = br.readLine().split(" ");
			for (int j = 1; j <= gridSize; j++) {
				numbersMap[i][j] = Integer.valueOf(points[j-1]);
				//dp안에 0,0부터 특정 배열까지의 값들은 더해 놓음!!!
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp [i-1][j-1] + numbersMap[i][j];

			}
		}

		for (int k = 1; k <= sumCount; k++) {
			String[] points = br.readLine().split(" ");
			int x1 = Integer.valueOf(points[0]);
			int y1 = Integer.valueOf(points[1]);
			int x2 = Integer.valueOf(points[2]);
			int y2 = Integer.valueOf(points[3]);

			//마지막 포인트 합에서 이전 포인트의 값들을 빼줌!!!
			int sum=dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];

			bw.write(String.valueOf(sum) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}

