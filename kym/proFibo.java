package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 프로그래머스 피보나치
public class proFibo {
    public static int solution(int n){
        if(n == 1 || n == 2) return 1; // @1
        int a = 1, b = 1, sum = 0; // @2
        for(int i=3; i<=n; i++) { // @3
            sum = a + b;
            sum %= 1234567;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
//        solution(n);
    }
}
