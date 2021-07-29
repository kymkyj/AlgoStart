package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 스타트링크
 * 
 * @author ji
 *
 */
/*
 * 1. 시작점부터 큐에 넣어 up, down 이동경로를 다시 큐에 넣는다.
 * 
 * 2. 큐에서 나온 점이 도착점과 같다면 종료한다.
 * 
 * 3. 범위가 0보다 작거나 최대값인 F보다 크다면 패스한다.
 * 
 */
public class StartLink {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] floorInfos = br.readLine().split(" ");
		int F = Integer.valueOf(floorInfos[0]);
		int S = Integer.valueOf(floorInfos[1]);
		int G = Integer.valueOf(floorInfos[2]);
		int U = Integer.valueOf(floorInfos[3]);
		int D = Integer.valueOf(floorInfos[4]);

		// 방문한 층 배열에 저장
		int[] visitFloorArr = new int[F + 1];
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(S);
		visitFloorArr[S] = 1;

		int result = -1;
		while (!que.isEmpty()) {
			int cur = que.poll();
			if (cur == G) {
				result = visitFloorArr[cur] - 1;
				System.out.println(result);
				return;
			}

			// Up 버튼을 눌렀을 때 꼭대기 층보다 작거나 같을 경우
			// 방문 하지 않은 경우
			if (cur + U <= F && visitFloorArr[cur + U] == 0) {
				visitFloorArr[cur + U] = visitFloorArr[cur] + 1;
				que.add(cur + U);
			}

			// Down 버튼을 눌렀을때 건물은 1층 부터 시작 하기 때문에 0보다 커야함 
			// 방문 하지 않은 경우
			if (cur - D > 0 && visitFloorArr[cur - D] == 0) {
				visitFloorArr[cur - D] = visitFloorArr[cur] + 1;
				que.add(cur - D);
			}

		}
		
		//(만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)
		System.out.println("use the stairs");

	}

}
