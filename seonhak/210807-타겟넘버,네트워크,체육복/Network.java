package com.ji.study;

public class Network {
	
	public static void main(String[] args) {
		int n = 3;
		int[][] com = {{1,1,0},{1,1,1},{0,1,1}};
		System.out.println(solution(n, com));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		// computers.length => 3
		boolean[] visited = new boolean[computers.length];
		
		for(int i=0; i<computers.length; i++) {
				if(visited[i] == false) {
					answer++;
					dfs(i,visited,computers);
				}
				
		}
		
		return answer;
	}
	
	static void dfs(int node, boolean[] visited, int[][] computers) {
		visited[node] = true;
		
		for(int i=0; i< computers.length; i++) {
			if(visited[i] == false && computers[node][i] == 1)
				dfs(i, visited, computers);
		}
	}

}
