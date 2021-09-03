package study.programmers.level2;

public class prg43165 {
    static int answer = 0;
    public static void main(String[] args) {
        //[프로그래머스] 타겟넘버
        Solution solution = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution.solution(numbers, target));

    }
    static class Solution {
        public int solution(int[] numbers, int target) {
            answer = DFS(numbers, target, 0, 0);
            return answer;
        }
    }

    public static int DFS(int[] numbers, int target, int index, int sum) {
        /*
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        sum +=numbers[index];
        DFS(numbers, target, index+1, sum);
        sum -= numbers[index];
        sum += (-1 * numbers[index]);
        DFS(numbers, target, index+1, sum);
        */

        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        } else {
            return DFS(numbers, target, index+1, sum + numbers[index]) + DFS(numbers, target, index+1, sum - numbers[index]);
        }

    }
}
