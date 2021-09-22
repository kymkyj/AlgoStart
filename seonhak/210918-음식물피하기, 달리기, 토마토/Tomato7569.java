package com.ji.beakjoon.bfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준7569 - 토마토
 * @author seonhak
 * @date 2021. 9. 17.
 */
public class Tomato7569 {

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Scanner sc = new Scanner(System.in);
		// 6개의 방향을 생각하는것이 중요
		int[] dy = { 0, 1, 0, -1, 0, 0 };//상하좌우위아래 
		int[] dx = { -1, 0, 1, 0, 0, 0 };//상하좌우위아래
		int[] dh = { 0, 0, 0, 0, -1, 1 };//상하좌우위아래

		int M = sc.nextInt(), N = sc.nextInt(), H = sc.nextInt();//가로, 세로, 판 개수
		int[][][] tomato = new int[N][M][H];
		int cnt = 0, days = 0;

		Queue<int[]> que = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					
					tomato[n][m][h] = sc.nextInt();
					
					if (tomato[n][m][h] == 1) {
						que.add(new int[] { n, m, h });
					} else if (tomato[n][m][h] == 0) {
						cnt++;
					}

				}
			}
		}

		// 익지 않은 토마토 가 있고, 큐에 노드가 있으면
		while (cnt > 0 && !que.isEmpty()) {

			for (int s = que.size(); s > 0; s--) {
				
				int[] cur = que.poll();// 익은 토마토 위치
				for (int k = 0; k < 6; k++) {
					int ny = cur[0] + dy[k]; // 세로
					int nx = cur[1] + dx[k]; // 가로
					int nh = cur[2] + dh[k]; // 토마토 판

					if (ny < 0 || nx < 0 || nh < 0 || ny >= N || nx >= M || nh >= H || tomato[ny][nx][nh] != 0)
						continue;

					cnt--;
					tomato[ny][nx][nh] = 1;//익게 처리

					que.add(new int[] { ny, nx, nh });
				}

			}
			// 날짜 증가
			days++;
		}

		bw.write(String.valueOf(cnt == 0 ? days : -1) + "\n");
		bw.flush();
		bw.close();

	}

}
