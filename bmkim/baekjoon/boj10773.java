또package study.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class boj10773 {
    static int K;
    static int number;
    static int answer = 0;
    public static void main(String[] args) {
        //[백준] 제로
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        K = scanner.nextInt();
        for (int i=0; i<K; i++) {
            number = scanner.nextInt();
            if (number == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        for (int numbers : stack) {
            answer += numbers;
        }

        System.out.println(answer);
    }
}
