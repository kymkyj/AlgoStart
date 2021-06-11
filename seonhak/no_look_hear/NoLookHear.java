package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 듣보잡
 * @author ji
 *
 */
public class NoLookHear {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] noLookHearCountStr = br.readLine().split(" ");
		
		int noHearPersonCnt = Integer.valueOf(noLookHearCountStr[0]);
		int noLookPersonCnt = Integer.valueOf(noLookHearCountStr[1]);
		
		List<String> noHearNamesList = new ArrayList<String>();
		List<String> noLookHearList = new ArrayList<String>();
		
		for(int i=0; i<noHearPersonCnt; i++) 
			noHearNamesList.add(br.readLine());
		
		//정렬한 데이터가 검색 속도가 더 빠름
		//순차 접근시 O(n), 이진 트리 검색시 O(logN)
		Collections.sort(noHearNamesList);
		
		//이진 검색 트리 사용을 위한 List to Array
		String[] noHearNamesArr = new String[noHearNamesList.size()];
		noHearNamesArr = noHearNamesList.toArray(noHearNamesArr);
		
		for(int i=0; i<noLookPersonCnt; i++) {
			String name =br.readLine();
			if(Arrays.binarySearch(noHearNamesArr, name)>=0) //POINT!!!
				noLookHearList.add(name);
		}
		
		//문제에서 사전순 요구함
		Collections.sort(noLookHearList);
		bw.write(String.valueOf(noLookHearList.size())+"\n");
		
		for(String name:noLookHearList)
			bw.write(String.valueOf(name)+"\n");

		br.close();
		bw.flush();
		bw.close();
	}
}
