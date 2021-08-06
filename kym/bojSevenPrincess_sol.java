package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 백준 소문난 칠공주
/*
    문제분석 : 이다솜파 vs 임도연파
    1. 7명으로 구성되어야 한다.
    2. 가로나 세로로 인접해 있어야 한다.
    3. 이다솜파의 학생들로만 구성되지 않아도 되지만 적어도 4명이상은 이다솜파여야 한다.
    4. 모든 경우의 수를 구한다.
    5. S 이다솜파, Y 임도연파

    입력 값                출력 값
    YYYYY                   2
    SYSYS
    YYYYY
    YSYYS
    YYYYY
 */
// 모든 경우의 수이기때문에 DFS로 탐색해야 할것 같다.
public class bojSevenPrincess_sol {
    static char map[][] = new char[5][5];
    static int result;
    static int sel[] = new int [7];
    static void comb(int idx ,int L, int Y) {
        if(Y>3)
            return;
        if(L == 7) {
            if(check()) {
                result++;
            }
            return;
        }
        if(idx == 25)
            return;

        sel[L] = idx;
        int isY = map[idx/5][idx%5] == 'Y'? 1 : 0;
        comb(idx+1,L+1,Y + isY);
        comb(idx+1, L, Y);


    }
    static boolean check() {
        //뭐든 요소가 연결되어있는지 확인
        boolean [] visit = new boolean [7];
        visit[0] =true;
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(0);
        int cnt = 1;
        while(!que.isEmpty()) {
            int i = que.poll();
            for(int j = 0 ; j < 7 ; j++) {
                if(i==j || visit[j])
                    continue;
                if(sel[i] % 5 == 0) // 가장 왼쪽 벽일때
                    if(sel[i] - 1 == sel[j])
                        continue;
                if(sel[i] % 5 == 4) //가장 오른쪽 벽일때
                    if(sel[i] + 1 == sel[j])
                        continue;
                if(sel[i] - 1 == sel[j] || sel[i] + 1 == sel[j] || sel[i]+5 == sel[j] || sel[i] - 5 == sel[j]) {
                    que.offer(j);
                    visit[j] = true;
                    cnt++;
                }
            }
        }
        if(cnt != 7) //연결이 하나라도 안되어있으면
            return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        comb(0,0,0);
        System.out.println(result);

    }
}
