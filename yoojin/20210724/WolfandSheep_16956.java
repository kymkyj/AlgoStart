package com.practice;
import java.io.*;
import java.util.*;

public class WolfandSheep_16956  {
    static int r,c;
    static boolean flag;
    static boolean [][]visited;
    static char [][] pasture;
    static int [] dx ={0,0,1,-1};
    static int [] dy ={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        pasture =new char[r][c];
        visited =new boolean[r][c];
        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                pasture[i][j] = s.charAt(j);
            }
        }
        dfs(0,0);
        if(flag) System.out.print(0);
        else{
            bw.write(1+"\n");
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    bw.write(pasture[i][j]);
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        }
    }
    static public void dfs(int x,int y){
        if(x<0||y<0 || x>=r||y>=c) return;
        if(visited[x][y]) return;

        visited[x][y] =true;

        if(pasture[x][y] == 'W'){
            for(int i=0; i<4; i++){
                int nx=x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0 || nx>=r||ny>=c) continue;
                if(pasture[nx][ny]=='S'){
                    flag=true;
                    return;
                }
            }
        }else if(pasture[x][y]=='.') pasture[x][y]='D';

        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y+1);
        dfs(x,y-1);
    }
}
