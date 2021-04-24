package programmers;

// 타겟 넘버
public class proTarget {
    public static void main(String[] args) {
        int [] num = {1,1,1,1,1};
        int targetNum = 3;
        proTarget p = new proTarget();
        System.out.println(p.solution(num, targetNum));
    }
    public int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }

    public int DFS(int[] numbers, int target, int node, int num) {
        if(node == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return DFS(numbers, target, node + 1, num + numbers[node]) + DFS(numbers, target, node + 1, num - numbers[node]);
        }
    }
}
