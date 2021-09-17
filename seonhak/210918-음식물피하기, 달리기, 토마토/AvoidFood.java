package com.ji.beakjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 백준1743 - 음식물피하기
 * @author seonhak
 * @date 2021. 9. 17.
 */
public class AvoidFood {

	static int map[][];
	static int N, M;
	static int foodCnt;

	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int foodSize = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mapInfo = br.readLine().split(" ");
		N = Integer.parseInt(mapInfo[0]); // 세로길이
		M = Integer.parseInt(mapInfo[1]); // 가로길이
		foodCnt = Integer.parseInt(mapInfo[2]);

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < foodCnt; i++) {
			String[] points = br.readLine().split(" ");
			int xPoint = Integer.parseInt(points[0])-1;
			int yPoint = Integer.parseInt(points[1])-1;
			map[xPoint][yPoint] = 1; //좌표 배치 -1
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					foodSize = 0;
					dfs(i, j);
					
					if(foodSize > max)
						max = foodSize;
				}
			}
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();

	}

	static void dfs(int i, int j) {
		foodSize++;
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int nx = dx[k] + i;
			int ny = dy[k] + j;

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (!visited[nx][ny] && map[nx][ny] == 1) 
					dfs(nx, ny);
			}
		}
	}

}
