package study.baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16956 {
    static int R, C;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        //[백준] 늑대와 양
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        boolean flag = true;
        //'.'는 빈 칸, 'S'는 양, 'W'는 늑대
        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j=0; j<C; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        //이 문제는 설치해야 하는 울타리의 최소 개수를 구하는 문제가 아니다
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (graph[i][j] == 'W') {
                    for (int k=0; k<4; k++) {
                        int rx = i + dx[k];
                        int cy = j + dy[k];
                        if (rx >= 0 && rx < R && cy >= 0 && cy < C) {
                            if (graph[rx][cy] == '.') {
                                graph[rx][cy] = 'D';
                            } else if (graph[rx][cy] == 'S') {
                                flag = false;
                            }
                        }
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("0");
        } else {
            System.out.println("1");
            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }
        }
    }
}
