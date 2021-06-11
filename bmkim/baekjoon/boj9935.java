package study.baekjoon.class3;

import java.util.Scanner;

public class boj9935 {
    static String answer;
    public static void main(String[] args) {
        //[백준 class3] 문자열 폭발
        //오답이네; 어디가 문제일까?
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String explosionStr = scanner.nextLine();

        while(str.contains(explosionStr)) {
            String replaceStr = str.replace(explosionStr, "");
            str = replaceStr;
            if (!replaceStr.contains(explosionStr)) {
                if (replaceStr.length() == 0) {
                    answer = "FRULA";
                } else {
                    answer = replaceStr;
                }
                break;
            }
        }

        System.out.println(answer);
    }
}
