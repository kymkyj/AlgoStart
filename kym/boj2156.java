package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    1. i 번째 포도주 잔은 마시지 않는다.
    2. i 번째 포도주 잔을 첫번째 잔으로 마신다.
    3. i 번째 포도주 잔을 두번째 잔으로 마신다.
 */
public class boj2156 {
    public static int[] arr;
    public static int[] dp;
    public static int result;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n+3];
        dp = new int[n+3];

        for(int i=0; i < n; i++) {
            arr[3+i] = Integer.parseInt(br.readLine());
        }

        for(int i=3; i < arr.length; i++) {
            int grapeCase1 = dp[i-1];
            int grapeCase2 = dp[i-2] + arr[i];
            int grapeCase3 = dp[i-3] + arr[i-1] + arr[i];
            result = Math.max(grapeCase1, Math.max(grapeCase2, grapeCase3));
            dp[i] = result;
        }
        System.out.println(result);
    }
}
