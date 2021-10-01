package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준6087 - 레이저 통신
 * @author seonhak
 * @date 2021. 10. 1.
 */
public class LaserCommunication {

	static int N, M;
	static char[][] map;
	static int[][] visit;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static NodePair start, end;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] size = br.readLine().split(" ");
		M = Integer.parseInt(size[0]);
		N = Integer.parseInt(size[1]);
		map = new char[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], M * N);
		}

		boolean flag = false;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String tokenStr = st.nextToken();
			for (int m = 0; m < M; m++) {
				map[n][m] = tokenStr.charAt(m);
				if (map[n][m] == 'C') {
					if (flag) {
						end = new NodePair(n, m, 0, 4);
					} else {
						start = new NodePair(n, m, 0, 4);
						flag = true;
					}
				}
			}
		}

		int answer = bfs();
		bw.write(String.valueOf(answer) + "\n");
		bw.flush();
		bw.close();

	}

	private static int bfs() {

		Queue<NodePair> queue = new PriorityQueue<>();

		visit[start.r][start.c] = 0;
		queue.add(start);

		NodePair cur;
		while (!queue.isEmpty()) {

			cur = queue.poll();
			if (cur.r == end.r && cur.c == end.c) {
				return cur.cost;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '*') // 범위, 벽인지
					continue;

				if (cur.dir == i || cur.dir == 4) { // 방향이 같으면
					if (visit[nr][nc] >= cur.cost) {
						visit[nr][nc] = cur.cost;
						queue.add(new NodePair(nr, nc, cur.cost, i)); // i -> 큐에 현재 방향 저장 !!!
					}
				} else {
					if (visit[nr][nc] >= cur.cost + 1) {
						visit[nr][nc] = cur.cost + 1;// 거울 설치
						queue.add(new NodePair(nr, nc, cur.cost + 1, i)); // i -> 큐에 현재 방향 저장 !!!
					}
				}

			}

		}

		return -1;

	}

}

class NodePair implements Comparable<NodePair> {
	int r, c;
	int cost;
	int dir;

	public NodePair(int r, int c, int cost, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.cost = cost;
		this.dir = dir;
	}

	@Override
	public int compareTo(NodePair other) {
		return this.cost - other.cost;
	}
}
