package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class IntervalSumTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] metrix = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                metrix[i][j] = sc.nextInt();
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + metrix[i][j];
            }
        }

        int x1, y1, x2, y2 = 0;
        int[] sum = new int[M];
        for (int i = 0; i < M; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            sum[i] = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
        }

        Arrays.stream(sum)
                .forEach(System.out::println);
    }
}
