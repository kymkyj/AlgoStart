package com.ji.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FunctionDev {

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		for (int num : solution(progresses, speeds)) {
			System.out.println(num);
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		for (int i = 0; i < progresses.length; i++) {
			queue.add((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
					: (100 - progresses[i]) / speeds[i] + 1);
		}

		List<Integer> list = new ArrayList<Integer>();
		int prevFunc = queue.poll();
		int numOfFuncs = 1;
		while (!queue.isEmpty()) {
			int curFunc = queue.poll();
			if (prevFunc >= curFunc) {
				numOfFuncs++;
			} else {
				list.add(numOfFuncs);
				numOfFuncs = 1;
				prevFunc = curFunc;
			}
		}
		list.add(numOfFuncs);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;

	}

}
