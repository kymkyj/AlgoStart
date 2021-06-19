package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Alphabet {

	/**
	 * 알파벳 찾기
	 * 
	 * @param args
	 * @throws IOException
	 */
	static int lowerCaseRangeSize = 122 - 97;
	static int lowerCaseStartIndex = 97;
	static int lowerCaseEndIndex = 122;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		
		int[] resultArr = new int[lowerCaseRangeSize+1];
		for (int j = lowerCaseStartIndex; j <= lowerCaseEndIndex; j++) {

			int alphabetCnt = 0;
			for (int i = 0; i < input.length(); i++) {

				if (input.charAt(i) == j) {
					alphabetCnt++;

					//연속 문자열 첫번째 인덱스만 저장
					if (alphabetCnt == 1)
						resultArr[j - lowerCaseStartIndex] = i;
				}

			}
			
			if (alphabetCnt == 0)
				resultArr[j - lowerCaseStartIndex] = -1;
			
		}

		for (int index : resultArr)
			bw.write(String.valueOf(index) + " ");

		br.close();
		bw.flush();
		bw.close();

	}

}
