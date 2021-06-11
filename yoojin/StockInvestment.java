package com.practice;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StockInvestment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());
        int profits[] = new int [times];
        int i, j,temp;
        for(i = 0; i<times; i++){
            int day = Integer.parseInt(br.readLine());
            int stock[][] = new int [day][3];
            for(j=0; j<day; j++){
                StringTokenizer stocks = new StringTokenizer(br.readLine());
                stock[j][0] = Integer.parseInt(stocks.nextToken());
                stock[j][1] = Integer.parseInt(stocks.nextToken());
                stock[j][2] = Integer.parseInt(stocks.nextToken());
            }
            for(j =0; j<day; j++){
                Arrays.sort(stock[j]);
                if (stock[j][2] >0) profits[i] +=stock[j][2];
            }
        }
        for(i=0; i<times; i++){
            System.out.println(profits[i]);
        }
    }
}
