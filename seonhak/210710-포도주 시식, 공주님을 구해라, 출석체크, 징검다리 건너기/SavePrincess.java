package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SavePrincess {
	static int N, M, T;
	static int map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int ret;
	static class Pair{
		int r,c,time;
		int item;
		
		public Pair(int r, int c,  int item, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.item = item;
		}
		
	}
	
	static ArrayList<Pair> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		T = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		ret = 0;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		bfs();
		if(ret!=0)
			System.out.println(ret);
		else
			System.out.println("Fail");
	}
	private static void bfs() {
		boolean visit[][][] = new boolean[2][N][M]; //검 유무, 세로, 가로
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0,0,0));
		visit[0][0][0] = true;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			if(cur.r == N-1 && cur.c == M-1) {
				if(cur.time <= T)
					ret = cur.time;
				break;
			}
			if(cur.time > T)
				break; 
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=M||visit[cur.item][nr][nc]) continue;
				
				//방문하지 않고 아이템이 없는 경우
				if(cur.item==0) {
					
					if(map[nr][nc] == 0) {
						visit[0][nr][nc] = true;
						q.add(new Pair(nr,nc,0, cur.time +1));
					}else if(map[nr][nc]==2) {
						visit[1][nr][nc]=true;
						q.add(new Pair(nr,nc, 1, cur.time+1));
					}
					
				}else {//방문하지 않고 아이템이 있는 경우 벽 뚫기 가능
					if(map[nr][nc]==1||map[nr][nc]==0) {
						visit[1][nr][nc]=true;
						q.add(new Pair(nr,nc, 1, cur.time+1));
					}
				}
				
			}
		}
		
	}

}
