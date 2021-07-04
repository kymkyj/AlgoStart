package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation_second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[]distance = new long [n-1];
        long[]cost = new long [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        long coin = cost[0];
        long sum=0;
        for(int i=0; i<n-1; i++){
            if(coin>cost[i]) coin =cost[i];
            sum +=coin*distance[i];
        }
        System.out.print(sum);
    }
}


