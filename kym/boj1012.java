package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 유기농배추
class Point{
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj1012 {
    static int m, n, k;
    static int [][] board, dis;
    static int [] dx = {-1, 0, 1, 0}; // 동서남북 x축
    static int [] dy = {0, 1, 0, -1}; // 동서남북 y축
    static int answer = 0;

    public void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        dis[x][y] = 1;
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.x+dy[i];

                if(nx >=0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 1 && dis[nx][ny] == 0){
                    dis[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        boj1012 T = new boj1012();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
        n = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
        k = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치 갯수
        board = new int[m][n];
        dis = new int[m][n];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }
        int answer = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1 && dis[i][j] == 0){
                    T.BFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
