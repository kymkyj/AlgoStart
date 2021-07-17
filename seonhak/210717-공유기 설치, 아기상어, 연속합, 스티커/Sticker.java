package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
 
public class Sticker {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
        int[][] arr;
        int[][] dp;
        String[] str;
        
        for (int t = 0; t < testCase; t++) {
        	
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1][2];
            dp = new int[N+1][2];
            for (int i = 0; i < 2; i++) {
                str = br.readLine().split(" ");
                for (int j = 1; j <=N; j++) {
                    arr[j][i] = Integer.parseInt(str[j-1]);
                }
            }
            
            //0번째, 1번째의 행의 첫 번째 열이 초기화로 초기값
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];
            
            for(int i=2; i<=N; i++){
            	// 대각선의 스티커 
            	// 대각선의 왼쪽 혹은 대각선의 오른쪽 스티커를 떼어 냈을 경우
                dp[i][0] = Math.max(dp[i-1][1],dp[i-2][1] ) + arr[i][0]; 
                dp[i][1] = Math.max(dp[i-1][0],dp[i-2][0] ) + arr[i][1];
            }
            
            //N번 째 열의 최댓값을 반환 후 출력
            bw.write(String.valueOf(Math.max(dp[N][0], dp[N][1]))+"\n");
            
        }
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
