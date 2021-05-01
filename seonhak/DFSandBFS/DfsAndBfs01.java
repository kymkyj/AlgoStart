package com.ji.beakjoon;

import java.util.Scanner;

public class DfsAndBfs01 {

	public static void main(String[] args) {

		int nV = 0; // 정점의 개수
		int nE = 0; // 간선의 개수
		int startNode = 0;

		Scanner sc = new Scanner(System.in);
		nV = sc.nextInt(); // 정점
		nE = sc.nextInt(); // 간선
		startNode = sc.nextInt();

		// 입력받은 정점의 개수로 그래프 초기화
		DfsGraph dfsGraph = new DfsGraph(nV);


		// 그래프에 정점과 간선 입력
		// 입력받은 간선의 개수만큼 반복
		// ex) 정점 8, 간선 10
//		dfsGraph.put(5, 4);
//		dfsGraph.put(5, 2);
//		dfsGraph.put(1, 2);
//		dfsGraph.put(3, 4);
//		dfsGraph.put(3, 1);

		// 정점과 간선 수동 입력

		for (int i = 0; i < nE; i++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			dfsGraph.put(v, e);
		}

		sc.close();

		// 입력한 정점과 간선으로 구성된 인접행렬 출력
//		dfsGraph.printGraphToAdjArr();

		// 정점 순서대로 그래프 탐색
		dfsGraph.dfs(startNode);

	}
}

class DfsGraph {
	private int nV; // 정점의 개수
	private int[][] dfsGraph; // 그래프
	private boolean[] visitArr; // 정점 방문 여부 확인 배열

	// 그래프 초기화
	public DfsGraph(int nV) {
		this.nV = nV;

		// 그래프 초기화
		// put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
		// 배열의 index는 0 부터 시작이므로
		// ArrayIndexOutOfBoundsException 방지를 위해
		// 정점을 담는 인접행렬의 행과 열 size는 1을 더하여 초기화해줌
		this.dfsGraph = new int[this.nV + 1][this.nV + 1];

		// 정점 방문 여부 확인 배열 초기화
		// 그래프와 마찬가지로 정점의 개수에 +1하여 초기화
		this.visitArr = new boolean[this.nV + 1];
	}

	// 그래프 return
	public int[][] getGraph() {
		return this.dfsGraph;
	}

	// 그래프 추가 (양방향)
	public void put(int x, int y) {
		// 정점 x와 y가 연결되어있음을 의미
		this.dfsGraph[x][y] = this.dfsGraph[y][x] = 1;
	}

	// 그래프 추가 (단방향)
	public void putSingle(int x, int y) {
		this.dfsGraph[x][y] = 1;
	}

	// 그래프 출력 (인접행렬)
	public void printGraphToAdjArr() {
		for (int i = 0; i < this.dfsGraph.length; i++) {
			for (int j = 0; j < this.dfsGraph[i].length; j++) {
				System.out.print(" " + this.dfsGraph[i][j]);
			}
			System.out.println();
		}
	}

	// 정점 방문 여부 확인 배열 초기화
	public void clearVisitArr() {
		for (int i = 0; i < this.visitArr.length; i++) {
			this.visitArr[i] = false;
		}
	}

	// 그래프 탐색 (재귀호출)
	public void dfs(int vIdx) {
		// dfs()에 들어온 vIdx는 방문한 것이므로
		// 방문배열의 해당 index값을 true로 바꿔주고 값을 출력함.
		this.visitArr[vIdx] = true;
		System.out.print(vIdx + " ");

		// 인접 행렬로 구현된 그래프에서
		// 정점의 개수(nV) 만큼 탐색
		for (int i = 1; i <= this.nV; i++) {

			// dfsGraph[][]의 해당 정점이 연결되어있는 것으로 표시되어 있으나 (연결은 1로 표시)
			// 방문 배열에서 방문하지 않은 상태(false)인 경우
			if (dfsGraph[vIdx][i] == 1 && visitArr[i] == false) {
				dfs(i); // dfs() 재귀호출
			}
		}
	}

}

