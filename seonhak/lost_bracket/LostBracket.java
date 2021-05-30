package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LostBracket {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String calcuFormula = String.valueOf(br.readLine());
		int result = Integer.MAX_VALUE;

		// 마이너스 기준으로 순자 분리
		for (String formula : calcuFormula.split("-")) {
			int temp = 0;

			// 플러스가 포함된 수식의 경우 계산하여 temp에 저장
			for (String plusFormula : formula.split("\\+"))
				temp += Integer.parseInt(plusFormula);

			// 첫번째 숫자로 초기화
			// Q) Integer.MAX_VALUE 로 초기 값을 해야하는 이유????
			// 초기 값을 0으로 하면 temp값과 일치하므로 재귀적으로 돌게됨
			result = (result == Integer.MAX_VALUE) ? temp : result - temp;
		}

		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();
	}

}
