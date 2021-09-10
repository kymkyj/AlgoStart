package study.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj2675 {
    static int T; //테스트 케이스 개수
    static int R; //반복 횟수
    static String S; //문자열
    public static void main(String[] args) {
        //[백준] 문자열 반복
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        for (int i=0; i<T; i++) {
            R = scanner.nextInt();
            S = scanner.next();

            for (int j=0; j<S.length(); j++) {
                for (int k=0; k<R; k++) {
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
