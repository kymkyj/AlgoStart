package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 봄버맨
/*
    설명
    1. 봄버맨은 R * C 격자판에 위치
    2. 폭탄이 있는 칸은 3초뒤 폭발함
    3. 폭발하면 폭탄칸과 인접한 네방향의 칸이 파괴됨 (i, j)인 경우에 (i+1, j), (i-1, j), (i, j+1), (i, j-1)
    4. 봄버맨은 처음 1초에 임의의 칸에 폭탄 설치 -> 다음 1초 아무것도 안함 -> 그다음 1초에 폭탄 설치 안된곳 다 폭탄 설치
    5. 그 다음부터는 폭탄 설치 안된곳 설치 -> 폭파 반복
    6. 첫줄에 R, C, N 주어짐 / 빈칸 . 폭탄 0

    6 7 3          ->           OOO.OOO
    .......                     OO...OO
    ...O...                     OOO...O
    ....O..                     ..OO.OO
    .......                     ...OOOO
    OO.....                     ...OOOO
    OO.....

    왠지 역할별로 나눠야할듯
    1단계 - 처음 격자판 상태 board에 저장
    2단계 - 멍떄리기
    3단계 - 남은칸 다 폭탄 설치
    4단계 - 폭탄 펑
    5단계 - 격자판 상태확인 result가 필요할 듯?
 */
class BombPos{ // 폭탄 위치 지정해주기위한 클래스 선언
    public int x, y;
    BombPos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

// 1 - 처음 격자판 상태 만들기
public class boj16918 {
    static int R, C, N; // N이 폭탄 카운트
    static int time = 1;
    static char[][] board; // 격자판
    static int [][] result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<BombPos> Q = new LinkedList<>(); // 처음 폭탄위치 넣어주기 위해


    // 최종 - 값 출력
    public static void solution() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(board[i][j]+"");
            }
            System.out.println();
        }
    }

    public static void bombShot(int x, int y){
        board[x][y] = '.';
        while(!Q.isEmpty()){
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && nx <R && ny >= 0 && ny<C && result[nx][ny] != time){
                    board[nx][ny] = 0;
                    result[nx][ny] = '.';
                }
            }
        }
    }

    public static void bombChange() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(board[i][j] == time) { // 시간이랑 같을 떄까지 폭탄 전진
                    bombShot(i,j);
                }
            }
        }
    }

    // 단계 2 - 빈칸 폭탄 만들기
    public static void bombInstall() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(board[i][j]=='.') {
                    board[i][j]='O';
                    result[i][j] = time+3;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        boj16918 T = new boj16918();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        board = new char[R][C];
//        result = new int[R][C];
//        int R = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//
//        for(int i=0; i<R; i++) {
//            String t = br.readLine();
//            for(int j=0; j<C; j++) {
//                board[i][j] = t.charAt(j);
//                if(board[i][j]=='O') {
//                    Q.offer(new BombPos(i, j));
//                    result[i][j] = 3;
//                }
//            }
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[2]);

        board = new char[R][C];
        result = new int[R][C];
        for(int i=0; i<R; i++) {
            String t = br.readLine();
            for(int j=0; j<C; j++) {
                board[i][j] = t.charAt(j);
                if(board[i][j]=='O') {
                    Q.add(new BombPos(i,j));
                    result[i][j] = 3;
                }
            }
        }

        while(time++ < N) {
            if(time%2==0) {
                bombInstall();
            }
            else {
                bombChange();
            }
        }
        solution();
//        solution(0, board);
    }
}