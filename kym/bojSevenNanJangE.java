package boj;

// 백준 일곱난쟁이
/*
    문제 분석
    1. 일곱난쟁이 인데 9명이 됬다.
    2. 일곱난쟁이의 키의 합은 100이다.
    3. 9명으로 난쟁이가 고정되어 있다.
    4. 위에서부터 9명의 난쟁이 키가 주어진다.
    5. 일곱난쟁이의 키를 오름차순 출력한다.

    입력 값
    20
    7
    23
    19
    10
    15
    25
    8
    13
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bojSevenNanJangE {
    static int [] arr;
    static int sum = 100;
    static int total = 0;
    static boolean ch = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        arr = new int [9];
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(total - (arr[i] + arr[j]) == sum){
                    arr[i] = 0;
                    arr[j] = 0;
                    ch = true;
                    break;
                }
                if(ch) break;
            }
        }
        Arrays.sort(arr);
        for(int i : arr){
            if(i == 0) continue;
            else {
                System.out.println(i);
            }
        }
    }
}
