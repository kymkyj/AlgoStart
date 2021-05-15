package study.programmers.level2;

public class prg12945 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        System.out.println(solution.solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;
            int num1 = 1;
            int num2 = 1;
            if(n == 1 || n == 2) {
                return 1;
            } else {
                for (int i=3; i<=n; i++) {
                    answer = (num1+num2)%1234567;
                    num1 = num2;
                    num2 = answer;
                }
            }
            //재귀로 풀면 시간초과 난다
            /*
            int divide = 1234567;
            int fibo;
            if(n == 0) {
                fibo = 0;
            } else if (n == 1) {
                fibo = 1;
            } else if (n == 2) {
                fibo = 1;
            } else {
                fibo = solution(n-2) + solution(n-1);
            }
            answer = fibo%divide;
            */
            return answer;
        }
    }
}
