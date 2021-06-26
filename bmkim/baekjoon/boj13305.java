package study.baekjoon.greedyAlgorithm;

import java.util.Scanner;

public class boj13305 {
    public static void main(String[] args) {
        //[백준] 주유소
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] distance = new long[N-1];
        long[] cost = new long[N];

        for (int i=0; i<N-1; i++) {
            distance[i] = scanner.nextInt();
        }

        for (int i=0; i<N; i++) {
            cost[i] = scanner.nextInt();
        }

        //1이상 1,000,000,000 이하의 자연수
        long sum = 0;
        long min = cost[0];
        for (int i=0; i<N-1; i++) {
            if (cost[i] < min) {
                min = cost[i];
            }

            sum += min*distance[i];
        }
        System.out.println(sum);
    }
}
