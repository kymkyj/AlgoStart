package com.ji.main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiscoController {

	public static void main(String[] args) {
		int result = solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } });
		System.out.println(result);
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		int count = 0;// 처리된 디스크
		int now = 0;// 작업이 끝난시간

		//요청시간 순으로 오름 차순 정렬
		Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));

		// 처리 시간 오름 차순 정렬되는 우선 순위 큐
		PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
		
		int i = 0;
		while (count < jobs.length) {
			
			// 하나의 작업이 완료될때까지 모든 요청을 큐에 넣음
			while (i < jobs.length && jobs[i][0] <= now) {
				queue.add(jobs[i++]);
			}

			// queue가 비어있을 경우는 작업 완료 이후
			if (queue.isEmpty()) {
				now = jobs[i][0];//다음 작업의 요청 시작 시작으로 맞춰줌
			} else { 
				//우선순위 큐에 의해서 수행 시간이 가장 짧은 처리 디스크 반환
				int[] tmp = queue.poll();
				answer += tmp[1] + now - tmp[0];
				now += tmp[1];
				count++;
			}
		}

		return answer / jobs.length;
	}

}
