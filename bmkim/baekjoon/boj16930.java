package study.baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16930 {
    static int N, M;
    static int K; //1초에 이동할 수 있는 칸의 최대 개수
    static int x1, y1, x2, y2;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        //[백준] 달리기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new int[N][M];

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = str.charAt(j);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());

        BFS();
        answer = visited[y2 - 1][x2 - 1];
        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

    static void BFS() {
        Queue<Position> queue = new LinkedList<>();
        //왜 x와 y를 반대로 대입해서 풀어야했을까
        queue.offer(new Position(y1-1, x1-1));
        visited[y1-1][x1-1] = 0;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            if (position.x == x2-1 && position.y == y2-1) return;
            for (int i=0; i<4; i++) {
                int ny = position.y;
                int nx = position.x;
                for (int j=0; j<K; j++) {
                    ny += dy[i];
                    nx += dx[i];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) break;
                    //현재 방문하는 배열의 수가 visited[position.y][position.x] + 1보다 작아야 하는 조건을 이해 못하겠다
                    if (graph[ny][nx] == '#' || visited[ny][nx] < visited[position.y][position.x] + 1) break;;
                    if (visited[ny][nx] == Integer.MAX_VALUE && graph[ny][nx] == '.') {
                        visited[ny][nx] = visited[position.y][position.x] + 1;
                        queue.offer(new Position(ny, nx));
                    }
                }
            }
        }
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
