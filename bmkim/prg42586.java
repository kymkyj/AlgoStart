package study.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class prg42586 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        solution.solution(progresses, speeds);
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int distributionDate = 1; //배포 날짜
            Queue<Integer> queue = new LinkedList<>();
            for (int i=0; i<progresses.length; i++) {
                queue.add(
                        (100 - progresses[i])%speeds[i] == 0 ?
                                (100-progresses[i])/speeds[i] :
                                (100-progresses[i])/speeds[i] + 1
                );
            }
            List<Integer> distributionList = new ArrayList();
            int prev = queue.poll();
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (prev >= current) {
                    distributionDate++;
                } else {
                    distributionList.add(distributionDate);
                    distributionDate = 1;
                    prev = current;
                }
            }
            distributionList.add(distributionDate);

            int[] answer = new int[distributionList.size()];
            for (int i=0; i<distributionList.size(); i++) {
                answer[i] = distributionList.get(i);
                System.out.print(answer[i] + " ");
            }
            return answer;
        }
    }
}
