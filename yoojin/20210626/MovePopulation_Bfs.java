package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
0. n,l,r 국가별 인구수 입력받기.
1. bfs를 통해 해당 각 나라(이중 for문)의 연합구하기. <queue로 연합 크기 책정.>
    0-> 각 나라의 인접국 배열 존재 유무 체크. <dx,dy>
    1-> 현재 인접국이 연합이 되어있는지 체크. <unioned>
    2-> 연합이 되어있다면 continue. 아니면 연합인지 아닌지 인구차이 체크.
2. 해당 연합국 인구이동 시작. (전체 인구수 /연합국갯수)
3. 무한루프에서 이중for문을 통해 각 나라를 다 돌아도 flag가 false 라면 연합국이 없음을 의미.

시간초과 해결 안되ㅣ,,,,,,,

 */

public class MovePopulation_Bfs {
    static class country{
        int x;
        int y;

        public country(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<country> uq ;
    static int[][] countries;
    static boolean[][] unioned;
    static int i,j, n,l,r,cnt=0;

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        countries = new int [n][n];
        for(i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(j=0; j<n; j++){
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //3번 무한루프를 통해 인구이동 횟수 카운트.
        while(true){
            unioned = new boolean[n][n];
            uq = new LinkedList<country>();
            if(findUnion()) cnt++;
            else break;
        }

        System.out.print(cnt);

    }
    static public boolean findUnion(){
        int cnt=0;
        int sum =0;
        boolean flag =false;
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if(!unioned[i][j]){
                    uq.add(new country(i,j));
                    ArrayList<country> checklist =new ArrayList<>();

                    while (!uq.isEmpty()) {
                        country c = uq.poll();
                        unioned[c.x][c.y] = true;
                        checklist.add(c);
                        cnt++;
                        sum += countries[c.x][c.y];

                        for (int i = 0; i < 4; i++) {
                            int nx = c.x + dx[i];
                            int ny = c.y + dy[i];

                            if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) continue;

                            if (!unioned[nx][ny]) {
                                int dif = Math.abs(countries[c.x][c.y] - countries[nx][ny]);
                                if (dif >= l && dif <= r) {
                                    uq.add(new country(nx, ny));
                                }
                            }
                        }
                    }
                    if(cnt>1){
                        int avg = sum/cnt;
                        for(country c: checklist){
                            countries[c.x][c.y] =avg;
                        }
                        flag =true;
                    }
                }
            }
        }
        return flag;
    }
}


