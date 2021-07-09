package com.ji.beakjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 안전 영역 
 * (실패)
 * @author ji
 *
 */
public class SafeZoneDfs {

	static int[][] safeZoneMap;//안전구역 정보
	static int safeZoneMapSize = 0; //안전구역 맵 크기
	static boolean[][] DFSisVisited;
	static List<Integer> list;//각 수위 경계값에 따른 결과 값 저장
	static int[] dx = {1, -1, 0, 0}; //상하좌우위아래
	static int[] dy = {0, 0, 1, -1}; 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		safeZoneMapSize = Integer.valueOf(br.readLine()); // 행렬 가로 길이
		safeZoneMap = new int[safeZoneMapSize][safeZoneMapSize];
		DFSisVisited = new boolean[safeZoneMapSize][safeZoneMapSize];
		
		int max = 0;
		for (int i = 0; i < safeZoneMapSize; i++) {
			String[] complexGraphInfo = String.valueOf(br.readLine()).split(" ");
			for (int j = 0; j < safeZoneMapSize; j++) {
				safeZoneMap[i][j] = Integer.valueOf(complexGraphInfo[j]);
				if(max < safeZoneMap[i][j])
					max = safeZoneMap[i][j];
			}
		}
		
		list = new ArrayList<>();
		
		for(int depth=0; depth<=max ; depth++) {
			int cnt = 0; 
			for (int i = 0; i < safeZoneMapSize; i++) {
				for (int j = 0; j < safeZoneMapSize; j++) {
					if(safeZoneMap[i][j] > depth && !DFSisVisited[i][j]) {
						cnt++;
						dfs(i, j, depth);
					}
					
				}
			}
			
			//dfs 방문정보 초기화!!!!
			for(boolean a[]:DFSisVisited)
				Arrays.fill(a, false);
			list.add(cnt);
		}
		
		int maxResult = Collections.max(list);
		bw.write(String.valueOf(maxResult) );

		br.close();
		bw.flush();
		bw.close();

	}

	public static void dfs(int x, int y, int depth) {
		DFSisVisited[x][y] = true;
		
		for(int i=0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && ny >=0 && nx < safeZoneMap.length && ny< safeZoneMap.length) {
				if(safeZoneMap[nx][ny] > depth && !DFSisVisited[nx][ny])
					dfs(nx, ny, depth);
			}
			
		}

	}

}
