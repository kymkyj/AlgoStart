package study.baekjoon;boj9465

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20438 {
    static int N, K, Q, M, S, E;
    static int sum;
    static boolean[] sleep, check;
    public static void main(String[] args) throws IOException {
        //[백준] 출석체크
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //10 1 3 1
        //7
        //3 5 7
        //3 12
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //학생의 수
        K = Integer.parseInt(st.nextToken()); //졸고있는 학
        Q = Integer.parseInt(st.nextToken()); //출석코드 보낼 학생의 수
        M = Integer.parseInt(st.nextToken()); //주어질 구간

        int[] dp = new int[N+3];

        sleep = new boolean[5005];
        check = new boolean[5005];

        //구간 합 저장
        for (int i=3; i<N+2; i++) {
            dp[i] = i;
        }

        //졸고있는 학생
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            if (!st.hasMoreTokens()) break;
            int x = Integer.parseInt(st.nextToken());
            sleep[x] = true;
        }

        //출석코드를 보낼 학생
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<Q; i++) {
            if (!st.hasMoreTokens()) break;
            //3 5 7
            int y = Integer.parseInt(st.nextToken());
            if(sleep[y]) continue;

            sum = y;
            while (y <= N+2) {
                if (sleep[y]) {
                    y += sum;
                    continue;
                }
                check[y] = true;
                y += sum;
            }
        }

        for (int i=3; i<=N+2; i++) {
            int a;
            if (!check[i]) {
                a = 1;
            } else {
                a = 0;
            }
            dp[i] = dp[i-1] + a;
        }

        //구간의 범위
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            System.out.println(dp[E] - dp[S-1]);
        }
    }
}
