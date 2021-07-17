package study.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class boj2110 {
    static int N;
    static int C;
    static int[] house;
    static int answer = 0;
    public static void main(String[] args) {
        //[백준] 공유기 설치
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        C = scanner.nextInt();
        house = new int[N];

        for (int i=0; i<N; i++) {
            house[i] = scanner.nextInt();
        }

        Arrays.sort(house);

        int left = 1; //최소 길이
        int right = house[N-1]-house[0]; //최대 길이

        while (left <= right) {
            int mid = (left+right)/2;
            int prevHouse = house[0];
            int count = 1; //공유기 설치 개수

            for (int i=0; i<N; i++) {
                int distance = house[i] - prevHouse;
                if (distance >= mid) {
                    count++;
                    prevHouse = house[i];
                }
            }
            if (count >= C) {
                left = mid+1;
                answer = mid;
            } else {
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}

