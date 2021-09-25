package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class baekjoon_5622_20210925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer =0;
        String s = br.readLine();

        //-65 를 통해서 /3의 몫으로 체크 몫+2 해주고 90 체크
        //아 중간에 4개 되네; 당황

        for(int i=0; i<s.length();i++){
//            int n = (s.charAt(i)-65)/3+3;
//            if( n == 11 ) n =10;
//            ansewr+=n;
           answer+= dial(s.charAt(i));
        }
        System.out.print(answer);
    }
    static public int dial(char c){
        switch (c) {
            case 'A': case 'B': case 'C': return 3;
            case 'D': case 'E': case 'F': return 4;
            case 'G': case 'H': case 'I': return 5;
            case 'J': case 'K': case 'L': return 6;
            case 'M': case 'N': case 'O': return 7;
            case 'P': case 'Q': case 'R': case'S': return 8;
            case 'T': case 'U': case 'V': return 9;
            case 'W': case 'X': case 'Y': case 'Z': return 10;
            default: return 0;
        }
    }
}