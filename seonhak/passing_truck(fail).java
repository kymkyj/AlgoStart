package com.ji.programers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_42583 {

//   solution(2, 10, new int[] {7,4,5,6}); //8
//   solution(3, 10, new int[] {7,4,5,6}); //11
//   solution(2, 10, new int[] {4,5,4,6}); //6
//   solution(2, 10, new int[] {7,4,5,4,6}); //8
//   solution(100, 100, new int[] {10}); //101
//   solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}); //110
//   solution(1, 2, new int[] {1,1,1}); //4
//   solution(1, 1, new int[] {1,1,1}); //4
//   solution(4, 2, new int[] {1,1,1,1}); //10
//   solution(3, 3, new int[] {1,1,1}); //6
//   solution(3, 1, new int[] {1,1,1}); //10
//   solution(3, 1, new int[] {1,1,1,1,1}); //16
//   solution(5, 5, new int[] {1,1,1,1,1,2,2}); //14
//   solution(7, 7, new int[] {1,1,1,1,1,3,3}); //18
//   solution(5, 5, new int[] {1,1,1,1,1,2,2,2,2}); //19
//   solution(5, 5, new int[] {2,2,2,2,1,1,1,1,1}); //19

	public static void main(String[] args) {

		int bridgeLength = 4;
		int weight = 2;
		int[] truckWeight = { 1, 1, 1, 1 };
		int result = solution(bridgeLength, weight, truckWeight);

		System.out.println(result);

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
//
		int shiftCount = 0;

		Queue<Integer> passingTrucks = new LinkedList<Integer>();
		Queue<Integer> waitingTrucks = new LinkedList<Integer>();
		for (int i = 0; i < bridge_length; i++) {
			passingTrucks.add(0);
		}

		for (int truck : truck_weights) {
			waitingTrucks.add(truck);
		}

		boolean result = true;

		while (result) {

			if (passingTrucks.size() > 0) {

				// 다리 하중에 대한 계산을 잘 못 생각함 !!!
				// 다리 하중 - 올라간 트럭 무게 값을 생각해 !!!
				int passingTrucksWeightsSum = 0;
				for (Integer crsTruck : passingTrucks) {
					passingTrucksWeightsSum += crsTruck;
				}

				boolean isPossibleMove = false;
				if (waitingTrucks.size() > 0) {

					passingTrucks.poll();

					if (passingTrucksWeightsSum + waitingTrucks.peek() <= weight) {
						isPossibleMove = true;
					}

					if (isPossibleMove) {

						passingTrucks.add(waitingTrucks.poll());
						shiftCount++;
						continue;
					} else {

						passingTrucksWeightsSum = 0;
						for (Integer crsTruck : passingTrucks) {
							passingTrucksWeightsSum += crsTruck;
						}

						passingTrucks.add(0);

						shiftCount++;
						continue;
					}
				} else {
					passingTrucks.poll();
					shiftCount++;
					continue;
				}

			} else {
				break;
			}

		}

		return shiftCount;
//		
	}

}
