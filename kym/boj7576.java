package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomatoPoint{
    public int x, y;
    tomatoPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj7576 {
    static int m, n;
    static int answer = 0; // 일수 저장할 변수
    static int [] dx = {-1, 0, 1, 0}; // 토마토 왼쪽 오른쪽 앞 뒤
    static int [] dy = {0, 1, 0, -1};
    static int [][] tomato, dis;
    static Queue<tomatoPoint> Q = new LinkedList<>();

    public void BFS(){
        while(!Q.isEmpty()){
            tomatoPoint tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >=0 && nx <n && ny >= 0 && ny<m && tomato[nx][ny] == 0){
                    tomato[nx][ny] = 1;
                    Q.offer(new tomatoPoint(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        boj7576 T = new boj7576();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tomato = new int[n][m];
        dis = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                // 시작지점을 확인해서 1인경우 판단되면
                // 미리 큐에 넣어놓는다.
                // 출발점이 여러개일 때 미리 큐에 넣어놓고 여기가 1레벨이다 라는걸 나타냄
                if(tomato[i][j]==1) Q.offer(new tomatoPoint(i, j));
            }
        }
        T.BFS();
        // 전체가 익지 않는 여부 확인
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tomato[i][j] == 0) flag = false;
            }
        }
        if(flag){ // flag를 기준으로 토마토가 다 익었는지 안익었는지 판단
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1); // flag가 false로 안익은 토마토가 있는 경우
    }
}
