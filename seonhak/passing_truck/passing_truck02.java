package com.ji.programers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_42583 {

// 테스트 케이스
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

		int bridgeLength = 3;
		int weight = 10;
		int[] truckWeight = { 7,4,5,6 };
		int result = solution(bridgeLength, weight, truckWeight);

		System.out.println(result);

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		Queue<TruckVO> passingTrucks = new LinkedList<TruckVO>();

		int shiftCount = 0, idx = 0, time = 0;

		while (idx < truck_weights.length) {

			if (!passingTrucks.isEmpty() && time == passingTrucks.peek().getMoveCnt()) {

				// 다리를 지남
				TruckVO vo = passingTrucks.poll(); 

				// 트럭이 나가서 하중 증가
				weight += vo.getWeight();
			}

			// 남은 하중 보다 트럭 하중이 작으면
			if (weight >= truck_weights[idx]) {
				// 배열 {진입한 트럭의 무게, 도달시간}
				TruckVO vo = new TruckVO();
				vo.setWeight(truck_weights[idx]);
				vo.setMoveCnt(time + bridge_length);
				passingTrucks.add(vo);
				// 트럭이 올라가고 남은 하중
				weight -= truck_weights[idx++];
			}

			time++;
		}
		
		shiftCount = time + bridge_length;
		return shiftCount;
	}

}

class TruckVO {
	int weight;
	int moveCnt;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getMoveCnt() {
		return moveCnt;
	}

	public void setMoveCnt(int moveCnt) {
		this.moveCnt = moveCnt;
	}
}
