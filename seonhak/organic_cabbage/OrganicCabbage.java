package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OrganicCabbage {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.valueOf(br.readLine());

		for (int t = 0; t < testCase; t++) {

			String[] plantCabbageInfo = br.readLine().split(" ");
			int fieldCntHorizantal = Integer.valueOf(plantCabbageInfo[0]); // 행렬 가로 길이
			int fieldCntVertical = Integer.valueOf(plantCabbageInfo[1]);// 행렬 세로 길이
			int plantCabbageCnt = Integer.valueOf(plantCabbageInfo[2]);//행렬에 1이 있는 위치
			int[][] graph = new int[fieldCntHorizantal + 1][fieldCntVertical + 1];

			for (int i = 0; i < plantCabbageCnt; i++) {
				String[] comPairNum = String.valueOf(br.readLine()).split(" ");
				int a = Integer.parseInt(comPairNum[0]);
				int b = Integer.parseInt(comPairNum[1]);
				graph[a][b] = 1;
			}

			int count = 0;
			for (int j = 0; j < fieldCntVertical ; j++) {
				for (int i = 0; i < fieldCntHorizantal ; i++) {
					if (graph[i][j] == 1) {
						//행렬을 돌면서 처음 1이 나온 경우 count
						count++;
						
						//점화식
						//1로 시작하면 동서남북 검사 후 동서남북에 걸리면 -1로 변환
						//1주변에 1이 없을 경우 재귀 탈출
						dfs(graph, i, j);
					}
				}
			}
			
			bw.write(String.valueOf(count)+"\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}

	static void dfs(int[][] graph, int i, int j) {
		int m = graph.length; //가로 행렬 크기
		int n = graph[0].length; // 세로 행렬 크기
		
		//행렬에서 0이거나 마지막에 있는 값일 경우 재귀 탈출
		if (i < 0 || i >= m || j < 0 || j >= n || graph[i][j] != 1)
			return;
		
		//처음 1이 나오고 근처에 있는 1일 경우 -1로 바꿈
		graph[i][j] = -1;

		dfs(graph, i - 1, j);// 위
		dfs(graph, i + 1, j);// 아래
		dfs(graph, i, j - 1);// 왼쪽
		dfs(graph, i, j + 1);// 오른쪽
	}

}
