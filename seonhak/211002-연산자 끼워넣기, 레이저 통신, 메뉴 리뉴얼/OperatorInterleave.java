package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준14888 - 연산자 끼워넣기
 * @author seonhak
 * @date 2021. 10. 1.
 */
public class OperatorInterleave {
	
	public static int MAX = Integer.MIN_VALUE;	// 최댓값 
	public static int MIN = Integer.MAX_VALUE;	// 최솟값 
	public static int[] operatorArr = new int[4];	// 연산자 개수 
	public static int[] numbersArr;					// 숫자 
	public static int N;						// 숫자 개수 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbersArr = new int[N];
		operatorArr = new int[4];
		
		//숫자 초기화
		String[] readNumbers = br.readLine().split(" ");
		for(int i=0; i<N; i++)
			numbersArr[i] = Integer.parseInt(readNumbers[i]);
		
		//연산자 초기화
		String[] readOperatorArr = br.readLine().split(" ");
		for(int i=0; i<4; i++)
			operatorArr[i] = Integer.parseInt(readOperatorArr[i]);
		
		dfs(numbersArr[0], 1);
		
		System.out.println(MAX);
		System.out.println(MIN);
		
	}
	
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if (operatorArr[i] > 0) {
 
				// 해당 연산자를 1 감소시킨다.
				operatorArr[i]--;
 
				switch (i) {
					case 0:	dfs(num + numbersArr[idx], idx + 1);	break;
					case 1:	dfs(num - numbersArr[idx], idx + 1);	break;
					case 2:	dfs(num * numbersArr[idx], idx + 1);	break;
					case 3:	dfs(num / numbersArr[idx], idx + 1);	break;
				}
				
				// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
				operatorArr[i]++;
			}
		}
	}

}
