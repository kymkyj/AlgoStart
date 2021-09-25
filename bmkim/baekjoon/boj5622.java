package study.baekjoon.implementation;


import java.util.Scanner;

public class boj5622 {
    static int answer = 0;
    public static void main(String[] args) {
        //[백준] 다이얼
        Scanner scanner = new Scanner(System.in);
        String alphabet = scanner.nextLine();

        for (int i=0; i<alphabet.length(); i++) {
            switch (alphabet.charAt(i)) {
                case 'A' : case 'B' : case 'C' :
                    answer += 3;
                    break;
                case 'D' : case 'E' : case 'F' :
                    answer += 4;
                    break;
                case 'G' : case 'H' : case 'I' :
                    answer += 5;
                    break;
                case 'J' : case 'K' : case 'L' :
                    answer += 6;
                    break;
                case 'M' : case 'N' : case 'O' :
                    answer += 7;
                    break;
                case 'P' : case 'Q' : case 'R' : case 'S' :
                    answer += 8;
                    break;
                case 'T' : case 'U' : case 'V' :
                    answer += 9;
                    break;
                case 'W' : case 'X' : case 'Y' : case 'Z' :
                    answer += 10;
                    break;
                default:
                    break;
            }
        }
        System.out.println(answer);
    }
}
