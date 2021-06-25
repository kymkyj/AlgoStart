package com.ji.beakjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 강의실 배정
 * @author ji
 *
 */
public class AssignClassroom {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//입력값 초기화
		Integer N = Integer.valueOf(br.readLine());
		List<Lecture> lectureList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] lectureInfo = br.readLine().split(" ");
			lectureList.add(new Lecture(Integer.parseInt(lectureInfo[0]), Integer.parseInt(lectureInfo[1])));
		}

		//시작 시간을 기준으로 오름차순 정렬
		Collections.sort(lectureList, new Comparator<Lecture>() {
			@Override
			public int compare(Lecture s1, Lecture s2) {
				if (s1.getStartTime() == s2.getStartTime()) {
						return s1.getEndTime() - s2.getEndTime();
				}
				return s1.getStartTime() - s2.getStartTime();
			}
		});
		
		//O(NLogN)
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(lectureList.get(0).getEndTime());

		for (int i = 1; i < N; i++) {
			//(즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
			//위 조건에 의해서 큐안에 끝나는 시간 보다 앞에 있는 수업이라면 같이 들을 수 있게 됨
			if (priorityQueue.peek() <= lectureList.get(i).getStartTime())
				priorityQueue.poll();//우선순위가 높은게 먼저 poll(endTime 낮은)

			//강의 끝나는 시간 큐에 저장이 새로운 강의실 배정을 하게 되는 것
			priorityQueue.add(lectureList.get(i).getEndTime());
		}

		//결국 큐의 크기가 
		bw.write(String.valueOf(priorityQueue.size()) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}

class Lecture {
	Integer startTime;
	Integer endTime;

	public Lecture(Integer startTime, Integer endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

}
