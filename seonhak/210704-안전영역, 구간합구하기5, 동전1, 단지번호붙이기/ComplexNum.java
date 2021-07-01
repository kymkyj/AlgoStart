package com.ji.beakjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 단지번호붙이기
 * @author ji
 *
 */
public class ComplexNum {

	static int complexMapSize = 0; //단지 지도 크기
	static int homeCnt = 0;//각 단지 집수
	static List<Integer> complexList = new ArrayList<Integer>(); //단지 크기 정보

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		complexMapSize = Integer.valueOf(br.readLine()); // 행렬 가로 길이
		int[][] complexGraph = new int[complexMapSize + 1][complexMapSize + 1];

		for (int i = 0; i < complexMapSize; i++) {
			String[] complexGraphInfo = String.valueOf(br.readLine()).split("");
			for (int j = 0; j < complexMapSize; j++)
				complexGraph[i][j] = Integer.valueOf(complexGraphInfo[j]);
		}

		for (int j = 0; j < complexMapSize; j++) {
			for (int i = 0; i < complexMapSize; i++) {
				if (complexGraph[i][j] == 1) {
					homeCnt = 0;
					dfs(complexGraph, i, j);
					complexList.add(homeCnt);
				}
			}
		}

		Collections.sort(complexList);

		bw.write(String.valueOf(complexList.size()) + "\n");
		for (int cnt : complexList)
			bw.write(String.valueOf(cnt) + "\n");

		br.close();
		bw.flush();
		bw.close();

	}

	static void dfs(int[][] graph, int i, int j) {
		int m = complexMapSize, n = complexMapSize;

		if (i < 0 || i >= m || j < 0 || j >= n || graph[i][j] != 1)
			return;

		//첫 단지 시작 이외 접근한 집은 -1처리
		graph[i][j] = -1;
		homeCnt++;

		dfs(graph, i - 1, j);// 위
		dfs(graph, i + 1, j);// 아래
		dfs(graph, i, j - 1);// 왼쪽
		dfs(graph, i, j + 1);// 오른쪽
	}

}
