package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준5622 - 다이얼
 * @author seonhak
 * @date 2021. 9. 24.
 */
public class Dial {
	
	static Character[][] alphabetInfo = {{},{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','Q','R','S'},{'T','U','V'},{'W','X','Y','Z'}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] alphabetStr = br.readLine().split("");
		
		int sum =0;
		for(String alphabet : alphabetStr) {
			
			for(int i=0; i<alphabetInfo.length; i++) {
				for(int j=0; j<alphabetInfo[i].length; j++) {
					
					if(alphabetInfo[i][j].equals(alphabet.charAt(0))) {
						sum+=i+2;
						break;
					}
					
				}
				
			}
			
		}
		
		bw.write(String.valueOf(sum));
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
