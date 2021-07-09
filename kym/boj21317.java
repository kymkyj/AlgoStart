package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 징검다리 건너기(DFS)
/*
    5      ->   5
    1 2
    2 3
    4 5
    6 7
    4
 */
public class boj21317 {
    static int n, k;
    static int [][] bridge;
    static int answer = Integer.MAX_VALUE;
    public void DFS(int L, int sum, boolean jump){
        if(L > n) return; // L이 마지막 돌보다 커지면 안됨으로 return
        if(!jump){
            DFS(L+3, sum + k, true);
        }
        if(L == n){
            answer = Math.min(answer, sum);
            return;
        }else{
            // L에 +1해주고 +2해주는 부분이 이해가 잘안됨
            DFS(L+1, sum + bridge[L][0], jump);
            DFS(L+2, sum + bridge[L][1], jump);
        }
    }
    public static void main(String[] args) throws IOException {
        boj21317 T = new boj21317();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bridge = new int[n][n];
        StringTokenizer st = null;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            bridge[i][0] = Integer.parseInt(st.nextToken());
            bridge[i][1] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        T.DFS(1, 0, false); // 1번 돌부터 시작한다고 한거랑 0은 합계
        System.out.println(answer);
    }
}
