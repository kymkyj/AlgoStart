package study.programmers.level2;

public class prg12924 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 15;
        System.out.println(solution.solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int i=1; i<=n; i++) {
                int sum = 0;
                for(int j=i; j<=n; j++) {
                    sum += j;

                    if(sum == n) {
                        answer++;
                        break;
                    } else if (sum > n) {
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
