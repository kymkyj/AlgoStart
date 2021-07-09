package com.ji.beakjoon.dfs;

import java.util.Scanner;

/**
 * 징검다리 건너기
 * 
 * @author ji
 *
 */
public class CrossingBridgeDfs {

	static int[][] arr;
	static int stoneCount;
	static boolean done = true;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		stoneCount = input.nextInt();
		arr = new int[stoneCount - 1][2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		int k = input.nextInt();
		int sum = 0;
		dfs(1, k, done, sum);
		System.out.println(min);
	}

	public static void dfs(int personPosition, int k, boolean done, int sum) {
		if (personPosition == stoneCount) {//영재의 위치가 돌의 위치에 일치할 경우만
			min = Math.min(min, sum);
			return;
		} else if (personPosition < stoneCount) {//영재의 위치가 아직 돌을 못넘었을경우

			// 매우 큰 점프
			if (done == true) {//매우 큰점프는 한번만 동작
				sum += k;
				done = false;
				dfs(personPosition + 3, k, done, sum); 
				sum -= k;
				done = true;
			}

			// 작은 점프 값으로 sum증가 후 재귀
			sum += arr[personPosition - 1][0];
			dfs(personPosition + 1, k, done, sum);
			sum -= arr[personPosition - 1][0];

			// 큰 점프 값으로 sum 증가 후 재귀
			sum += arr[personPosition - 1][1];
			dfs(personPosition + 2, k, done, sum);
			sum -= arr[personPosition - 1][1];
		}

	}
}
