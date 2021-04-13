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

			//skill ���ڿ� �ʱ�ȭ
			List<String> skilTreesList = new ArrayList<String>();
			for (char ski : skillTree.toCharArray()) {
				skilTreesList.add(String.valueOf(ski));
			}

			//skill_trees ���ڿ� �ʱ�ȭ
			for (char ski : skill.toCharArray()) {
				int addIndex = skilTreesList.indexOf(String.valueOf(ski)) + 1;
				indexList.add(addIndex);
			}

			//skill_trees�� ��� ���� skill�� ���
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

			//ù��° skill_trees�ȿ� skill�� ù��°�� ���� ��� ����ó��
			if (indexList.get(0) == 0)
				continue;

			//�ϳ��� ��ų�� �ִ� skill_tress�� �ƴϸ鼭 �������� ù ��ų�� �ִ� ��� ����ó��
			if (skillTree.length() != 1) {
				if (indexList.get(0) == skillTree.length())
					continue;
			}

			//skill_tress index �˻� �� �������� -1�� ��쿡 ���� ����
			for (int i = indexList.size() - 1; i > 0; i--) {
				if (indexList.get(i) == 0) {
					indexList.remove(i);
				} else {
					break;
				}
			}

			//���� �������� index�� ������ �ִ� �� �˻�
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
