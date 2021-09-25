package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class baekjoon_10773_20210925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int k = Integer.parseInt(br.readLine());
        for( int i =0; i<k ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                list.remove(list.size()-1);
            }else if(num !=0){
                list.add(num);
            }
        }

        int answer =0;
        for( int n: list){
            answer+=n;
        }
        System.out.print(answer);
    }
}