package study.baekjoon.class3;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
    //2이상 1000이하
    static int M, N;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0}; //왼쪽 오른쪽
    static int[] dy = {0, 0, -1, 1}; //앞 뒤

    public static void main(String[] args) throws IOException {
        //[백준 class3] 토마토
        //토마토가 모두 익을 수 있는 최소 일수: BFS로 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        graph = new int[M][N];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                //토마토의 위치를 저장
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
    }

    static void BFS() {
        Queue<Position> queue = new LinkedList<>();
        int day = 0;

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                //토마토가 있을 경우 큐에 삽입
                if (graph[i][j] == 1) {
                    queue.offer(new Position(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            day = position.pos;

            for (int i=0; i<4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        queue.add(new Position(nx, ny, day+1));
                    }
                }
            }
        }
        if (checkAllTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkAllTomato() {
        for(int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (graph[i][j] == 0) {
                    //다 익지않은 상황
                    return false;
                }
            }
        }
        return true;
    }

    //토마토의 x, y, 위치를 저장하는 position static class
    static class Position {
        int x;
        int y;
        int pos;

        public Position(int x, int y, int pos){
            this.x = x;
            this.y = y;
            this.pos = pos;
        }
    }
}
