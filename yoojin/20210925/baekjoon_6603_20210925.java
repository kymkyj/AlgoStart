package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class baekjoon_6603_20210925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while(true){
            String str = br.readLine();
            if(str.length()==1) break;
            list.add(str);
        }

        for(String str: list){
            StringTokenizer st =new StringTokenizer(str);
            int k = Integer.parseInt(st.nextToken());
            String [] S = new String [k];
            boolean[] visited = new boolean[k];
            for(int i=0; i<k; i++){
                S[i] = st.nextToken();
            }
            combination(S,visited,k,0,6);
            System.out.println();
        }
    }

    static public void combination(String []s,boolean[] visited,int k,int start,int cnt){
        if(cnt==0){
            for(int i= 0; i<k; i++){
                if(visited[i])System.out.print(s[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<k; i++){
            visited[i] =true;
            combination(s,visited,k,i+1,cnt-1);
            visited[i] =false;
        }
    }
}