package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
뚜루는 크기 2 1초에 한칸씩
뚜루보다 큰 물고기 없는 곳으로 가되 작은 물고기만 먹을 수 있음

bfs를 통해 먹이 위치를 찾기 위치를 찾았다면 위치반환.
끝까지 갔는데도 없다면 -1을 반환.

그렇게 상하좌우로 가서 찾아낸 먹이의 위치를 비교후 가장 가깝고 왼쪽위에 있는 친구로 먹어서 몸무게 불리고 게이지 채우기.
걸리는 시간 cnt 해주기.
 */

public class babyShark_16236 {
    static class fishloc{
        int x;
        int y;
        int dis =0;

        public fishloc(int x, int y,int dis){
            this.x=x;
            this.y=y;
            this.dis =dis;
        }
        public fishloc(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n;
    static int cnt=0;
    static int size =2;
    static int gauge = 0;

    static int [][]space;
    static int [][]discnts;
    static int []dx = {0,-1,1,0};
    static int []dy = {-1,0,0,1};
    static fishloc turu;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        space =new int [n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    turu = new fishloc(i, j);
                    space[i][j] = 0;
                }
            }
        }

            while(true){
                discnts =new int [n][n];

                fishloc nfish =  bfs(turu);
                if(nfish.x == -1) break;

                cnt +=nfish.dis;

                gauge ++;
                if( gauge==size) gauge -= size++;

                space[nfish.x][nfish.y] =0;
                turu.x = nfish.x;
                turu.y = nfish.y;
            }

            System.out.print(cnt);

    }
    public static fishloc bfs(fishloc turu){
        Queue<fishloc> queue =new LinkedList<>();
        queue.add(turu);
        discnts[turu.x][turu.y] = 1;
        ArrayList<fishloc> findfishlist = new ArrayList<>();

        while(!queue.isEmpty()){
            fishloc cur = queue.remove();
            for(int i=0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny =cur.y+dy[i];

                if(nx<0 || ny<0|| nx>=n ||ny>=n )continue;
                if( space[nx][ny]>size)continue;
                if(discnts[nx][ny]!=0) continue;

                if(space[nx][ny] == 0 || space[nx][ny] == size) {
                    queue.add(new fishloc(nx,ny));
                    discnts[nx][ny]=discnts[cur.x][cur.y]+1;
                } else {
                    findfishlist.add(new fishloc(nx,ny,discnts[cur.x][cur.y]));
                    discnts[nx][ny]=-1;
                }
            }
        }

        if (findfishlist.isEmpty()) return new fishloc(-1,-1,-1);

        fishloc goal = new fishloc(n,n,n*n) ;

        for(fishloc f : findfishlist) {
            if(goal.dis>f.dis) goal =f;
            else if(goal.dis == f.dis){
                if(goal.x < f.x) continue;
                if(goal.x == f.x && goal.y<f.y) continue;

                goal=f;
            }
        }
        return goal;
    }
}