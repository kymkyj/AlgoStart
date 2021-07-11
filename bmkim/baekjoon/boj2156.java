package study.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj2156 {
    static int n;
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        //[백준] 포도주 시식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        arr = new int[n+1];

        for (int i=1; i<n+1; i++) {
            //6 10 13 9 8 1
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[0]);
        } else if (n == 2) {
            System.out.println(arr[0] + arr[1]);
        } else {
            dp[0] = arr[0];
            dp[1] = dp[0] + arr[1];
            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

            for (int i=3; i<n; i++) {
                dp[i] = Math.max(dp[i-3] + arr[i] + arr[i-1], dp[i-2] + arr[i]);
                dp[i] = Math.max(dp[i-1], dp[i]);
            }
            System.out.println(dp[n-1]);
        }
    }
}
