package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class baekjoon_2675_20210904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int [] cnt = new int[t];
        String [] S = new String [t];
        StringBuffer result =new StringBuffer();
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cnt[i] = Integer.parseInt(st.nextToken());
            S[i] = st.nextToken();

            for (int j = 0; j < S[i].length(); j++) {
                for (int k = 0; k < cnt[i]; k++) {
                    result.append(S[i].charAt(j));
                }
            }
            result.append("\n");

        }
        System.out.println(result);

    }
}