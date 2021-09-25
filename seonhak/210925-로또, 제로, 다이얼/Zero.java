package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 백준10773 - 제로
 * @author seonhak
 * @date 2021. 9. 24.
 */
public class Zero {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numberCnt = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < numberCnt; i++) {
			Integer num = Integer.parseInt(br.readLine());
			if (num.equals(0)) {
				stack.pop();
			} else {
				stack.add(num);
			}
		}
		
		int sum = 0;
//		while(stack.size() > 0 ) sum += stack.pop();
		// functional method
		sum = stack.stream().reduce(0, (a,b)->a+b);
		
		bw.write(String.valueOf(sum));
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	

}
