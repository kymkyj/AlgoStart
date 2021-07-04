package study.baekjoon.class3;

import java.util.Arrays;
import java.util.Scanner;

public class boj11399 {
    public static void main(String[] args) {
        //[백준 CLASS3] ATM
        //주어진 시간에 대해서 오름차순으로 정렬해서 sum 하면 될 것 같다
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int N = scanner.nextInt();
        int[] P = new int[N];
        for (int i=0; i<N; i++) {
            P[i] = scanner.nextInt();
        }
        //오름차순으로 정렬
        Arrays.sort(P);

        for (int i=0; i<P.length; i++) {
            for (int j=0; j<=i; j++) {
                sum += P[j];
            }
        }
        System.out.println(sum);
    }
}
