package boj;

// 백준 토너먼트
/*
    문제 정리
    1. 김지민과 임한수가 몇라운드에서 대결하는지 구하기
    2. 지민과 한수는 서로 대결하기 전까지는 무조건 이긴다고 가정
    3. 인접한 번호끼리 대결하며, 다음라운드에 올라가면 다시 순차적으로 번호가 배정된다.
    4. 참가자 수가 홀수이면 마지막 번호는 무조건 다음라운드 진출
    5. 한명만 남을때까지 대결 계속한다.
    6. 출력값에는 지민과 한수가 대결하는 라운드 출력 없다면 -1
 */
// 입력 값 : 참가자수, 지민 1라운드 번호, 한수 1라운드 번호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16 1 2 -> 1
public class bojTournament {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int han = Integer.parseInt(st.nextToken());
        int round = 0;

        while(kim != han){
            kim = kim/2 + kim%2;
            han = han/2 + han%2;
            round++;
        }
        System.out.println(round);
    }
}
