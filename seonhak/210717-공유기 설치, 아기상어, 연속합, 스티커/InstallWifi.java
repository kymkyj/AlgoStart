package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 설치 가능한 경우에 수
// 3개가 주어지면 좌표에서 설치 가능한 경우의 수
public class InstallWifi {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] info = br.readLine().split(" ");
		int homeCount = Integer.valueOf(info[0]);
		int wifiCount = Integer.valueOf(info[1]);
		
		int[] homePoints = new int[homeCount];
		for (int i = 0; i < homeCount; i++) {
			homePoints[i] = Integer.valueOf(br.readLine());
		}
		
		Arrays.sort(homePoints);
		int ans = 1;
		int start = 1;
		int end = homePoints[homeCount-1]-homePoints[0];//최대거리
		
		while(start <= end) {
			//이분 탐색
			int mid=(start+end)/2;
			//mid기준으로 범위안에 wifiCount 갯수 이상 설치가 가능한지
			// mid의 거리를 좁혀 가면서 검사
			if(check(homePoints, mid, wifiCount)) {
				//인접한 두 공유기 사이의 최대거리 저장
				ans = Math.max(ans, mid);
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();

	}

	private static boolean check(int[] homePoints, int dist, int wifiCount) {
		int cnt =1; 
		int last = homePoints[0]+dist; //첫 번쨰 집 + 거리(가운데 값)이 마지막
		for(int i=0; i<homePoints.length; i++) {
			//집의 위치가 중간 거리보다 크면 cnt 값 증가
			//다음 집의 위치가  last 거리보다 끄면 cnt 증가
			if(homePoints[i] >= last) {
				cnt++;
				last = homePoints[i]+dist;//마지막 값 + 거리
			}
		}
		return cnt >= wifiCount;
	}

}
