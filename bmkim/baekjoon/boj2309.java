package study.baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class boj2309 {
    static int[] dwarf = new int[9];
    static boolean check = false;
    static int sum = 0;
    public static void main(String[] args) {
        //[백준] 일곱 난쟁이
        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<dwarf.length; i++) {
            dwarf[i] = scanner.nextInt();
            sum += dwarf[i];
        }

        for (int i=0; i<dwarf.length; i++) {
            if (check) break;
            for (int j=0; j<dwarf.length; j++) {
                if (i == j) continue;
                if (sum - dwarf[i] - dwarf[j] == 100) {
                    dwarf[i] = 0;
                    dwarf[j] = 0;
                    check = true;
                    break;
                }
            }
        }
        Arrays.sort(dwarf);

        for (int i=0; i<dwarf.length; i++) {
            if (dwarf[i] != 0) System.out.println(dwarf[i]);
        }
    }
}
