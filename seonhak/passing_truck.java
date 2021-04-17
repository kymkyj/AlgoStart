package com.ji.programers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_42584_Answer {

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

		int bridgeLength = 2;
		int weight = 10;
		int[] truckWeight = {7,4,5,4,6};
		int result = solution(bridgeLength, weight, truckWeight);

		System.out.println(result);

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		
		Queue<int[]> queue = new LinkedList<>();
        int time = 0, idx = 0;

        while (idx < truck_weights.length) {
        	//트럭이 머무는 시간에 도달 했을 경우
            if (!queue.isEmpty() && time == queue.peek()[1]) {
            	
                int[] truck = queue.poll(); //다리를 지남
                
                //트럭이 나가서 하중 증가
                weight += truck[0]; 
            }

            //남은 하중 보다 트럭 하중이 작으면
            if (weight >= truck_weights[idx]) {
            	//배열 {진입한 트럭의 무게, 도달시간}
                queue.add(new int[]{truck_weights[idx], time + bridge_length});
                //트럭이 올라가고 남은 하중 
                weight -= truck_weights[idx++];
            }

            time++;
        }

        return time + bridge_length;
		
	}

}
