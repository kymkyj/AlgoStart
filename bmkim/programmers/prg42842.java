package study.programmers.level2;

public class prg42842 {
    public static void main(String[] args) {
        //[프로그래머스] 카펫
        Solution solution = new Solution();
        int brown = 10;
        int yellow = 2;
        int[] answers = solution.solution(brown, yellow);
        for (int i=0; i<answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int sum = brown + yellow;

            for (int i=1; i<=sum; i++) {
                int row = i; //세로
                int col = sum / row; //가로


                //카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다
                if (col - 2 * row - 2 == yellow && col >= row) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
            return answer;
        }
    }
}
