package study.baekjoon.class3;

import java.util.Scanner;

public class boj1012 {
    static int M; //배추밭의 가로길이
    static int N; //배추밭의 세로길이
    static int K; //배추가 심어져있는 위치의 개수
    static int[][] cabbageField; //배추밭
    static boolean[][] visited; //방문했는지 안했는지

    static int[] dx = {-1, 1, 0, 0}; //상 하
    static int[] dy = {0, 0, -1, 1}; //좌 우
    public static void main(String[] args) {
        //[백준 CLASS3] 유기농 배추
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); //테스트 케이스 개수
        for (int i=0; i<T; i++) {
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            cabbageField = new int[M][N];
            visited = new boolean[M][N];

            for (int j=0; j<K; j++) {
                //배추의 위치 X, Y
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                cabbageField[X][Y] = 1;
            }

            int count = 0;
            for (int k=0; k<M; k++) {
                for (int l=0; l<N; l++) {
                    if (cabbageField[k][l] == 1 && !visited[k][l]) {
                        DFS(k, l);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void DFS(int x, int y) {
        //1. 현재 노드를 방문처리
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int qx = x + dx[i];
            int qy = y + dy[i];

            //2. 현재 노드에서 상,하,좌,우로 갈 수 있는지 확인
            //3. 범위을 초과했는지, 배추여부 확인 필요
            if((qx >= 0 && qy >= 0) && (qx < M && qy < N)) {
                if (cabbageField[qx][qy] == 1 && !visited[qx][qy]) {
                    DFS(qx, qy);
                }
            }
        }
    }
}
