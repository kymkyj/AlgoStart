package study.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class boj4949 {
    public static void main(String[] args) {
        //[백준] 균형잡힌 세상
        Scanner scanner = new Scanner(System.in);
        String sentence;

        while (true) {
            sentence = scanner.nextLine();
            if (sentence.equals(".")) {
                break;
            }
            System.out.println(solution(sentence));
        }
    }

    public static String solution(String sentence) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (ch == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
