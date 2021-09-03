package com.ji.beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class FamousSevenPrincesses {
	
	static char map[][];
    static boolean check[];
    static int temp[];
    static int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
    static int result;
    
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        check = new boolean[25];
        temp = new int[7];
        for (int i = 0; i < 5; i++) {
            String s = in.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        result = 0;
        DFS(0,0); //좌표,카운트,s개수,t개수
        System.out.println(result);
        
    }

    private static void DFS(int cnt,int idx) {
        if(cnt == 7)
        {
        	//인접해 있고, 
            if(adj() && che())
                result++;
            return;
        }
        for (int k = idx; k < 25; k++) {
            // 7개를 뽑는다.
            // 7개중 y가 4개이상이면 안된다.
            // 7개를 좌표로 맵핑하여 인접한지 확인
            if(!check[k])
            {
                check[k] = true;
                temp[cnt] = k;
                DFS(cnt+1,k);
                check[k] = false;
            }
        }
    }

    // ‘이다솜파’가 반드시 우위를 점해야 한다. 
    // 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함
    private static boolean che() { 
        int s_cnt=0;
        for (int i = 0; i < 25; i++) {
            if(check[i])
            {
                int y = i/5;
                int x = i%5;
                if(map[y][x] == 'S')
                    s_cnt++;
            }
            if(s_cnt >=4)
                return true;
        }
        return false;
    }

    //bfs를 이용해서 인접해 있는지 판단
    private static boolean adj() { 
        int id=0;
        for (int i = 0; i < 25; i++) {
            if(check[i])
            {
                id=i;
                break;
            }

        }
        
        LinkedList<int []> queue = new LinkedList<int[]>();
        queue.offer(new int[] {id/5,id%5}); // 임의로 하나 넣음
        
        boolean adj_check[][] = new boolean[5][5];
        adj_check[id/5][id%5] = true;
        int cnt = 1;
        while(!queue.isEmpty())
        {
            int temp1[] = queue.poll();
            int y = temp1[0];
            int x = temp1[1];
            for (int i = 0; i < 4; i++) {
                int ny = y+dir[i][0];
                int nx = x+dir[i][1];
                if(ny > -1 && nx>-1 && nx < 5 && ny < 5 && check[ny*5+nx] && !adj_check[ny][nx])
                {
                    adj_check[ny][nx] = true;
                    queue.offer(new int[] {ny,nx});
                    cnt++;
                }
            }
        }
        
        return cnt == 7?true:false;
        
    }
	

}
