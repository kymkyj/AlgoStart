package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
course별 orders 가 아니라 orders 별 course 로 해야 배열 순서가 맞음 -> course별로 max를 따로 세고 나중에 전체로 돌려서 해야댕 꾸엥
 */
class Programmers_kakao_20211002 {
    static HashMap<String,Integer> map = new HashMap<>();
    static int max =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] orders ={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] course = {2,3,4};

        ArrayList<String> answer = new ArrayList<>();

        for(int i=0; i<course.length; i++){
            int cnt = course[i];
            for(int j=0; j<orders.length; j++){
                if( orders[j].length()<cnt)continue;

                int len = orders[j].length();
                boolean[] visited = new boolean[len];
                combination(orders[j],visited,len,0,cnt);
            }
            for(String s: map.keySet()){
                if(max !=1 && map.get(s) == max) answer.add(s);
            }
            map.clear();
            max =0;
        }
        Collections.sort(answer);
    }

    static public void combination(String s,boolean[] visited,int k,int start,int cnt){
        if(cnt==0){
            String select="";
            for(int i= 0; i<k; i++){
                if(visited[i]) select+=s.charAt(i);
            }

            char [] sortr = select.toCharArray();
            Arrays.sort(sortr);
            String result = new String(sortr);

            if(map.containsKey(result)) map.put(result,map.get(result)+1);
            else map.put(result,1);

            if(map.get(result) >max) max = map.get(result);
            return;
        }

        for(int i=start; i<k; i++){
            visited[i] =true;
            combination(s,visited,k,i+1,cnt-1);
            visited[i] =false;
        }
    }
}