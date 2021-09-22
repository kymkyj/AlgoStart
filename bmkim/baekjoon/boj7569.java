package study.baekjoon.graphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7569 {
    static int N, M; //상자의 크기를 나타내는 두 정수
    static int H; //쌓아올려지는 상자의 수
    static int graph[][][];

    static int[] dx = {1, -1, 0, 0, 0, 0}; //상 하
    static int[] dy = {0, 0, 1, -1, 0, 0}; //좌 우
    static int[] dz = {0, 0, 0, 0, 1, -1}; //위 아래
    public static void main(String[] args) {
        //[백준] 토마토
        //왜 오답이징?
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        H = scanner.nextInt();
        graph = new int[H][N][M];

        for (int h=0; h<H; h++) {
            for (int n=0; n<N; n++) {
                for (int m=0; m<M; m++) {
                    graph[h][n][m] = scanner.nextInt();
                }
            }
        }
        BFS();
    }

    static void BFS() {
        Queue<Position> queue = new LinkedList<>();
        int count = 0;

        for (int h=0; h<H; h++) {
            for (int n=0; n<N; n++) {
                for (int m=0; m<M; m++) {
                    if (graph[h][n][m] == 1) {
                        queue.offer(new Position(h, n, m, 0));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            count = position.count;

            for (int i=0; i<6; i++) {
                int x = position.n + dx[i];
                int y = position.m + dy[i];
                int z = position.h + dz[i];

                if(x >= 0 && y >= 0 && z >= 0 && x < N && y < M && z < H) {
                    if(graph[z][x][y] == 0) {
                        graph[z][x][y] = 1;
                        queue.offer(new Position(z, x, y, count+1));
                    }
                }
            }
        }
        if (checkAllTomato()) {
            System.out.println(count);
        } else {
            System.out.println("-1");
        }
    }

    //만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다
    static boolean checkAllTomato() {
        for (int h=0; h<H; h++) {
            for (int n=0; n<N; n++) {
                for (int m=0; m<M; m++) {
                    if (graph[h][n][m] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Position {
        int h;
        int n;
        int m;
        int count;

        public Position(int h, int n, int m, int count) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}
