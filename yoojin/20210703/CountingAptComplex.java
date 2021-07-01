package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CountingAptComplex {
    static char [][] apt;
    static boolean [][] visited;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static int n;
    static ArrayList<Integer> resultlist = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        apt = new char[n][n];
        visited =new boolean[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                apt[i][j] =str.charAt(j);
                if( apt[i][j] == '0' ) visited[i][j] =true;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(apt[i][j] =='1' && !visited[i][j]){
                    resultlist.add(dfs(i,j,0));
                }
            }
        }
        Collections.sort(resultlist);
        System.out.println(resultlist.size());
        for( int r : resultlist){
            System.out.println(r);
        }
    }

    static public int dfs(int x, int y, int c){
        visited[x][y] =true;
        int cnt =c+1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 &&nx<n && ny<n){
                if(apt[nx][ny] == '0') continue;
                if( !visited[nx][ny]) {
                    cnt = dfs(nx,ny,cnt);
                }
            }
        }
        return cnt;
    }
}
