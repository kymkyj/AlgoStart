package com.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaeminTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = " 779091968 2009 년 9 월 23 일 ssss.sss\n 284164096 2013 년 8 월 14 일 sss.sss\n 714080256 2013 년 6 월 13 일 sss.sss\n       329 2010 년 12 월 12 일 sss.sss\n 444596224 1950 년 1 월 17 일 sss.sss\n       641 1987 년 5 월 24 일 sss.sss\n    245760 2005 년 7 월 16 일 sss.sss\n 839909376 1990 년 1 월 31 일 sss.sss";

        solution(s);
    }

    static public void solution(String s){
        int cnt =0;
        String [] lines = s.split("\n");

        for(String line : lines){
            int size = Integer.parseInt(line.substring(0,10).replace(" ",""));
            if(size < 240*1024) continue;

            String date = line.substring(11,26);

            int year = Integer.parseInt(date.substring(0,4));
            if(year< 1990) continue;

            int midx= date.indexOf("월");
            int month = Integer.parseInt(date.substring(6,midx).replace(" ",""));
            if( month == 1) continue;

            cnt++;
        }
        if(cnt ==0) System.out.print("NO FILES");
        else System.out.print(cnt);
    }
}