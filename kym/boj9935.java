package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 폭발
/*
    mirkovC4nizCC44     mirkovniz
    C4
 */
public class boj9935 {
    static String str, bomb;
    public static void solution(String str, String bomb){
        while(str.contains(bomb)){
            str = str.replace(bomb, "");
            if(str.length() == 0){
                System.out.println("FRULA");
                break;
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bomb = br.readLine();
        solution(str, bomb);
    }
}
