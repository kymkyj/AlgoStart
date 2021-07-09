package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
bfs 메모리초과
 */


public class SafeZone_Bfs {
    static class Idx{
        int x;
        int y;
        public Idx(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int safezone =1;
    static int mindepth = Integer.MAX_VALUE;
    static int maxdepth = Integer.MIN_VALUE;
    static int n;
    static int [][] loc;
    static int[][] sinked;
    static boolean[][] zoned;
    static ArrayList<Integer> safelist;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        loc = new int [n][n];
        sinked =new int[n][n];
        zoned =new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                loc[i][j]= Integer.parseInt(st.nextToken());
                mindepth = mindepth>loc[i][j]? loc[i][j]:mindepth;
                maxdepth = maxdepth<loc[i][j]? loc[i][j]:maxdepth;
            }
        }
        for(int d=mindepth; d<= maxdepth; d++){
            int dcnt = 0;
            safelist = new ArrayList<>();
            checksinked(d);
            for( int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(sinked[i][j] == -1 || sinked[i][j] == d) continue;
                    bfs(i,j,d);
                    dcnt++;
                }
            }
            safezone = dcnt> safezone? dcnt:safezone;
        }
        System.out.print(safezone);
    }

    static public void bfs(int x, int y, int depth){
        Queue<Idx> queue =new LinkedList<>();
        queue.add(new Idx(x,y));

        while(!queue.isEmpty()){
            Idx cur = queue.remove();
            sinked[cur.x][cur.y] = depth;

            for(int i=0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if( nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(sinked[nx][ny] == -1 || sinked[nx][ny] ==depth) continue;
                queue.add(new Idx(nx,ny));
            }
        }
    }

    static public void checksinked(int depth) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (loc[i][j] == depth) sinked[i][j] = -1;
            }
        }
    }
}