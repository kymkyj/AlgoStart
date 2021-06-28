package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
왜 틀린지 모르겠다. 찾았다!
 */
class loc{
    int x;
    int y;

    public loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int[][]board;
    static int r,c,n;
    static Queue<loc> queue =new LinkedList<loc>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[r][c];

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                if(s.charAt(j)=='.')board[i][j] = -1;
                else board[i][j] = 1;
            }
        }

        for(int time=2; time<=n; time++){
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(board[i][j] !=-1) board[i][j]++;
                    if(time%2==0){
                        if(board[i][j] == -1 ) board[i][j]++;
                    }else {
                        if(board[i][j] ==3) queue.add(new loc(i,j));
                    }
                }
            }
            bomb();
        }

        resultprint();
    }

    static public void bomb(){
        int[] dx= {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(queue.size() !=0){
            loc l = queue.poll();
            board[l.x][l.y] =-1;
            for(int i=0; i<4; i++){
                if(l.x+dx[i]>=0 && l.x+dx[i]<r &&l.y+dy[i]>=0 && l.y+dy[i]<c){
                    board[l.x+dx[i]][l.y+dy[i]] =-1;
                }
            }
        }
    }

    static public void resultprint(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(board[i][j]==-1?".":"O");
            }
            System.out.println();
        }
    }
}
