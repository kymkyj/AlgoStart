package programmers;

import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 최솟값 만들기
public class proMinMake {
    public static int solution(int []A, int []B)
    {
        int answer = 0; // 누적합계
        Arrays.sort(A);
        Integer arrB [] = Arrays.stream(B).boxed().toArray(Integer[]::new); // Integer 배열로 변환
        Arrays.sort(arrB, Collections.reverseOrder());
        for(int i=0; i<A.length; i++){
            int tmp = A[i] * arrB[i];
            answer += tmp;
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] a = {1,4,2};
        int [] b = {5,4,4};
        System.out.println(solution(a, b));
    }
}
