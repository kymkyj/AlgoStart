package com.ji.beakjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 주유소
 * @author ji
 *
 */
public class GasStation {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cityCount = Integer.valueOf(br.readLine());
		String[] pathLengthStr = br.readLine().split(" ");
		String[] stationPriceStr =  br.readLine().split(" ");
		
		//도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다. 
		//입력값 조건에 의해서 long으로 자료형을 해줘야지만 통과가 됨!!!
		long[] pathLength = new long[cityCount -1];
		long[] stationPrices= new long[cityCount];
		
		for(int i=0; i<pathLengthStr.length ;i++)
			pathLength[i] = Integer.parseInt(pathLengthStr[i]);
		for(int j=0; j<stationPriceStr.length; j++)
			stationPrices[j] = Integer.parseInt(stationPriceStr[j]);
		
		long result = 0;
		long minStation =stationPrices[0];
		
		//내림 차순일 경우에만 주유!!!
		for(int i=0; i < cityCount-1; i++) {
			//오름차순일 경우 예외
			if(stationPrices[i] < minStation) 
				minStation = stationPrices[i];
			
			//오름차순일 경우 이전 주유소 가격으로 바꿔서 계산
			// 8, 9, 5, 4, 2, 7, 1  -> 8, 8, 5, 4, 2, 2, 1
			result += minStation*pathLength[i];
		}
		
		bw.write(String.valueOf(result));
		
		bw.flush();
		bw.close();
		br.close();
	}

}
