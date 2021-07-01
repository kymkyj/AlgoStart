package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16918 {
    static int R, C, N;
    static char[][] grating;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] bombCount;
    public static void main(String[] args) throws IOException {
        //[백준] 봄버맨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grating = new char[R][C]; //격자판
        bombCount = new int[R][C]; //폭탄 count

        for (int i=0; i<R; i++) {
            str = br.readLine();
            for (int j=0; j<C; j++) {
                grating[i][j] = str.charAt(j);

                if (grating[i][j] == 'O') {
                    bombCount[i][j] = 0;
                } else {
                    bombCount[i][j] = -1;
                }
            }
        }
        work();
    }

    static void work() {
        for (int i=1; i<=N; i++) {
            if (i == 1) { //다음 1초동안 봄버맨은 아무것도 하지 않는다
                continue;
            } else if (i % 2 == 0) { //다음 1초동안 폭탄이 설치되지 않은 모든 칸에 폭탄을 설치한다: 짝수일 경우 해당
                for (int j=0; j<R; j++) {
                    for (int k=0; k<C; k++) {
                        grating[j][k] = 'O';
                        if (bombCount[j][k] == -1) {
                            bombCount[j][k] = i;
                        }
                    }
                }
            } else { //그 외: 홀수일 경우 상하좌우 폭탄을 검사한다
                BFS(i);
            }
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                System.out.print(grating[i][j]);
            }
            System.out.println();
        }
    }

    public static void BFS(int time) {
        Queue<Location> queue = new LinkedList<>();

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (grating[i][j] == 'O') {
                    if (time - 3 == bombCount[i][j]) {
                        queue.add(new Location(i, j));
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            Location location = queue.poll();
            grating[location.x][location.y] = '.';
            bombCount[location.x][location.y] = -1;

            for (int i=0; i<4; i++) {
                int rx = location.x + dx[i];
                int cy = location.y + dy[i];

                if (rx >= 0 && rx < R && cy >= 0 && cy < C) {
                    grating[rx][cy] = '.';
                    bombCount[rx][cy] = -1;
                }
            }
        }
    }
}

class Location {
    int x;
    int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
소