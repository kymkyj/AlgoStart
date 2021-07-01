package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM
//  5
//  3 1 4 3 2       32
public class boj11399 {
    public static int solution(int n, int [] second){
        int answer = 0;
        int [] arr = new int[n];
        Arrays.sort(second);
        arr[0] = second[0];
        for(int i=1; i<n; i++){
            int sum = 0;
            sum += second[i] + arr[i-1];
            arr[i] = sum;
        }
        for(int k : arr) answer += k;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] second = new int[n];
        for(int i=0; i<n; i++){
            second[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, second));
    }
}
