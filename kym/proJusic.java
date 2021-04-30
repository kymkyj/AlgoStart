package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



class projusic {
    public static void main(String[] args) {
        int [] prices = {1,2,3,2,3};
        for(int i : solution(prices)){
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] prices) {
        // prices 주식가격이 담긴 배열
        int[] answer = new int[prices.length]; // 가격의 기간을 담을 배열
        int count=0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                count++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            answer[i] = count;
            count=0;
        }

        return answer;
    }
}

