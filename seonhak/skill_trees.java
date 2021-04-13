package com.ji.programers;

import java.util.ArrayList;
import java.util.List;

public class Solution_49993 {
	
	public static void main(String[] args) {
		
//		"CBD" ["CAD"] 0
//		"CBD" ["AEF", "ZJW"] 2
//		"REA" ["REA", "POA"] 1
//		"CBDK" ["CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"] 4
//		"BDC" ["AAAABACA"] 0
//		"CBD" ["C", "D", "CB", "BDA"] 2
		
		String skill = "CBD";
		String[] skill_trees = { "AEF", "ZJW" };
//		String[] skill_trees = { "OTCADBF" };
//
		int result = solution(skill, skill_trees);
		System.out.println(result);
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String skillTree : skill_trees) {

			List<Integer> indexList = new ArrayList<Integer>();

			//skill 문자열 초기화
			List<String> skilTreesList = new ArrayList<String>();
			for (char ski : skillTree.toCharArray()) {
				skilTreesList.add(String.valueOf(ski));
			}

			//skill_trees 문자열 초기화
			for (char ski : skill.toCharArray()) {
				int addIndex = skilTreesList.indexOf(String.valueOf(ski)) + 1;
				indexList.add(addIndex);
			}

			//skill_trees가 모든 없는 skill인 경우
			boolean isAllZero = true;
			for (int i = 0; i < indexList.size(); i++) {
				if (!indexList.get(i).equals(0)) {
					isAllZero = false;
					break;
				}
			}

			if (isAllZero) {
				answer++;
				continue;
			}

			//첫번째 skill_trees안에 skill의 첫번째가 없는 경우 예외처리
			if (indexList.get(0) == 0)
				continue;

			//하나의 스킬만 있는 skill_tress가 아니면서 마지막에 첫 스킬이 있는 경우 예외처리
			if (skillTree.length() != 1) {
				if (indexList.get(0) == skillTree.length())
					continue;
			}

			//skill_tress index 검사 시 마지막에 -1인 경우에 대한 제거
			for (int i = indexList.size() - 1; i > 0; i--) {
				if (indexList.get(i) == 0) {
					indexList.remove(i);
				} else {
					break;
				}
			}

			//오름 차순으로 index를 가지고 있는 지 검사
			boolean isOrderBy = true;
			for (int i = 0; i < indexList.size() - 1; i++) {
				if (indexList.get(i + 1) - indexList.get(i) < 0) {
					isOrderBy = false;
					break;
				}
			}

			if (isOrderBy)
				answer++;

		}

		return answer;
	}

}
