package study.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1941 {
    static String[][] princess = new String[5][5];
    static boolean[] visited = new boolean[25];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        //[백준] 소문난 칠공주
        //개어렵다 ㅋㅋ ㅠ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++) {
            String[] str = br.readLine().split("");
            for (int j=0; j<5; j++) {
                princess[i][j] = str[j];
            }
        }
        //25개 중 7개를 뽑는 조합
        combination(0, 7);
        System.out.println(answer);
    }

    //1. 7명의 자리는 서로 가로나 세로로 반드시 인접
    //2. 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함
    static void combination(int start, int r) {
        if (r == 0) { //r == 0인 경우는, r개의 숫자를 뽑은 경우
            int count = 0;
            int temp = 0;
            int x = 0;
            int y = 0;
            int[][] selectedPrincess = new int[5][5];
            for (int i=0; i<25; i++) {
                //row와 col로 변환
                //(0,0) (0,1) (0,2) (0,3) (0,4)
                //(1,0) (1,1) (1,1) (1,3) (1,4)
                //...

                int row = i/5;
                int col = i%5;

                if (visited[i]) {
                    selectedPrincess[row][col] = 1;
                    if (temp == 0) {
                        x = row;
                        y = col;
                    }

                    if (princess[row][col].equals("S")) //다솜파 갯수 count
                        count++;
                        temp++;
                }
                if (temp == 7) break; //7명 고르면 break
            }
            if (count >= 4) { //다솜파가 4명 이상일 경우 연결되어 있는지 확인
                BFS(x, y, selectedPrincess);
            }
            return;
        }

        for (int i=start; i<25; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i+1, r-1);
                visited[i] = false;
            }
        }
    }

    private static void BFS(int a, int b, int[][] arr) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.offer(new Position(a, b));
        visited[a][b] = true;
        int num = 1;

        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            for (int i=0; i<4; i++) {
                int wx = x + dx[i];
                int hy = y + dy[i];
                if (wx >= 0 && wx < 5 && hy >= 0 && hy < 5 && arr[wx][hy] == 1 && !visited[wx][hy]) {
                    queue.offer(new Position(wx, hy));
                    visited[wx][hy] = true;
                    num++;
                }
            }
        }

        if (num == 7) {
            answer++;
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}


