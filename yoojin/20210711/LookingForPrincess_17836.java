package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class LookingForPrincess_17836 {
    static class loc {
        int n, m;

        public loc(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static loc sword;
    static int n, m, t;
    static int[][] tower;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        tower = new int[n][m];
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tower[i][j] = Integer.parseInt(st.nextToken());
                if (tower[i][j] == 2) sword = new loc(i, j);
            }
        }

        int swordtoprincess = (n-1- sword.n)+(m-1- sword.m);
        int swordresult = bfs(sword,t-swordtoprincess);
        int noswordresult = bfs(new loc(n-1,m-1),t);


        if(swordresult == t+1 && noswordresult == t+1) System.out.print("Fail");
        else System.out.print(Math.min(swordresult+swordtoprincess,noswordresult));


    }

    static public int bfs(loc goal, int limit) {
        Queue<loc> queue =new LinkedList<>();
        queue.add(new loc(0, 0));
        int [][]visited = new int [n][m];
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            loc cur = queue.remove();
            if (visited[cur.n][cur.m] > limit+1) return t+1;
            if (cur.n == goal.n && cur.m == goal.m) return visited[cur.n][cur.m] - 1;
            for (int i = 0; i < 4; i++) {
                int nx = cur.n + dx[i];
                int ny = cur.m + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] != 0) continue;
                if (tower[nx][ny] == 1) continue;

                queue.add(new loc(nx, ny));
                visited[nx][ny] = visited[cur.n][cur.m] + 1;
            }
        }
        return t+1;
    }
}