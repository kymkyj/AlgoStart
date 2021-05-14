package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class proPrinter_sol {
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        // 9,1,1,1,1,1
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); // 우선순위 큐 (역순)
        for (int i : priorities) {
            queue.offer(i);
        }
        // for문을 한바퀴 다돌고나면 9 1 1 1 1 1 -> 1 1 만남음
        // queue가 비어있지 않아서 for문이 한바퀴 더돔
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // priorities : 1,1,9,1,1,1
                // queue : 9,1,1,1,1,1
                if (priorities[i] == queue.peek()) {
                    // 한바퀴 더돈 for문에서 0 = 0 만족
                    if (location == i) {
                        return answer; // answer : 5
                    }
                    answer++;
                    queue.poll();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] p = {1,1,9,1,1,1};
        int loc = 0;
        System.out.println(solution(p, loc));
    }
}
