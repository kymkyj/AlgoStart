package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬 탈출4
/*
    5 5
    #####
    #..B#
    #.#.#
    #RO.#
    #####
 */
class goosle{
    public int x, y;
    goosle(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj15653 {
    static int n, m, answer; // answer 횟수 카운트
    static String [][] graph;
    static int [][] dis; // 구슬 이동 체크
    static Queue<goosle> Q = new LinkedList<goosle>();
    static int [] dx = {-1, 0, 1, 0}; // 구슬 방향
    static int [] dy = {0, 1, 0, -1};

    public void BFS(){
        while(!Q.isEmpty()){
            goosle tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >=0 && nx <n && ny >= 0 && ny<m && graph[nx][ny] != "#"){
                    dis[nx][ny] = 1;
                    Q.offer(new goosle(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        boj15653 T = new boj15653();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new String[n][m];
        dis = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = st.nextToken();
                if (graph[i][j] == "B") graph[i][j] = "B"; // B위치는 그냥 박아놓자
                if (graph[i][j] == "R") Q.offer(new goosle(i, j)); // B까지 볼 필요가 있나?
            }
        }
        T.BFS();
    }
}
