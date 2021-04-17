package study.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class prg42583 {
    public static void main(String[] args) {
        //다리를 지난 트럭 = 대기트럭이 같으면 다 건넜다고 볼 수 있거나 대기와 대기와 다리를 건넌 차량이 없으면 다 건넜다고 볼 수 있다
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        Solution solution = new Solution();
        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int total = 0;

            Queue<Integer> bridgeToCross = new LinkedList<>();

            for (int truck : truck_weights) {
                while(true) {
                    if(bridgeToCross.isEmpty()) {
                        bridgeToCross.add(truck);
                        answer++;
                        total = total + truck;
                    } else if (bridgeToCross.size() == bridge_length) {
                        //건너야 할 다리는 bridge_length 만큼 트럭이 이용할 수 있다
                        total = total - bridgeToCross.poll();
                    } else {
                        //다리를 건넌 차량 + 다음 대기 차량 > weight
                        if (truck + total > weight) {
                            bridgeToCross.add(0);
                            answer++;
                        } else {
                            bridgeToCross.add(truck);
                            total = total + truck;
                            answer++;
                            break;
                        }
                    }
                }
            }
            return answer;
        }
    }
}


