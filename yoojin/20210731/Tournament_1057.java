package com.practice;

import java.io.*;
import java.util.StringTokenizer;



public class Tournament_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int cnt =1;
        while(true){
            if(kim%2+kim/2 == lim%2+lim/2) break;
            else if(n==2){
                cnt =-1;
                break;
            }
            cnt++;

            n= n/2+n%2;
            kim = kim/2+kim%2;
            lim = lim/2+lim%2;
        }

        System.out.print(cnt);

    }
}