package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16234 {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[][] open;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int sum = 0;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        //[백준] 인구 이동
        //진심 이문제 복잡도 미쳤다!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        R = Integer.parseInt(str[2]);

        A = new int[N][N];
        for (int i=0; i<N; i++) {
            str = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }

        while(true) {
            visited = new boolean[N][N];
            open = new int[N][N];
            count = 0;

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    checkBorder(new Point(i,j));
                }
            }

            //연결할 나라가 없음을 의미: 0 출력
            if (count == 0) {
                break;
            } else {
                answer++;
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (open[i][j] == 1 && !visited[i][j]) {
                        BFS(new Point(i,j));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void checkBorder(Point p) {
        int x = p.x;
        int y = p.y;

        for (int i=0; i<4; i++) {
            int rx = x + dx[i];
            int cy = y + dy[i];

            //국경을 열 수 있는 조건
            //1. 정사각형 범위 내에 있어야 함
            //2. 입력값에 주어진 L이하 R이상 이여야 함
            if ((rx >= 0 && rx < N) && (cy >= 0 && cy < N)) { //정사각형 범위
                if (Math.abs(A[x][y] - A[rx][cy]) >= L && Math.abs(A[x][y] - A[rx][cy]) <= R) {
                    open[x][y] = 1;
                    open[rx][cy] = 1;
                    count++;
                }
            }
        }
    }

    public static void BFS(Point p) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> unionList = new ArrayList<>();
        sum = 0;
        int divide = 0;
        visited[p.x][p.y] = true;
        queue.add(p);

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            unionList.add(point);
            int x = point.x;
            int y = point.y;

            sum += A[x][y];
            divide++;

            for (int i=0; i<4; i++) {
                int rx = x + dx[i];
                int cy = y + dy[i];

                if ((rx >= 0 && rx < N) && (cy >= 0 && cy < N)) {
                    if (Math.abs(A[x][y] - A[rx][cy]) >= L && Math.abs(A[x][y] - A[rx][cy]) <= R && !visited[rx][cy]) {
                        queue.add(new Point(rx, cy));
                        visited[rx][cy] = true;
                    }
                }
            }

            int people = sum/divide;

            for (int i=0; i<unionList.size(); i++) {
                //(연합의 인구 수)/(연합을 이루고 있는 칸의 개수)의 값을 대입
                Point union = unionList.get(i);
                A[union.x][union.y] = people;
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
