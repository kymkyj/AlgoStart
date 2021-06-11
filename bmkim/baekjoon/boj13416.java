package study.baekjoon;

import java.util.Scanner;

public class boj13416 {
    static int sum;
    public static void main(String[] args) {
        //[백준] 주식투자
        //500 800 200
        //300 0 300
        //-100 -200 -400
        //600 200 300
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); //테스트 데이터
        for (int i=0; i<T; i++) {
            int N = scanner.nextInt();
            for (int j=0; j<N; j++) {
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                int C = scanner.nextInt();
                int max = Math.max(A, Math.max(B, C));
                if (max > 0) {
                    sum += max;
                }
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}
