package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 프로그래머스 기능개발
public class proSkillDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            q.add((100-progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1);
        } // 큐에 7, 3, 9 순으로 들어감

        List<Integer> result = new ArrayList<Integer>();
        int prev = q.poll();
        int dayCount = 1;
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(prev >= curr) {
                dayCount++;
            }else {
                result.add(dayCount);
                dayCount = 1;
                prev = curr;
            }
        }
        result.add(dayCount);
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] progresses = {93,30,55};
        int [] speeds = {1,30,5};
        proSkillDevelop T = new proSkillDevelop();
        for(int i : T.solution(progresses, speeds)){
            System.out.print(i + " ");
        }
    }
}
