package study.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class boj10799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String bracket = scanner.nextLine();
        Stack<String> stack = new Stack<String>();

        for(int i=0; i<bracket.length(); i++) {

            if (bracket.charAt(i) == '(') {
                stack.push("(");
            } else if (bracket.charAt(i) == ')') {
                if(bracket.charAt(i-1) == '(') { //레이저
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
