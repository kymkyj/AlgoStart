package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SearchParentsTree {

	static int nodeNum, edgeNum;
//	static int[][] graph;
	static ArrayList<Integer> ad[];
	static boolean[] DFSisVisited;
	static int result[];

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		nodeNum = Integer.valueOf(br.readLine());
		DFSisVisited = new boolean[nodeNum + 1];
//		graph = new int[nodeNum + 1][nodeNum + 1];
		result = new int[nodeNum + 1];
		ad = new ArrayList[nodeNum +1];
		
		for(int i=1; i<=nodeNum; i++)
			ad[i] = new ArrayList<>();
		
		for (int i = 0; i < nodeNum - 1; i++) {
			String[] edgeNumbers = br.readLine().split(" ");
			int a = Integer.valueOf(edgeNumbers[0]);
			int b = Integer.valueOf(edgeNumbers[1]);
			ad[a].add(b);
			ad[b].add(a);
			
		}

		//메모리 초과!!!
//		for (int i = 0; i < nodeNum - 1; i++) {
//			String[] edgeNumbers = br.readLine().split(" ");
//			int a = Integer.valueOf(edgeNumbers[0]);
//			int b = Integer.valueOf(edgeNumbers[1]);
//			graph[a][b] = b;
//			graph[b][a] = a;
//		}

		dfs(1);
		for (int i = 2; i <= nodeNum; i++)
			bw.write(result[i] + "\n");

		bw.flush();
		bw.close();
	}
	
	static void dfs(int node) {
		// 방문한 노드 번호에 대한 boolean 처리
		DFSisVisited[node] = true;
		for(int index : ad[node]) {
			if(!DFSisVisited[index]) {
				result[index] = node;
				dfs(index);
			}
		}
	}

}
