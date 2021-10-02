package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class baekjoon_14888_20211002 {
    static ArrayList<String> operaters = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String list ="";
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        int n = Integer.parseInt(br.readLine());
        int [] nums = new int[n];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        list += "+".repeat(Integer.parseInt(st.nextToken()));
        list += "-".repeat(Integer.parseInt(st.nextToken()));
        list += "*".repeat(Integer.parseInt(st.nextToken()));
        list += "%".repeat(Integer.parseInt(st.nextToken()));

        boolean [] visited =new boolean[list.length()];
        char [] output = new char [list.length()];
        perm(list,output,visited,0,list.length());

        for(String o : operaters){
            long x = nums[0];
            for(int i=1; i< nums.length; i++){
                x = cal(x,nums[i],o.charAt(i-1));
            }
            if(x>max) max=x;
            if(x<min) min =x;
        }

        System.out.print(max+"\n"+min);


    }

    static void perm(String s, char[] output, boolean[] visited, int cnt, int n) {
        if (cnt == n) {
            String result = new String(output);
            if(!operaters.contains(result)) operaters.add(result);
            System.out.println(result);
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]){
                visited[i] = true;
                output[cnt] =s.charAt(i);
                perm(s, output, visited, cnt + 1, n);
                visited[i] = false;;
            }
        }
    }

    static public long cal(long x, long y, char operator){
        switch (operator){
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            case '%':
                if(x<0) {
                    return Math.abs(Math.abs(x) / y);
                }else return x/y;
            default: return 0;
        }
    }
}