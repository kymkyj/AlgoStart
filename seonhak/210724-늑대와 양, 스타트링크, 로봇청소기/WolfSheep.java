package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WolfSheep {

	static char map[][];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mapSizeInfo = br.readLine().split(" ");
		int rowSize = Integer.valueOf(mapSizeInfo[0]);
		int colSize = Integer.valueOf(mapSizeInfo[1]);
		
		map = new char[rowSize][colSize];
		boolean flag = true;

		for (int i = 0; i < rowSize; i++) {
			String wolfSeepInfo = String.valueOf(br.readLine());
			for (int j = 0; j < colSize; j++)
				map[i][j] = wolfSeepInfo.charAt(j);
		}

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				
				//늑대 주변에 울타리를 감싸주면 되는 문제
				if (map[i][j] == 'W') {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						//목장 안에 있을 경우만
						if(nx >=0 && nx< rowSize && ny >=0 && ny<colSize) {

							if (map[nx][ny] == '.') {
								map[nx][ny] = 'D';
							} else if (map[nx][ny] == 'S') {
								flag = false;
								System.out.println(0);
								return;
							}

						}

					}

				}

			}

		}

		if (!flag) {
			System.out.println(0);
		} else {
			System.out.println(1);
			for (int i = 0; i < rowSize; i++) {
				for (int j = 0; j < colSize; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}
}
