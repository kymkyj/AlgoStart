package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class IronBar {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cutIronCount = 0;

		String bracketStr = String.valueOf(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < bracketStr.length(); i++) {
			// 열린 괄호 일 경우
			if (bracketStr.substring(i, i + 1).equals("(")) {
				stack.push(i); // '('경우만 저장
			} else { // 닫힌 괄호 일 경우
				
				// stack의 마지막 저장 index가 바로 전 index와 같으면 레이저('()')를 의미
				if (stack.peek() == i - 1) {
					//스택 안에는 쇠파이프 시작점 index가 저장되므로 
					//레이저에 의해서 잘려진 쇠파이프와 동일함
					cutIronCount += stack.size();
				} else {
					// ')'')' 일경우는 단순 증가
					cutIronCount++;
				}
				stack.pop();
			}
		}

		// 스택 사용안하는 풀이
//		for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
// 
//            if (c == '(') { // 열린 괄호면 open에 1을 더해 줌.
//                open++;
//            } else { // 닫힌 괄호일 경우,
//                open--; // 일단 open에 1을 빼 줌.
// 
//                if (input.charAt(i - 1) == '(') { // 그 전 괄호가 열린 괄호면 레이저를 의미.
//                    ans += open; // open의 값만큼 더해 줌.
//                } else { // 그 전 괄호가 닫힌 괄호면 레이저가 아님.
//                    ans++; // 단순히 1을 더해 줌.
//                }
//            }
//        }

		bw.write(String.valueOf(cutIronCount));

		br.close();
		bw.flush();
		bw.close();
	}

}
