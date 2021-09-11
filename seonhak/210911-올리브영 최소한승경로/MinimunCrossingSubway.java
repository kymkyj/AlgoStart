package com.ji.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimunCrossingSubway {
	
	static int N, M; 
	static boolean[] visitedLine; 
	static boolean[] visitedStation; 
	static ArrayList<Integer>[] stations; 
	static ArrayList<Integer>[] lines; 
	
	
	public static void main(String[] args) {
		String[] subwayT1 = { "1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21" };
		System.out.println(solution(subwayT1, 1, 9));
		
//		String[] subwayT2 = { "1 2 3 4 5 6 7 8 9 10", "2 8"};
//		System.out.println(solution(subwayT2, 1, 9));
////		
//		String[] subwayT3 = { "0 1 2 3 4", "1 12 13 14"};
//		System.out.println(solution(subwayT3, 2, 12));
	}
	
	public static int solution(String[] subway, int start, int end) {
		
		Integer subwayCnt = 0;
		Integer maxSubwayNum = Integer.MIN_VALUE;
		for(String subwayStr : subway) {
			subwayCnt+=subwayStr.split(" ").length;
			for(String sub: subwayStr.split(" ")) {
				int sInt = Integer.parseInt(sub);
				if(sInt >= maxSubwayNum)
					maxSubwayNum = sInt;
			}
		}
		
		// 지하철역 최종 번호가 노선의 값 보다 작은 경우
		N = (subwayCnt < maxSubwayNum)?maxSubwayNum:subwayCnt; //지하철 갯수
		M =subway.length; //노선의 갯수
		
		visitedLine = new boolean[M];
		visitedStation = new boolean[N];
		stations = new ArrayList[N+1];
		lines = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			stations[i] = new ArrayList<>();
			lines[i] = new ArrayList<>();
		}
		
		for(int i= 0; i<M; i++) {
			String[] s = subway[i].split(" ");
			for(String station : s) {
				int statN = Integer.parseInt(station);
				stations[statN].add(i+1);
				lines[i+1].add(statN); //중요!!!!
			}
		}
		
		
		int answer = go(start, end);
		return answer;
	}

	private static int go(int start, int end) {
		//모든 경우에 대한 환수 갯수 중에서 최소값을 찾아야하게 때문에 우선순위 큐를 사용
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.transCount));
		visitedStation[start] = true; //역 방문 처리
		for(int line : stations[start]) {
			pq.add(new Node(line, start, 0));
			visitedLine[line] = true; //노선 방문 처리
		}
		
		while(!pq.isEmpty()) {
			Node now = pq.poll(); //현재 접근한 역
			
			//현재역이 종착역(end)인 경우 
			if(now.curStation == end) {
				return now.transCount;
			}
			
			//현재 접근한 노선의 역 조회
			//  lines[now.curLine] => 각 배열마다 역 정보가 저장되어 있음
			// 노선 별로 해당 역을 접근했는지 검사
			for(int nextStation : lines[now.curLine]) {
//				System.out.print(nextStation+" ");
				if(!visitedStation[nextStation]) {//방문한 역이 아닌경우
					visitedStation[nextStation] = true;//해당역 방문 처리
					pq.add(new Node(now.curLine, nextStation, now.transCount));
					
					// 각 역이 있는 노선 검사 
					// 노선 별 검사에서 방문하지 않은역이고, 
					// 역별 검사에서 방문하지 않은 역이면 각 노선에 둘다 있는 역이므로 확승 count 증가
					for(int nextLine: stations[nextStation]) {
						if(!visitedStation[nextLine]) {
							visitedStation[nextLine] = true;
							pq.add(new Node(nextLine, nextStation, now.transCount+1));
						}
					}
				}
				
			}
		}
		
		return 0;
	}
	
	private static class Node{
		int curLine; 
		int curStation; 
		int transCount;
		
		public Node(int curLine, int curStation, int transCount) {
			super();
			this.curLine = curLine;
			this.curStation = curStation;
			this.transCount = transCount;
		} 
		
	}
	
}
