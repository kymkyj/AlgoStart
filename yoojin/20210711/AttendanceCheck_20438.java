package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AttendanceCheck_20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt,check,s,e,i,result=0;
        boolean [] nums = new boolean[n+3];//애들번호는 n+2
        int [] dp = new int [n+3];
        ArrayList<Integer> sleeps = new ArrayList<>();
        int [][] range = new int [m][2];

        st =new StringTokenizer(br.readLine());
        for(i=0; i<k; i++){ sleeps.add(Integer.parseInt(st.nextToken())); }

        st =new StringTokenizer(br.readLine());
        for(i=0; i<q; i++){
            check= Integer.parseInt(st.nextToken());
            if(sleeps.contains(check))continue;
            cnt =1;
            while(check*cnt<=n+2){
                if(!sleeps.contains(check*cnt)) nums[check*cnt] =true;
                cnt++;
            }
        }

        for(i=3; i<=n+2; i++){
            if(!nums[i]) dp[i] =dp[i-1]+1;
            else dp[i] = dp[i-1];
        }

        for(i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            //번호 s가 불출석일 경우 체크
            if(!nums[s]) result = dp[e]-dp[s]+1;
            else result = dp[e]-dp[s];
            System.out.println(result);
        }
    }
}