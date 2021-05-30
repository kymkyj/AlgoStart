package study.programmers.level2;

public class prg42584 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 2, 3}; // [4, 3, 1, 1, 0]
        int[] result = solution.solution(prices);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            int second = 0;

            for (int i=0; i<prices.length; i++) {
                for (int j=i+1; j<prices.length; j++) {
                    if (prices[i] <= prices[j]) {
                        second++;
                    } else if (prices[i] > prices[j]) {
                        second++;
                        break;
                    }
                }
                answer[i] = second;
                second = 0;
            }
            return answer;
        }
    }

}

