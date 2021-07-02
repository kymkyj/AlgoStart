package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 안전영역
/*
    5               ->      5
    6 8 2 6 2
    3 2 3 4 6
    6 7 3 3 2
    7 2 5 3 6
    8 9 5 2 7
 */
public class boj2468_sol {
    static int n;
    static int safeCount = 1; // safeCount 섬이 몇개 붙어있는지 카운트
    static int [][] board;
    static boolean [][] ch;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static ArrayList<Integer> list = new ArrayList<>();

    public void DFS(int x, int y){
        ch[x][y] = false;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                if(board[nx][ny] != -1 && ch[nx][ny] != false){
                    ch[nx][ny] = false;
                    safeCount++;
                    DFS(nx, ny);
                }
            }
            list.add(safeCount);
        }
    }

    public static void main(String[] args) throws IOException {
        boj2468_sol T = new boj2468_sol();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] <= n){
                    ch[i][j] = false;
                    board[i][j] = -1;
                    continue;
                }else{ // n보다 클 경우에는 DFS 돌면서 상하좌우방향 본다..
                    ch[i][j] = false;
                    T.DFS(i, j);
                }
            }
        }
//        for(int i=0; i<list.size(); i++){
//            System.out.println(list.get(i));
//        }
        System.out.println(list.size());
    }
}
