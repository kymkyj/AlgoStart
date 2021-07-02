package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2667 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int count = 0;
    static int[] countDesc = new int[25*25];
    public static void main(String[] args) throws IOException {
        //[백준] 단지 번호 붙이기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            str = br.readLine().split("");
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    DFS(i,j);
                    count++;
                }
            }
        }
        Arrays.sort(countDesc);
        System.out.println(count);

        for (int i=0; i<countDesc.length; i++) {
            if (countDesc[i] == 0) {

            } else {
                System.out.println(countDesc[i]);
            }
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        countDesc[count]++;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >=0 && ny < N) {
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
