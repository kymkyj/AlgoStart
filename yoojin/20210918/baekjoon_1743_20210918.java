package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class baekjoon_1743_20210918 {
    static class boxloc{
        int x;
        int y;

        boxloc(int x, int y){
            this.x =x;
            this.y =y;
        }

    }
    static int n, m;
    static int [] dx = {-1,1,0,0};
    static int [] dy ={0,0,-1,1};
    static int [][] boxes;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boxes = new int [n][m];
        visited = new boolean[n][m];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            boxes[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        int max =0;

        for( int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] || boxes[i][j]==0) continue;
                max = Math.max(bfs(i,j),max);
            }
        }

        System.out.print(max);
    }

    public static int bfs(int x,int y){
        Queue<boxloc> queue =new LinkedList<>();
        visited[x][y] = true;
        queue.add(new boxloc(x,y));
        int cnt =0;
        while(!queue.isEmpty()){
            boxloc cur = queue.remove();
            cnt++;
            for(int i=0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]|| boxes[nx][ny]==0) continue;

                visited[nx][ny] =true;
                queue.add(new boxloc(nx,ny));

            }
        }
        return cnt;
    }
}