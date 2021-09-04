package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BalancedWorld {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {

			String readLine = br.readLine();
			if (readLine.substring(0).equals("."))
				break;


			Stack<Character> stack = new Stack<Character>();
			boolean result = true;
			for (char str  : readLine.toCharArray()) {

				if (str == '(' || str == '[')
					stack.push(str);
				else if (str ==')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						result = false;
						break;
					}
				} else if (str ==']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						result = false;
						break;
					}

				}

			}

			if (!stack.isEmpty())
				result = false;

			if (result) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}

		}

		br.close();
		bw.flush();
		bw.close();

	}

}
