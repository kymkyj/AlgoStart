package backjoon;

import java.util.Scanner;
import java.util.Stack;

public class IronBarTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') {
                stack.push(ss[i]);
                continue;
            }

            count += (!stack.isEmpty() && stack.pop() == ss[i - 1]) ? stack.size() : 1;

        }
        System.out.println(count);
    }
}
