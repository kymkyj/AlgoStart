package com.ji.beakjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 일곱 난쟁이 2309번
 * 
 * @author ji
 *
 */
public class SevenDwarfs {
	
	public static int[] output = new int[7]; // 순열 출력을 위한 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] allDwarfs = new int[9];
		for (int i = 0; i < 9; i++)
			allDwarfs[i] = Integer.valueOf(br.readLine());
		
		per1(allDwarfs, 0, allDwarfs.length, 7);
		
		Arrays.sort(output);
		for(int res : output)
			System.out.println(res);
	}

	//순열을 이용한 경우의 수
	static void per1(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			int sum = 0;
			for (int i = 0; i < r; i++) 
				sum += arr[i];
			
			if(sum == 100) {
				for (int i = 0; i < r; i++) 
					output[i] = arr[i];
			}
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 Swap 함수
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
