package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {

    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for(int i = 0 ; i < m; i++){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    public static void initCheck(){
        for(int i = 0 ; i < check.length; i++) check[i] = false;
    }

    public static void dfs(int start){
        sb.append(start + " ");
        check[start] = true;

        for(int i = 1; i < check.length; i++)
            if(i != start && check[i] == false && arr[start][i] == 1)
                dfs(i);

    }
    public static void bfs(int start){
        initCheck();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            sb.append(num + " ");

            for(int i = 1; i < check.length; i++){
                if(i != num && check[i] == false && arr[num][i] == 1) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
        sb.append("\n");
    }
}