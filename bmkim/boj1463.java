package study.baekjoon;

import java.util.Scanner;

public class boj1463 {
    static Integer[] dp;
    public static void main(String[] args) {
        //1로 만들기
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;
        System.out.println(calculate(N));
    }

    public static int calculate(int number) {
        if (dp[number] == null) {
            //2와 3의 배수인 6에 대한 케이스는 생각치도 못했다
            if (number%6 == 0) {
                dp[number] = Math.min(calculate(number-1), Math.min(calculate(number/3), calculate(number/2)))+1;
            } else if (number%3 == 0) {
                dp[number] = Math.min(calculate(number/3), calculate(number-1))+1;
            } else if (number%2 == 0) {
                dp[number] = Math.min(calculate(number/2), calculate(number-1))+1;
            } else {
                dp[number] = calculate(number-1)+1;
            }
        }
        return dp[number];
    }

    //바보같은 풀이
    /*
    public static void calculate(int number) {
        if (number == 1) {
            return;
        }
        if (number%3 == 0) {
            int num = number/3;
            answer++;
            calculate(num);
        } else if (number%2 == 0) {
            int num = number/2;
            answer++;
            calculate(num);
        } else {
            int num = number-1;
            answer++;
            calculate(num);
        }
    }
    */
}
