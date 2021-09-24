package study.baekjoon.math;

import java.util.Scanner;

public class boj6603 {
    static int k;
    static int[] S;
    static boolean[] visited;
    public static void main(String[] args) {
        //[백준] 로또
        Scanner scanner = new Scanner(System.in);

        while (true) {
            k = scanner.nextInt();
            if (k == 0) break;

            S = new int[k];
            visited = new boolean[k];

            for (int i=0; i<k; i++) {
                S[i] = scanner.nextInt();
            }

            combination(S, visited, 0, k, 6);
            System.out.println();
        }
    }

    static void combination(int[] S, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(S, visited, n);
            return;
        }

        for (int i=start; i<n; i++) {
            visited[i] = true;
            combination(S, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }

    static void print(int[] S, boolean[] visited, int n) {
        for (int i=0; i<n; i++) {
            if (visited[i]) {
                System.out.print(S[i] + " ");
            }
        }
        System.out.println();
    }
}
