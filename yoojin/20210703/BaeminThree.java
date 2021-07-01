package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
0. 문자열 입력 받기.
   0 -> char 배열로 받기.
   1 -> 3보다 큰지 체크.
   2 -> a의 값 cnt.
1. a가 3의배수인지 체크.
    0 -> 3의 배수가 아니면 return 0
2. 0개: 전체 문자열 3분할 알고리즘
    -> 문자열 7개의 삼분할 갯수 점화식: f(k) = f(k-1)+...+f(1)
    -> f(1) f(2) f(3) 은 당연히 1.
3. 3의배수 존재.
    0 -> a를 기준으로 3분할.(잘리는 인덱스 구간을 구하기)
    1 -> 3분할 후, 중간 배열값들 경우의 수 나누기. 2분할로 0일경우 포함. ==> f(k) = k+1
 */

public class BaeminThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] arr = br.readLine().toCharArray();
        System.out.print(solution(arr));
    }


    static public int solution(char [] arr){
        if( arr.length<3) return 0;
        int cnt =0;
        ArrayList<Integer> aIdxList = new ArrayList<Integer>();
        aIdxList.add(-1); // 인덱스 위치 안헷갈릴려고(1~k까지)
        for(int i=0; i< arr.length; i++){
            if(arr[i] == 'a'){
                aIdxList.add(i);        //a의 인덱스를 저장
            }
        }
        int acnt = aIdxList.size()-1;

        if(acnt %3 != 0) return 0;
        else if(acnt == 0){
            return thDivision(arr.length);
        }else{
            for(int i = 2; i<= acnt-2; i++){
                int s =acnt-i; //첫번째 분할되는 인덱스.
                for(int j=s+1; j<= acnt-1; j++){
                    //j => 처음 분할되는 인덱스와 마지막 k 사이에서 두번째 분할 되는 인덱스
                    //처음 분할되는 a,___,a 사이의 b를 분할하는 경우의 수 * 두번째 분할 되는 a,___,a사이의 b를 분할하는 경우의 수
                    cnt+=( aIdxList.get(s+1)- aIdxList.get(s))*( aIdxList.get(j+1)-aIdxList.get(j) );
                }
            }
        }
        return cnt;
    }

    static public int thDivision(int k){
        if( k==1) return 1;
        if(k==2) return 1;
        if(k==3) return 1;

        int result =0;
        for(int i=1; i<k ;i++){
            result +=thDivision(i);
        }

        return result;
    }


}
