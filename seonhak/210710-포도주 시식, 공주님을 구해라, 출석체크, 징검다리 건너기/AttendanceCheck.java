package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 출석체크
 * @author ji
 *
 */
public class AttendanceCheck {
	static int add;
	static boolean[] sleep, chk;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] studentInfo = br.readLine().split(" ");
		int N = Integer.valueOf(studentInfo[0]); //학생의 수
		int K = Integer.valueOf(studentInfo[1]); //졸고 있는 학생의 수 
		int Q = Integer.valueOf(studentInfo[2]); //출석 코드를 보낼 학생의 수
		int M = Integer.valueOf(studentInfo[3]); //주어질 구간의 수
		
		int[] dp = new int[N+3];
		for(int i=3; i<= N+2; i++) {
			dp[i] = i;
		}
		
		// 	(1 ≤ K, Q ≤ N ≤ 5,000, 1 ≤ M ≤ 50,000)
		sleep = new boolean[5005];
		chk = new boolean[5005];
		
		//졸고 있는 학생 초기화
		String[] sleepInfo = br.readLine().split(" ");
		for(int i=0; i < K; i++) {
			int sleepStudentNum = Integer.valueOf(sleepInfo[i]);
			sleep[sleepStudentNum] = true;
		}
		
		//출석 코드를 보낼 학생의 수 
		String[] qrInfo = br.readLine().split(" ");
		for(int i=0; i < Q; i++) {
			int qrStudentNum = Integer.valueOf(qrInfo[i]);
			if(sleep[qrStudentNum]) continue;//출석 코드는 받았으나 졸았을 경우 패스
			add = qrStudentNum; //출석 코드를 받은 학생 입장 번호
			while(qrStudentNum <= N+2) { 
				if(sleep[qrStudentNum]) {
					qrStudentNum += add;
					continue;
				}
				chk[qrStudentNum] = true;//출석 코드를 받을 학생 정보를 chk배열에 저장
				qrStudentNum += add;//배수인 학생!!
			}
		}
		
		for(int i=3; i<= N+2; i++) {
			int unAttend = (!chk[i])?1:0;//출석 되지 않은 학생 수 dp에 계산
			dp[i] = dp[i -1] + unAttend;
		}
		
		for(int i=0; i < M; i++) {
			String[] MInfo = br.readLine().split(" ");
			int s = Integer.parseInt(MInfo[0]);
			int e = Integer.parseInt(MInfo[1]);
			System.out.println(dp[e] - dp[s-1]); //구간에 해당하는 출석이 되지 않은 학생 수 출력
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
