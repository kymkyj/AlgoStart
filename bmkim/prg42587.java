package study.programmers.level2;

import java.util.*;

public class prg42587 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.print(solution.solution(priorities, location));
    }

    //이것으론 답이 나오지 않는다..
    /*
        static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 1;
            //위치도 저장해야 할 것 같다
            Queue<Integer> locationQueue = new LinkedList<>();
            Queue<Integer> queue = new LinkedList<>();

            for (int i=0; i<priorities.length; i++) {
                queue.offer(priorities[i]);
                locationQueue.offer(i);
            }
            int count = 0;
            while (!queue.isEmpty()) {
                int priority = queue.poll();
                int save = locationQueue.poll();
                for (int i=0; i<priorities.length; i++) {
                    if (priority < priorities[i]) {
                        count++;

                        if (save == location) {
                            answer = count;
                            System.out.print("answer : " + answer);
                            break;
                        }
                    } else {
                        queue.offer(priority);
                        locationQueue.offer(save);
                    }
                }
            }
            return answer;
        }
    }
    */
    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 1;
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : priorities) {
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    if (priorities[i] == queue.peek()) {
                        //내가 찾고자 하는 location까지 반복
                        if (location == i) {
                            return answer;
                        }
                        answer++;
                        queue.poll();
                    }
                }
            }
            return answer;
        }
    }
}
