package study.baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj1057 {
    static int N; //참가자의 수
    static int JIMIN; //김지민의 번호
    static int HANSOO; //임한수의 번호
    static int round;
    public static void main(String[] args) {
        //[백준] 토너먼트
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        JIMIN = scanner.nextInt();
        HANSOO = scanner.nextInt();

        //다음 라운드로 넘어갈 때 번호를 다시 1번부터 부여하므로 누가 이기는지는 고려하지 않아도 될 것 같다
        // 지민: 8 → 4 → 2 → 1
        // 한수: 9 → 5 → 3 → 2
        while (JIMIN != HANSOO) {
            JIMIN = (JIMIN + 1) / 2;
            HANSOO = (HANSOO + 1) / 2;
            round++;
        }
        System.out.println(round);
    }
}
