package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class boj11725 {
    static int n;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    private static void dfs(int u){
        for(int v : graph[u]){
            System.out.print("v : "+ v);
            if(!visited[v]){
                parent[v] = u;
                visited[v] = true;
                dfs(v);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        parent = new int[n+1];
        visited = new boolean[n+1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i <= n; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}