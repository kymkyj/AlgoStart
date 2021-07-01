package study.baekjoon.class3;

import java.util.Scanner;

public class boj1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 55-(50+40)
        String expression = scanner.next();
        int sum = Integer.MAX_VALUE;
        String[] sub = expression.split("-");
        for (String s : sub) {
            System.out.println("sub : " + s);
        }
        //50, 50+40
        for (int i=0; i<sub.length; i++) {
            int number = 0;
            String[] add = sub[i].split("\\+");
            for (String s : add) {
                System.out.println("add : " + s);
            }

            for (int j=0; j<add.length; j++) {
                number += Integer.parseInt(add[j]);
                System.out.println("number : " + number);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = number;
            } else {
                sum -= number;
            }
        }
        System.out.println(sum);
    }
}
