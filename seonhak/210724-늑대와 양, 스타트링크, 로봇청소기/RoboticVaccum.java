package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int r, c;

	Pair(int a, int b) {
		r = a;
		c = b;
	}
}

public class RoboticVaccum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static char[][] map;
	static int R, C, NOWR = 0, NOWC = 0, totalTime, dirtyCount;
	static int[][] table;
	static ArrayList<Pair> dirtyPoint;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	/**
	 * 문제 분석 : 
	 * DFS, BFS를 결합하여 최종 결과를 도출해냄
	 * 1. 더러운 칸과 로봇 청소기 사이의 거리를 table이라는 변수에 저장한다. (BFS)
	 * 2. 더러운 칸을 방문하는 경우의 수을 통해서 table의 저장된 거리 정보의 값을 통해서 최소 시간 값을 계산함(DFS)
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
	
		while (true) {
			//입력값 초기화
			if (!initAndInput()) {
				return;
			} else {
				//첫번쨰 더러운 캇을 마지막 값으로 저장
				dirtyPoint.add(dirtyPoint.get(0));
				//더러운 칸 0번째에 청소기 청음 위치를 저장
				dirtyPoint.set(0, new Pair(NOWR, NOWC));
				dirtyCount++;
	
				for (int i = 0; i < dirtyPoint.size(); i++) {
					table[i][i] = 0;
					for (int j = i + 1; j < dirtyPoint.size(); j++) {
						//bfs를 통해서 각 점사이의 거리를 구함
						table[i][j] = table[j][i] = bfs(i, j);
					}
				}
	
				ArrayList<Integer> list = new ArrayList<>();
				boolean[] isVisit = new boolean[dirtyCount];
	
				make(dirtyCount - 1, list, isVisit);
			}
			if (totalTime < 0)
				totalTime = -1;
			bw.write(totalTime + "\n");
			bw.flush();
		}
	}

	static int pI(String s) {
		return Integer.parseInt(s);
	}

	static boolean isRange(int r, int c) {
		return 0 <= r && r < R && c >= 0 && c < C;
	}

	static boolean initAndInput() throws IOException {
		st = new StringTokenizer(br.readLine());

		C = pI(st.nextToken());
		R = pI(st.nextToken());

		//마지막 값의 경우 예외 처리
		if (R == 0 && C == 0)
			return false;

		map = new char[R][C];

		dirtyPoint = new ArrayList<>();
		totalTime = Integer.MAX_VALUE;
		dirtyCount = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j = 0; j < C; j++) {

				map[i][j] = temp.charAt(j);
				//청소기 위치 저장
				if (map[i][j] == 'o') {
					NOWR = i;
					NOWC = j;
					map[i][j] = '.';
				}
				//더러운 칸 좌표 dirtPoint 리스트에 저장
				if (map[i][j] == '*') {
					dirtyPoint.add(new Pair(i, j));
					dirtyCount++;
				}
			}
		}

		table = new int[dirtyCount + 1][dirtyCount + 1];

		return true;
	}

	static int bfs(int src, int dest) {
		boolean[][] Visited = new boolean[R + 1][C + 1];
		Queue<Pair> q = new LinkedList<>();
		Queue<Integer> time = new LinkedList<>();
		Pair start;
		if (src == -1) {
			start = new Pair(NOWR, NOWC);
		} else {
			start = dirtyPoint.get(src);
		}

		Pair destination = dirtyPoint.get(dest);
		q.add(start);
		time.add(0);
		Visited[start.r][start.c] = true;

		while (!q.isEmpty()) {
			int rr = q.peek().r;
			int cc = q.poll().c;
			int currentTime = time.poll();

			if (rr == destination.r && cc == destination.c) {
				return currentTime;
			}

			for (int i = 0; i < 4; i++) {
				int nr = rr + dr[i];
				int nc = cc + dc[i];
				if (isRange(nr, nc) && !Visited[nr][nc] && map[nr][nc] != 'x') {
					Visited[nr][nc] = true;
					q.add(new Pair(nr, nc));
					time.add(currentTime + 1);
				}
			}
		}
		return Integer.MIN_VALUE;
	}

	//dfs를 통해서 순열을 구함 
	static void make(int dirty, ArrayList<Integer> list, boolean[] isVisit) {
		// 순서 지정이 모두 끝났다.
		// 테이블 안에 거리 정보를 통해서 최소 시간값을 구한다.
		if (dirty == 0) {
			int nowSum = table[0][list.get(0)];
			for (int i = 0; i < list.size() - 1; i++) {
				nowSum += table[list.get(i)][list.get(i + 1)];
			}
			totalTime = Math.min(totalTime, nowSum);
			return;
		}

		for (int i = 1; i < dirtyPoint.size(); i++) {
			if (!isVisit[i]) {
				ArrayList<Integer> currentList = new ArrayList<>(list);
				currentList.add(i);

				isVisit[i] = true;
				make(dirty - 1, currentList, isVisit);
				isVisit[i] = false;
			}
		}
	}

}
