package com.ji.beakjoon.dfs;

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
 * 백준6603 - 로또
 * @author seonhak
 * @date 2021. 9. 24.
 */
public class Lotto {

	public static List<String> output = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String readLine = br.readLine();
			if (readLine.equals("0")) 
				break;
			
			int[] arr = Arrays.stream(readLine.split(" ")).mapToInt(Integer::parseInt).toArray(); 
			int[] perArr = new int[arr[0]];
			boolean[] visited = new boolean[arr[0]];
			for (int i = 1; i < arr.length; i++)
				perArr[i - 1] = arr[i];
			
			// 순열을 이용한 경우의 수 -> 순열로 풀었을경우 swap 하는 과정에서 메모리 초과 발생!!!
//			per1(perArr, 0, arr[0], 6);
			
			combination(perArr, visited, 0, 0, 6, bw);

//			for(String res:output)
//				bw.write(String.valueOf(res)+"\n");
//			
//			output = new ArrayList<>();
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	// 조합으로 풀어야 메모리 초과 안남
	public static void combination(int[] arr, boolean[] visited, int idx, int n, int r, 	BufferedWriter bw ) throws IOException {
        if (n == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    bw.write(String.valueOf(arr[i])+" ");
                }
            }
            bw.write("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(arr, visited, i, n + 1, r, bw);
            visited[i] = false;
        }
    }

	// 순열을 이용한 경우의 수 -> 순열로 풀었을경우 swap 하는 과정에서 메모리 초과 발생!!!
	static void per1(int[] arr, int depth, int n, int r) {
		if (depth == r) {

			List<Integer> numList = new ArrayList<>();
			for (int i = 0; i < r; i++) 
				numList.add(arr[i]);
			
			Collections.sort(numList);
			
			String numStr = "";
			for (int i = 0; i <numList.size()-1; i++)
				numStr += numList.get(i)+" ";
			numStr += numList.get(numList.size()-1);

			if(!output.contains(numStr))
				output.add(numStr);

			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 Swap 함수
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
