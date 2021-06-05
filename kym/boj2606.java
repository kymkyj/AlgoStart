package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 바이러스
public class boj2606 {
    static int n, m, answer = 0;
    static int ch [];
    static int graph[][];

    public void DFS(int v){
        for(int i=1; i<=n; i++){ // 정점번호
            if(graph[v][i] == 1 && ch[i]==0){ // v에서 i로 이동하는 모든경우 구하기 단 체크가 안되어있는 곳만!
                ch[i] = 1; // 이동하고 체크해준다
                answer++;
                DFS(i); // v에서 i로 이동하는 것이라서 i로 적어줘야한다.
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        m = Integer.parseInt(br.readLine()); // 컴퓨터 쌍
        StringTokenizer st = null;
        graph = new int[n+1][n+1]; // 1부터 n 만큼 돌아야함으로
        ch = new int[n+1]; // 마찬가지
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        boj2606 T = new boj2606();
        ch[1] = 1; // 1번노드 체크걸고 시작
        T.DFS(1);
        System.out.println(answer);
    }
}
