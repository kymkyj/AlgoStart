package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 단지번호 붙이기
/*
    7        ->   3 7 8 9
    0110100
    0110101
    1110101
    0000111
    0100000
    0111110
    0111000

 */
public class boj2667 {
    static int n, dangiCnt;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int [][] dangi;
    static boolean [][] ch;
    static ArrayList<Integer> list = new ArrayList<>();

    public int DFS(int x, int y){
        ch[x][y] = true; // 간 단지 체크
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y+ dy[i];
                if(nx >= 0 && nx <= n && ny >=0 && ny <= n){
                    if(dangi[nx][ny] == 1 && !ch[nx][ny]){
                        ch[nx][ny] = true;
                        dangiCnt++;
                        DFS(nx, ny);
                    }
                }
            }
        return dangiCnt;
    }

    public static void main(String[] args) throws IOException {
        boj2667 T = new boj2667();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dangi = new int[n][n];
        ch = new boolean[n][n];
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; i<n; j++){
                dangi[i][j] = tmp.charAt(j)-'0';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dangi[i][j] == 1 && !ch[i][j]){
                    dangiCnt = 1;
                    T.DFS(i,j);
                    list.add(dangiCnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
