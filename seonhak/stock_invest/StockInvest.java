package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 주식투자
 * @author ji
 *
 */
public class StockInvest {

	static int _companyCnt = 3;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCase; t++) {

			int day = Integer.parseInt(br.readLine());
			int[][] stockPrices = new int[day][_companyCnt];

			// 데이터 초기화
			for (int i = 0; i < day; i++) {
				String[] stockPricesStr = br.readLine().split(" ");
				for (int j = 0; j < _companyCnt; j++)
					stockPrices[i][j] = Integer.parseInt(stockPricesStr[j]);
			}

			int result = 0;
			for (int dI = 0; dI < day; dI++) {
				// 각 날짜 별 최대값
				int max = 0;
				for (int cI = 0; cI < _companyCnt; cI++) {
					if (max < stockPrices[dI][cI])
						max = stockPrices[dI][cI];
				}
				result += max;
			}

			bw.write(String.valueOf(result) + "\n");

		}

		br.close();
		bw.flush();
		bw.close();
	}

}
