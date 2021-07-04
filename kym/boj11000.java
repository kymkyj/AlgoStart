package boj;

// 강의실 배정
/*
    3      ->   2
    1 3
    2 4
    3 5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SooUp{ // 시작시간, 종료시간 담아둔 클래스
    public int start, end;
    SooUp(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class boj11000 {
    public static void solution(int n, SooUp [] sooup){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 왼쪽과 오른쪽의 시작시간이 같다면 종료시간 기준 정렬
        // 그렇지 않으면 시작시간 기준 정렬
        Arrays.sort(sooup, (lt, rt) -> lt.start == rt.start ? lt.end - rt.end : lt.start - rt.start);
        pq.offer(sooup[0].end); // 처음 종료시간 3
        for(int i=1; i<n; i++){
            if(pq.peek() <= sooup[i].start){ // end : 3, start 1, 2, 3
                pq.poll();
            }
            pq.offer(sooup[i].end);
        }
        System.out.println(pq.size());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SooUp [] sooup = new SooUp[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sooup[i] = new SooUp(s, e);
        }
        solution(n, sooup);
    }
}
