package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 동전 5
/*
    3 10    ->      10
    1
    2
    5
 */
// BFS로 합한 값들의 경우를 모두 나열해야할듯?
public class boj2293 {
    static int n, k;
    static int cnt; // 경우의 수 카운트
    static int [] coin;
    static boolean ch; // 간곳 체크
    static Queue<Integer> Q = new LinkedList<>();
    public void DFS(int L, int sum, int [] arr){
        if(sum == k) cnt++;
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    public static void main(String[] args) throws IOException {
        boj2293 T = new boj2293();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }
        T.DFS(0,0, coin);
        System.out.println(cnt);
    }
}
