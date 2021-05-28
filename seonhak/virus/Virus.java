package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Virus {

	static int computerCnt, connectPairCnt;
	static int[][] graph;
	static boolean[] DFSisVisited;
	static List<Integer> DFSvisitArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		computerCnt = Integer.parseInt(br.readLine());// 노드 갯수
		connectPairCnt = Integer.parseInt(br.readLine()); // 간선 갯수
		graph = new int[computerCnt + 1][computerCnt + 1];
		DFSisVisited = new boolean[computerCnt + 1]; //방문 정보 초기화

		DFSvisitArr = new ArrayList<Integer>();

		for (int i = 0; i < connectPairCnt; i++) {
			String[] comPairNum = String.valueOf(br.readLine()).split(" ");
			int a = Integer.parseInt(comPairNum[0]);
			int b = Integer.parseInt(comPairNum[1]);
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		for (int i = 0; i < computerCnt + 1; i++) {
			DFSisVisited[i] = false;
		}

		dfs(1);

		Integer result = DFSvisitArr.size() - 1;
		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();

	}

	static void dfs(int nodeNum) {
		// 방문한 노드 번호에 대한 boolean 처리
		DFSisVisited[nodeNum] = true;
		// 방문한 순서에 대한 노드 정보 리스트 저장
		DFSvisitArr.add(nodeNum);
		for (int i = 1; i <= computerCnt; i++) {
			if (graph[nodeNum][i] == 1 && DFSisVisited[i] == false) {
				dfs(i);
			}
		}
	}

}
