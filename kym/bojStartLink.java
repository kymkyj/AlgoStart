package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트 링크
/*
    F, S, G, U, D
    스타트링크가 있는 건물의 총 층수 : F
    스타트링크가 있는 층 : G
    강호가 있는 층 : S
    엘레베이터가 위로 가는 버튼 : U
    엘레베이터가 아래로 가는 버튼 : D
 */
// 10 1 10 2 1 -> 6
public class bojStartLink {
    static int F, S, G, U, D;
    static Queue<Integer> Q = new LinkedList<>();
    static int answer = 0;
    public void BFS(int F, int S, int G, int U, int D ){
        int click = 0; // 버튼을 클릭한 횟수
        Q.add(S); // 처음에 1들어감
        while(!Q.isEmpty()){
            click++;
            int len = Q.size();
            for(int i=0; i<len; i++){
                int floor = Q.poll(); // 현재 위치
                if(floor == G){
                    answer = click;
                    return;
                }else{
                    Q.add(floor + U);
                    Q.add(floor - D);
                    click++;
                }
            }
        }
        answer = click;
    }

    public static void main(String[] args) throws IOException {
        bojStartLink T = new bojStartLink();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        T.BFS(F, S, G, U, D);
        System.out.println(answer);
    }

}
