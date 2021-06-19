package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj15653 {
    static String[][] graph;
    static int N; //세로
    static int M; //가로
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; //왼쪽 오른쪽
    static int[] dy = {0, 0, -1, 1}; //위 아래
    public static void main(String[] args) throws IOException {
        //[백준] 구슬 탈출 4
        //구슬이 동시에 움직인다
        //파란 구슬은 빠지면 안된다
        //모르겠다!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = st.nextToken();
            }
        }
        BFS();
    }

    static void BFS() {
    }
}
