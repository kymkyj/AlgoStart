package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 알파벳 찾기
/*
    baekjoon    1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 */
public class boj10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] arr = br.readLine().toCharArray();
        int [] answer = new int[26];
        for(int i=0; i<answer.length; i++){
            answer[i] = -1;
        }
        for(int i=0; i<arr.length; i++) {
            int tmp = arr[i] - 97; // 배열의 위치
            if(answer[tmp] == -1){ // 중복되는 값이 있으면 처음위치로 표시하기위해
                answer[tmp] = i;
            }
        }
        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}
