package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
정리할때 그림필수
 */

public class PrefixSUmFIve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] arr = new int [n+1][n+1];
        int [][]range = new int [m][4];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
                arr[i][j] += arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                range[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            int sx = range[i][0];
            int sy = range[i][1];
            int ex = range[i][2];
            int ey = range[i][3];

            System.out.println(arr[ex][ey]-arr[sx-1][ey]-arr[ex][sy-1]+arr[sx-1][sy-1]);
        }



    }
}
