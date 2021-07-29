package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bojStartLink_sol {
    static int F, S, G, U, D;
    static Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] dist = new int[10000001];
        Set<Integer> check = new HashSet<>();

        Q.add(S);
        dist[S] = 0;
        check.add(S);

        while (!Q.isEmpty()) {
            int now = Q.poll();
            if (now == G) {
                System.out.println(dist[now]);
                return;
            }

            //위로올라가는경우우
            if (now + U <= F && !check.contains(now + U)) {
                dist[now + U] = dist[now] + 1;
                check.add(now + U);
                Q.add(now + U);
            }

            //아래로내려가는경
            if (now - D > 0 && !check.contains(now - D)) {
                dist[now - D] = dist[now] + 1;
                check.add(now - D);
                Q.add(now - D);
            }
        }

        System.out.println("use the stairs");
    }
}
