package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
dp[n-2]+큰점프
dp[n-1]+작은 점프 중에서 작은값

매우큰 점프는
dp[n]-dp[n-3]의 값들중 max 값이 k보다 크면 그만큼 값중에 k로 바꿔치기..?

 */
public class SteppingStone_21317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] jump = new int [n][2];
        int [] dp = new int [n+1];
        for(int i=1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            jump[i][0] = Integer.parseInt(st.nextToken());
            jump[i][1] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        jump[0][0] = 0;
        jump[0][1] = 0;

        dp[1] =0;
        dp[2] = dp[1]+jump[1][0];
        for(int i=3; i<=n; i++){
            dp[i] = Math.min(dp[i-2]+jump[i-2][1],dp[i-1]+jump[i-1][0]);
        }

        //K처리를 못하게다,,
    }
}