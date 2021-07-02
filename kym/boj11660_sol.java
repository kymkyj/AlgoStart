package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11660_sol {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a[][] = new int[n][n];
        int gugan[][] = new int[n+1][n+1];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                gugan[i+1][j+1] = gugan[i][j+1] + gugan[i+1][j] - gugan[i][j] + a[i][j];
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(gugan[x2][y2] - gugan[x1-1][y2] - gugan[x2][y1-1] + gugan[x1-1][y1-1]);
        }
    }
}