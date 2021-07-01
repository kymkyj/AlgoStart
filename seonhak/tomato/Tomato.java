package com.ji.beakjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 * @author ji
 *
 */
public class Tomato {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        int[] dy = { -1, 1, 0, 0 };//상하좌우위아래
        int[] dx = { 0, 0, -1, 1 };
        int M = sc.nextInt(), N = sc.nextInt();

        int[][] tomato = new int[N][M];
        int cnt = 0, days = 0;
        Queue<int[]> que = new LinkedList<>();

        //행렬값 초기화
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                tomato[n][m] = sc.nextInt();
                //시작 노드를 큐에 넣음
                if (tomato[n][m] == 1) {
                    que.add(new int[] { n, m });
                }else if (tomato[n][m] == 0) {
                	//익지 않은 토마토 개수 
                    cnt++;
                }
            }
        }

        //익지 않은 토마토 가 있고, 큐에 노드가 있으면
        while (cnt > 0 && !que.isEmpty()) {
            for (int s = que.size(); s > 0; s--) {
                int[] cur = que.poll();//익은 토마토 위치

                //상하좌우아래 검사
                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k]; //가로
                    int nx = cur[1] + dx[k]; //세로

                    //익은 토마토만 통과
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || tomato[ny][nx] != 0)
                        continue;
                               
                    cnt--;
                    tomato[ny][nx] = 1;
                    //익은 토마토 큐에 저장
                    que.add(new int[] { ny, nx });
                }
            }
            //날짜 증가
            days++;
        }
        
        String result = String.valueOf(cnt == 0 ? days : -1);
        bw.write(String.valueOf(result) + "\n");
        bw.flush();
		bw.close();
    }

}
