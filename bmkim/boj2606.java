package study.baekjoon.class3;

import java.util.Scanner;

public class boj2606 {
    //바이러스
    //비슷한 문제를 풀었었는데 문제 추측상 무방향 그래프 + DFS 인 것 같다
    static int[][] graph;
    static boolean[] visited;
    static int number, pair;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt(); //컴퓨터의 수
        pair = scanner.nextInt(); //컴퓨터 쌍의 수

        graph = new int[number+1][number+1];
        visited = new boolean[number+1];

        for (int i=1; i<=pair; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }

        DFS(1);

        System.out.println(answer);
    }

    public static void DFS(int num) {
        visited[num] = true;

        for (int i=1; i<number+1; i++) {
            if (graph[num][i] == 1 && !visited[i]) {
                answer++;
                DFS(i);
            }
        }
    }
}
