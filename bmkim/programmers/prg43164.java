package study.programmers.level3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class prg43164 {
    static boolean[] visited;
    static ArrayList<String> answers;
    public static void main(String[] args) {
        //[프로그래머스] 여행경로
        // String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        Solution solution = new Solution();
        solution.solution(tickets);
    }

    static class Solution {
        public String[] solution(String[][] tickets) {
            String[] answer = {};
            answers = new ArrayList<>();
            visited = new boolean[tickets.length];
            int count = 0;

            DFS(count, "ICN", "ICN", tickets);
            //알파벳 순으로 앞섭니다
            Collections.sort(answers);
            answer = answers.get(0).split(" ");

            for (int i=0; i<answer.length; i++) {
                System.out.print(answer[i] + " ");
            }
            return answer;
        }
    }
    public static void DFS(int count, String current, String answer, String[][] tickets) {
        if (count == tickets.length) {
            answers.add(answer);
            System.out.println(answers);
            return;
        }
        for (int i=0; i<tickets.length; i++) {
            ////항상 "ICN" 공항에서 출발
            if (tickets[i][0].equals(current) && !visited[i]) {
                visited[i] = true;
                //도착 공항을 현재 위치에 넣어주고, answer 에 도착 공항을 추가한다
                DFS(count+1, tickets[i][1], answer+ " " +tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
