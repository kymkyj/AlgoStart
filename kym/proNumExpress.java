package programmers;
// 프로그래머스 숫자의 표현
public class proNumExpress {
    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=i; j<=n; j++){
                sum += j;
                if(sum > n) break;
                else if(sum == n){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
}
