package com.ji.study;

public class TargetNumber {
	
	
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;

		solution(numbers, target);
		System.out.println("결과 : "+solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        // DFS를 구성할때 numbers[0], -numbers[0]은 +식 -식을 넣는 경우의 간선을 의미함
        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);
        
        return answer;
    }
    
    public static int dfs(int[] numbers, int target, int sum, int i) {
        
        if(i == numbers.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int result = 0;
        //각 노드의 숫자들을 재귀적으로 더하거나 빼면서 계산함
        result += dfs(numbers, target, sum+numbers[i], i+1);
        result += dfs(numbers, target, sum-numbers[i], i+1);
        return result;
    }

}
