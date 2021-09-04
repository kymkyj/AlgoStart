package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StringRepeat {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			StringTokenizer stk=new StringTokenizer(br.readLine()," ");//split() 속도가 더 빠름!!!
			Integer repeat = Integer.parseInt(stk.nextToken());
			
			StringBuilder fullText = new StringBuilder();
			for(char ch : stk.nextToken().toCharArray()) 
				for (int j = 0; j < repeat; j++)
					fullText.append(ch);
			
			bw.write(fullText.toString()+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
