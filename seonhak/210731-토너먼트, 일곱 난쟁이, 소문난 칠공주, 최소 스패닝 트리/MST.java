package com.ji.beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 신장 트리
 * Kruskal Algo
 * 1. 가중치가 가장 작은 간선을 찾아서 선택
 * 2. 가중치가 작은 간선이 값이 동일할 경우 노드의 번호가 빠른거 선택
 * 3. 순환이 생길 경우는 건너뜀
 * @author ji
 *
 */
public class MST {

	static int n, m;
	static int[] parent;
	static PriorityQueue<edge> pq = new PriorityQueue<edge>();
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());//정점 갯수
		m = Integer.parseInt(st.nextToken());//간선 갯수

		parent = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			//A정점, B정점, 간선 가중치
			pq.add(new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}

		// 시작점과 종료점의 최상위 노드를 찾아서 겹치면 사이클이 생기는 것이므로 continue를 한다.
		// 아니면 union을 통해 연결하고 v(가중치) 를 더해준다.
		for (int i = 0; i < m; i++) {
			edge tmp = pq.poll();

			int a = find(tmp.s);
			int b = find(tmp.e);

			//순환이 생기므로 패스
			if (a == b)
				continue;
			union(a, b);
			result += tmp.v;
		}

		System.out.println(result);

	}

	// 이 부분이 이해가 확실히 가지 않음 !!!
	// 크루스칼의 기본 union find!! 외워두는게 편하다.
	public static int find(int a) {
		if (a == parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parent[aRoot] = b;
		} else {
			return;
		}
	}
}

//간선 class
//우선순위 큐를 사용하기 위해서 Comparable을 통해 정렬 우선순위를 정했다. (V 기준)
//가중치가 작은 간선을 선택!!!
class edge implements Comparable<edge> {
	int s;
	int e;
	int v;

	public edge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(edge arg0) {
		// TODO Auto-generated method stub
		return arg0.v >= this.v ? -1 : 1;
	}

}
