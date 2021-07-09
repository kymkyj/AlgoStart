package com.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
포도주 시식

1,2,3,....,n-4, n-3, n-2, n-1, n
1. n-1에서 건너 뛸 것인가: n-2까지의 합 +n
2. n-2에서 건너 뛸 것인가 : n-3까지의 합+n-1+n
3. n에서 뛸 것인가 : n-1까지의 합
세개의 합중 최댓값

 */
public class TastingWIne_2156번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cups = new int[n + 1];
        int[] dp = new int[n + 1];
        int first, second;
        for (int i = 1; i <= n; i++) {
            cups[i] = Integer.parseInt(br.readLine());
        }
        cups[0] = 0;
        dp[0] = 0;
        dp[1] = cups[1];
        if (n > 1) {
            dp[2] = cups[1] + cups[2];
            for (int i = 3; i <= n; i++) {
                first = dp[i - 2] + cups[i];
                second = dp[i - 3] + cups[i - 1] + cups[i];
                dp[i] = Math.max(dp[i - 1], Math.max(first, second));
            }
        }

        System.out.print(dp[n]);
    }
}