package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 백준16930 - 달리기
 * @author seonhak
 * @date 2021. 9. 17.
 */
public class Running {

	static int N, M, maxMoveCnt;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static int[][] visited;
	static int ret;

	static class Points {
		int x, y;

		public Points(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] mapInfo = br.readLine().split(" ");
		N = Integer.valueOf(mapInfo[0]);
		M = Integer.valueOf(mapInfo[1]);
		maxMoveCnt = Integer.valueOf(mapInfo[2]);

		map = new char[N][M];
		visited = new int[N][M];

		ret = 0;
		for (int i = 0; i < N; i++) {
			char[] gymInfo = br.readLine().toCharArray();
			Arrays.fill(visited[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				map[i][j] = gymInfo[j];
			}
		}

		Queue<Points> que = new LinkedList<>();
		String[] startEndPoints = br.readLine().split(" ");
		int x1 = Integer.parseInt(startEndPoints[0]) - 1;
		int y1 = Integer.parseInt(startEndPoints[1]) - 1;
		int x2 = Integer.parseInt(startEndPoints[2]) - 1;
		int y2 = Integer.parseInt(startEndPoints[3]) - 1;
		Points startPoint = new Points(x1, y1);
		Points endPoint = new Points(x2, y2);

		que.add(startPoint);
		visited[startPoint.x][startPoint.y] = 0;

		boolean isMoveSuccess = false;
		while (!que.isEmpty()) {
			Points cur = que.poll();
			if (cur.x == endPoint.x && cur.y == endPoint.y) {
				isMoveSuccess = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.x;
				int nc = cur.y;

				// 초당 움직일 수 있는 경우의 수를 모두 접근해봄
				for (int j = 0; j < maxMoveCnt; ++j) {
					nr += dr[i];
					nc += dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						break;
					
					//벽이거나 방문한 곳이라면
					if (visited[nr][nc] < visited[cur.x][cur.y] + 1 || map[nr][nc] == '#')
						break;

					//방문하지 않고 빈칸 인 경우
					if (visited[nr][nc] == Integer.MAX_VALUE && map[nr][nc] == '.') {
						visited[nr][nc] = visited[cur.x][cur.y] + 1;
						que.add(new Points(nr, nc));
					}

				}

			}

		}

		ret = !isMoveSuccess ? -1 : visited[endPoint.x][endPoint.y];
		bw.write(String.valueOf(ret) + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
