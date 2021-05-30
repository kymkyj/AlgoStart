package study.programmers.level2;

import java.util.Arrays;

public class prg12941 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(solution.solution(A, B));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            for (int i=0; i<A.length; i++) {
                answer += A[i]*B[B.length-i-1];
            }
            return answer;
        }
    }
}
