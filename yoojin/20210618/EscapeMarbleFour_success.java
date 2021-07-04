package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1. N,M 입력받기
2. board 값 입력받기
    0-> R,B일 때 해당자리 빈공간 표시
    1-> R,B 위치 Pos로 받기. 방문처리.
    2-> O일 때 구멍 위치 Pos로 받기.
    3-> 현재 R,B위치와 cnt CurrentPos로 받아서 queue 넣기.
3. 탐색시작 (queue 값이 없을 때까지)
     0->상하좌우 방향으로 순서대로 구슬 움직이기. 현재 좌표가 goal 과 벽이 아닐때까지.
     1->네방향중 한방향으로 이동 후 B가 goal의 위치일경우, 불가능하여 continue로 다른 방향 찾기.
     2->B가 goal 위치가 아니고 R이 goal의 위치 일 경우 ++cnt 후 반환.
     3->둘다 goal 위치가 아닐경우에, 둘의 위치가 같을때, 둘중 더 멀리서 온 구슬을 위치조정.
     4->둘의 위치가 다르면, 방문한적 없는지 체크 후, ++cnt 후 queue에 바뀐방향 추가.
4. 탐색 종료 후에도 3-2 조건이 없을 시 -1을 반환함.
 */

//queue에 넣읗때는 red blue 위치와 전체cnt
// moveMarble() 반환할 때는 각 구슬의 x,y, 이동cnt.
class CurrentPos{
    int red, blue,cnt;
    public CurrentPos(int red, int blue, int cnt) {
        this.red = red;
        this.blue = blue;
        this.cnt = cnt;
    }
}

public class Main {
    static Queue<CurrentPos> queue = new LinkedList<CurrentPos>();
    static int red;
    static int blue;
    static int goal;

    static char [][]board;
    static boolean [][][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1번
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char [N][M];
        visited = new boolean[N][M][N][M];

        //2번
        //NM이 10보다 클 때는 100 이용해서 위치 저장.
        for(int i=0; i<N; i++){
           board[i] =br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(board[i][j] == 'R'){
                    red = i*10+j;
                    board[i][j] = '.';
                }
                if(board[i][j] == 'B'){
                    blue= i*10+j;
                    board[i][j] = '.';
                }
                if(board[i][j] =='O'){
                    goal = i*10+j;
                }
            }
        }
        visited[red/10][red%10][blue/10][blue%10] = true;
        queue.add(new CurrentPos(red,blue,0));

        System.out.print(escapeMarble());
    }
    //3번
    public static int escapeMarble(){
        while(queue.size() != 0){
            CurrentPos cp = queue.poll();
            int red = cp.red;
            int blue = cp.blue;
            int cnt = cp.cnt;
            for(int i=0; i<4; i++){ //상하좌우로 공굴리기
                //3-0번
                CurrentPos newlocRed = moveMarble(red,i);
                int nrcnt = newlocRed.cnt;
                int nrx = newlocRed.red;
                int nry = newlocRed.blue;

                CurrentPos newlocBlue = moveMarble(blue,i);
                int nbcnt = newlocBlue.cnt;
                int nbx = newlocBlue.red;
                int nby = newlocBlue.blue;

                //3-1번
                if(nbx == goal/10 && nby == goal%10) continue;
                //3-2번
                if (nrx == goal/10 && nry == goal%10) return ++cnt;
                //3-3번
                if(nrx == nbx && nry== nby){

                    if(nbcnt>nrcnt){    //blue 가 더 멀리 떨어져있었으면,
                        nbx -= dx[i];
                        nby -= dy[i];
                    }else{
                        nrx -=dx[i];
                        nry -=dy[i];
                    }
                }
                //3-4번
                if(visited[nrx][nry][nbx][nby]) continue;
                else {
                    visited[nrx][nry][nbx][nby] =true;
                    queue.add(new CurrentPos(nrx*10+nry,nbx*10+nby,cnt+1));
                }
            }
        }
        //4번
        return -1;
    }
    //3-0번
    public static CurrentPos moveMarble(int pos, int i) {
        int cnt =0 ;
        int x = pos/10;
        int y = pos%10;
        while (board[x][y] != 'O' && board[x + dx[i]][y + dy[i]] != '#') {
            x += dx[i];
            y += dy[i];
            cnt++;
        }
        return new CurrentPos(x,y,cnt);
    }
}


