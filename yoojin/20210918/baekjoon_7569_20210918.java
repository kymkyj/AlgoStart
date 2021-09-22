package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class baekjoon_7569_20210918 {
    static class tomatos {
        int x;
        int y;
        int z;
        tomatos(int x, int y, int z){
            this.x =x;
            this.y = y;
            this.z =z;
        }
    }

    static int n, m,h;
    static int [] dx = {-1,1,0,0,0,0};
    static int [] dy ={0,0,-1,1,0,0};
    static int [] dz ={0,0,0,0,-1,1};
    static int [][][] boxes;
    static Queue <tomatos> done = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h =Integer.parseInt(st.nextToken());
        boxes = new int [n][m][h];

        boolean flag = true;

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    int t = Integer.parseInt(st.nextToken());
                    if( t == 1){
                        boxes[j][k][i] = 1;
                        done.add(new tomatos(j,k,i));
                    }else if(t== 0){
                        flag =false;
                    }else if(t==-1){
                        boxes[j][k][i] = -1;
                    }
                }
            }
        }

        if(flag) System.out.print(0);
        else{
            System.out.print(bfs());
        }

    }
    static public int bfs(){
        while(!done.isEmpty()){
            tomatos cur = done.remove();
            for( int i=0; i<6; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                int nz = cur.z+dz[i];
                if(nx<0 || ny<0 || nz<0 || nx>=n || ny>=m || nz>=h) continue;
                if(boxes[nx][ny][nz]== 0){
                    boxes[nx][ny][nz] = boxes[cur.x][cur.y][cur.z]+1;
                    done.add(new tomatos(nx,ny,nz));
                }
            }
        }

        int days =1;

        for (int i = 0; i < h; i++) {
            for ( int j = 0; j < n; j++) {
                for( int k=0; k<m; k++){
                    if(boxes[j][k][i] == 0) return -1;
                    if(boxes[j][k][i] == -1) continue;

                    days = Math.max(boxes[j][k][i] -1, days);
                }
            }
        }
        return days;

    }
}