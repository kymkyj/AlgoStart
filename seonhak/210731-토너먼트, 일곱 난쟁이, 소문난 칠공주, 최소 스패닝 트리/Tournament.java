package com.ji.beakjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tournament {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] personInfos = br.readLine().split(" ");
		int N = Integer.parseInt(personInfos[0]);
		int kimNumber = Integer.parseInt(personInfos[1]);
		int imNumber = Integer.parseInt(personInfos[2]);

		int result = 0;
		//토너먼트기 때문에 2를 나눈 값 , 나머지 값이 부모 노드 값이 됨 
		//부모노드가 같은 번호 일때 루프 탈출
		while (kimNumber != imNumber) {
			kimNumber = kimNumber/2 + kimNumber%2;
			imNumber = imNumber/2 + imNumber%2;
			result++;
		}
		
		System.out.println(result);

	}

}
