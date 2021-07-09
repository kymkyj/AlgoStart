package study.baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj17836 {
    public static int N; //성의 크기
    public static int M; //성의 크기
    public static int T; //제한 시간
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] graph;
    public static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        //[백준] 공주님을 구해라!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        T = Integer.parseInt(str[2]);

        graph = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i=0; i<N; i++) {
            str = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        int result = BFS(0, 0);
        if (result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    public static int BFS(int x, int y) {
        Queue<Hero> queue = new LinkedList<>();
        queue.offer(new Hero(x, y, 0, false));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Hero hero = queue.poll();
            if (hero.count > T) break;
            if (hero.x == N-1 && hero.y == M-1) { //공주가 있는 지점
                return hero.count;
            }

            for (int i=0; i<4; i++) {
                int nx = hero.x + dx[i];
                int ny = hero.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    //검을 획득하는 경우와 그렇지 않은 경우로 나누어서 생각해야 한다
                    //0: 빈공간, 1: 마법의 벽, 2: 그람
                    if (!hero.gram) { //검이 없을 경우
                        if (graph[nx][ny] == 0 && !visited[nx][ny][0]) {
                            queue.offer(new Hero(nx, ny, hero.count+1, hero.gram));
                            visited[nx][ny][0] = true;
                        } else if (graph[nx][ny] == 2 && !visited[nx][ny][0]) {
                            queue.offer(new Hero(nx, ny, hero.count+1, true));
                            visited[nx][ny][0] = true;
                        }
                    } else { //검이 있을 경우
                        if (!visited[nx][ny][1]) {
                            queue.offer(new Hero(nx, ny, hero.count+1, hero.gram));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }

        }
        return -1;
    }
}

class Hero {
    int x;
    int y;
    int count;
    boolean gram;

    public Hero(int x, int y, int count, boolean gram) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.gram = gram;
    }
}
