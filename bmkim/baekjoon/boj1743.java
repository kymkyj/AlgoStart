package study.baekjoon.graphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1743 {
    static int N; //통로의 세로길이
    static int M; //통로의 가로길이
    static int K; //음식물 쓰레기의 개수
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static int answer;
    public static void main(String[] args) {
        //[백준] 음식물 피하기
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<K; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            graph[r-1][c-1] = 1;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    count = 0;
                    DFS(i, j);
//                    BFS(i, j);
                    // 처음에 count 값을 출력했는데 오답이 나왔다
                    // answer 를 선언하여 왜 DFS 를 실행한 수만큼 count 와 answer 의 최대값을 비교해서 대입해야 정답인지 이해가 잘 되지 않는다.
                    answer = Math.max(answer, count);
                }
            }
        }
        System.out.println(count);
    }

    //깊이우선탐색을 이용한 풀이
    static void DFS(int r, int c) {
        count++;
        visited[r][c] = true;

        for (int i=0; i<4; i++) {
            int rx = r + dx[i];
            int cy = c + dy[i];

            if (rx < 0 || rx >= N || cy < 0 || cy >= M) continue;
            if (!visited[rx][cy] && graph[rx][cy] == 1) {
                DFS(rx, cy);
            }
        }
    }

    //너비우선탐색을 이용한 풀이
    static void BFS(int r,  int c) {
        count++;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            for (int i=0; i<4; i++) {
                int rx = temp.x + dx[i];
                int cy = temp.y + dy[i];

                if (rx < 0 || rx >= N || cy < 0 || cy >= M) continue;
                if (!visited[rx][cy] && graph[rx][cy] == 1) {
                    BFS(rx, cy);
                }
            }
        }
    }
}
