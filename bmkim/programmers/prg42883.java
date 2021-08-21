package study.programmers.level2;

import java.util.ArrayList;

public class prg42883 {
    public static void main(String[] args) {
        //[프로그래머스] 큰 수 만들기
        String number = "4177252841";
        int k = 4;
        Solution solution = new Solution();
        System.out.println(solution.solution(number, k));
    }

    static class Solution {
        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder();
            int index = 0;
            int max = 0;
            for (int i=0; i<number.length() - k; i++) {
                max = 0;
                for (int j=index; j<=k+i; j++) {
                    if (max < number.charAt(j)-'0') {
                        max = number.charAt(j)-'0';
                        index = j+1;
                    }
                }
                answer.append(max);
            }
            return answer.toString();
        }
    }
}
