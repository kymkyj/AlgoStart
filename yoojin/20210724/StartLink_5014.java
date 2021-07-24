package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink_5014 {
    static int[] dy ;
    static int [] visited;
    static int f,s,g,u,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int [f+1];
        dy = new int[]{u, -d};

        System.out.print(bfs());

    }

    static public String bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;

        while(!q.isEmpty()){
            int cur = q.remove();
            if(cur == g) return String.valueOf(visited[cur]-1);

            for(int i=0; i<2; i++){
                int ny =dy[i]+cur;

                if(ny<1 || ny>f) continue;
                if(visited[ny] != 0) continue;

                q.add(ny);
                visited[ny] =visited[cur]+1;
            }
        }
        return "use the stairs";
    }

}