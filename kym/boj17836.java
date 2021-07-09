package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17836 {

    static int N,M,T;
    static int map[][];
    static boolean isVisited[][];
    static int result = Integer.MAX_VALUE;
    static Queue<Node> q;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        isVisited = new boolean[N][M];
        q = new LinkedList<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
                map[i][j]  = Integer.parseInt(st.nextToken());
        }


        q.offer(new Node(0,0,0));
        isVisited[0][0] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(map[node.x][node.y] == 2) {
                //그램 찾았는 경우에는 바로 현재 거리에서 거리 구해주기
                result = Math.abs((N-1)-node.x)+Math.abs((M-1)-node.y);
                result += node.len;
            }

            if(node.x == N-1 && node.y == M-1) {
                isVisited[node.x][node.y] = true;
                if(result>node.len)
                    result = node.len;
                break;
            }

            for(int d=0;d<4;d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];


                if(nx<0 || ny<0 || nx>=N || ny>=M || isVisited[nx][ny]) continue;
                if(map[nx][ny] == 1) continue;

                isVisited[nx][ny] = true;
                q.offer(new Node(nx,ny,node.len+1));

            }
        }


        if(result>T) System.out.println("Fail");
        else System.out.println(result);

    }

    static class Node{
        int x,y,len;

        public Node(int x, int y,int len) {
            super();
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}