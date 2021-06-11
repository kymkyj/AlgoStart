package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HideSeek {

	static int N;
	static int K;
	static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputNumbers = br.readLine().split(" ");
		N = Integer.valueOf(inputNumbers[0]);
		K = Integer.valueOf(inputNumbers[1]);
		 int[] Min = new int[100005];
		 //배열의 값을 모두 -1로 초기화
		 //미방문
	     Arrays.fill(Min, -1); 

		bw.write(String.valueOf(bfs(N, K, Min)));

		br.close();
		bw.flush();
		bw.close();

	}

	  public static int bfs(int N, int K, int[] Min) {
	        int nextN = N;
	        int[] status = new int[3];
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        q.add(nextN);
	        //N과 K가 같을 경우 0을 리턴
	        Min[nextN] = 0;
	 
	        //다음과 같이 처리하면 N과 K가 같을 경우도 함께 처리됨
	        while (!q.isEmpty() && nextN != K) {
	 
	            nextN = q.poll();
	            //다음에 이동할 좌표들
	            status[0] = nextN - 1;     //뒤로 한칸 4
	            status[1] = nextN + 1;    //앞으로 한칸 6
	            status[2] = nextN * 2;    //순간이동 10
	 
	            for (int i = 0; i < 3; i++) {
	                //배열을 벗어나지 않았는지 확인
	                if (status[i] >= 0 && status[i] <= 100000) {
	                	
	                    //이전에 방문했는지 확인
	                    if (Min[status[i]] == -1) {
	                        //처음 간 곳이라면 큐에 넣고 상태를 전 위치값 +1 을 해준다.
	                    	//선입선출이므로 해당 위치에 먼저 도착한놈이 무조건 빠르거나 같다.
	                        q.add(status[i]);
	                        //이동한 위치의 이전 위치의 값을 저장
	                        Min[status[i]] = Min[nextN] + 1;
	 
	                    }
	                }
	            }
	        }
	        //각 위치에 도달하는 최소값 저장
	        for(int mins: Min)
	        System.out.print(mins+" ");
	        
	        return Min[K];
	    }

}
