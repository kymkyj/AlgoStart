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
     4->둘의 위치가 다르면,  방문한적 없는지 체크 후, ++cnt 후 queue에 바뀐방향 추가.
4. 탐색 종료 후에도 3-2 조건이 없을 시 -1을 반환함.
 */
class Pos{
    int x,y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class CurrentPos{
    Pos red, blue;
    int cnt;
    public CurrentPos(Pos red, Pos blue, int cnt) {
        this.red = red;
        this.blue = blue;
        this.cnt = cnt;
    }
}
public class EscapeMableFour {
    static Queue<CurrentPos> queue = new LinkedList<CurrentPos>();
    static Pos red = null;
    static Pos blue =null;
    static Pos goal = null;

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
        for(int i=0; i<N; i++){
            board[i] =br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(board[i][j] == 'R'){
                    red = new Pos(i,j);
                    board[i][j] = '.';
                }
                if(board[i][j] == 'B'){
                    blue = new Pos(i,j);
                    board[i][j] = '.';
                }
                if(board[i][j] =='O'){
                    goal = new Pos(i,j);
                }
            }
        }
        visited[red.x][red.y][blue.x][blue.y] = true;
        queue.add(new CurrentPos(red,blue,0));

        System.out.print(escapeMarble());

    }
    //3번
    public static int escapeMarble(){
        while(queue.size() != 0){
            CurrentPos cp = queue.poll();
            Pos red = cp.red;
            Pos blue = cp.blue;
            int cnt = cp.cnt;
            for(int i=0; i<4; i++){ //상하좌우로 공굴리기
                //3-0번
                Pos newlocRed = moveMarble(red,i);
                Pos newlocBlue = moveMarble(blue,i);

                //3-1번
                if(newlocBlue.x == goal.x && newlocBlue.y == goal.y) continue;
                //3-2번
                if (newlocRed.x == goal.x && newlocRed.y == goal.y) return ++cnt;
                //3-3번
                if(newlocRed.x == newlocBlue.x && newlocRed.y== newlocBlue.y){
                    int mcntRed = Math.abs((red.x- newlocRed.x)+(red.y- newlocRed.y));
                    int mcntBlue = Math.abs((blue.x- newlocBlue.x)+(blue.y- newlocBlue.y));

                    if(mcntBlue > mcntRed){
                        newlocBlue.x -= dx[i];
                        newlocBlue.y -= dy[i];
                    }else{
                        newlocRed.x -=dx[i];
                        newlocRed.y -=dy[i];
                    }
                }
                //3-4번
                if(visited[newlocRed.x][newlocRed.y][newlocBlue.x][newlocBlue.x]) continue;
                else {
                    visited[newlocRed.x][newlocRed.y][newlocBlue.x][newlocBlue.y] =true;
                    queue.add(new CurrentPos(newlocRed,newlocBlue,cnt+1));
                }
            }
        }
        //4번
        return -1;
    }
    //3-0번
    public static Pos moveMarble(Pos pos, int i) {
        int x = pos.x;
        int y = pos.y;
        while (board[x][y] != 'O' && board[x + dx[i]][y + dy[i]] != '#') {
            x += dx[i];
            y += dy[i];
        }
        return new Pos(x, y);
    }
}

