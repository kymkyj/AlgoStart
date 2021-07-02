package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2468 {
    static int N;
    static boolean[][] visited;
    static int[][] graph;
    static int[][] sink;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        //[백준] 안전 영역
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);

        graph = new int[N][N];
        for (int i=0; i<N; i++) {
            str = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        max = 1;

        //높이는 1이상 100이하의 정수
        for (int i=1; i<101; i++) {
            sink = new int[N][N];
            visited = new boolean[N][N];
            count = 0;

            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++) {
                    if (graph[x][y] <= i) {
                        sink[x][y] = 0;
                    } else {
                        sink[x][y] = 1;
                    }
                }
            }

            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++) {
                    if (sink[x][y] == 1 && !visited[x][y]) {
                        DFS(x, y);
                        count++;
                    }
                }
            }
            //아무 지역도 물에 잠기지 않을 수도 있다 (안전 영역의 개수가 1)
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && nx < N && ny >= 0 && ny < N) {
                if (sink[nx][ny] == 1 && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
