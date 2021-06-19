package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj11725 {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //[백준] 트리의 부모 찾기
        //첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력
        /*
           2  4
           3  6
           4  1
           5  3
           6  1
           7  4
         */
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        list = new ArrayList[n+1];
        parents = new int[n+1];
        visited = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int j=1; j<n; j++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        for (int k=1; k<=n; k++) {
            if (!visited[k]) {
                DFS(k);
            }
        }

        for (int l=2; l<=n; l++) {
            System.out.println(parents[l]);
        }
    }

    public static void DFS(int num) {
        if (visited[num]) {
            return;
        }

        visited[num] = true;
        for (int value : list[num]) {
            if (!visited[value]) {
                parents[value] = num;
                DFS(value);
            }
        }
    }
}
