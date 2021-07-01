package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 폭발
/*
    mirkovC4nizCC44     mirkovniz
    C4
 */
public class boj9935_other {
    static String str, bomb;
    static String ch;
    static StringBuilder sb  = new StringBuilder(); // 문자열 연결해줄 변수
    public static void solution(String str, String bomb){
        for(int i=0; i<str.length(); i++){
            char tmp = str.charAt(i);
            sb.append(tmp);
            if(sb.length() >= bomb.length()){
                if(String.valueOf(sb).contains(bomb)){
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }
        if(sb.length() == 0) System.out.println("FRULA");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bomb = br.readLine();
        solution(str, bomb);
    }
}
