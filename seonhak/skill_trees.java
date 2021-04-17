package com.ji.programers;

import java.util.ArrayList;
import java.util.List;

public class Solution_49993 {

	public static void main(String[] args) {

//		�׽�Ʈ ���̽�
//		"CBD" ["CAD"] 0
//		"CBD" ["AEF", "ZJW"] 2
//		"REA" ["REA", "POA"] 1
//		"CBDK" ["CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"] 4
//		"BDC" ["AAAABACA"] 0
//		"CBD" ["C", "D", "CB", "BDA"] 2

		String skill = "CBD";
		String[] skill_trees = { "AEF", "ZJW" };

		int result = solution(skill, skill_trees);
		System.out.println(result);
	}

	public static int solution(String skill, String[] skill_trees) {
		int skillTreeCnt = 0;

		for (String skillTree : skill_trees) {

			List<Integer> indexList = new ArrayList<Integer>();

			initSkillList(skill, skillTree, indexList);

			// skill_trees�� ��� ���� skill�� ���
			if (isWithoutSkill(indexList)) {
				skillTreeCnt++;
				continue;
			}

			// ù��° skill_trees�ȿ� skill�� ù��°�� ���� ��� ����ó��
			if (indexList.get(0) == 0)
				continue;

			// �ϳ��� ��ų�� �ִ� skill_tress�� �ƴϸ鼭 �������� ù ��ų�� �ִ� ��� ����ó��
			if (skillTree.length() != 1 && indexList.get(0) == skillTree.length())
				continue;

			initLastIndexZero(indexList);

			if (isAscendingOrder(indexList))
				skillTreeCnt++;

		}

		return skillTreeCnt;
	}

	// skill_tress index �˻� �� �������� -1�� ��쿡 ���� ����
	// �迭 �ȿ� 0 �� ��� ����
	public static void initLastIndexZero(List<Integer> indexList) {
		for (int i = indexList.size() - 1; i > 0; i--) {
			if (indexList.get(i) == 0) {
				indexList.remove(i);
			} else {
				break;
			}
		}
	}

	// ���� �������� index�� ������ �ִ� �� �˻�
	public static boolean isAscendingOrder(List<Integer> indexList) {
		boolean isOrderBy = true;
		for (int i = 0; i < indexList.size() - 1; i++) {
			if (indexList.get(i + 1) - indexList.get(i) < 0) {
				isOrderBy = false;
				break;
			}
		}
		return isOrderBy;
	}

	public static boolean isWithoutSkill(List<Integer> indexList) {
		boolean isAllZero = true;

		for (int i = 0; i < indexList.size(); i++) {
			if (!indexList.get(i).equals(0)) {
				isAllZero = false;
				break;
			}
		}

		return isAllZero;
	}

	public static void initSkillList(String skill, String skillTree, List<Integer> indexList) {
		// skill ���ڿ� �ʱ�ȭ
		List<String> skilTreesList = new ArrayList<String>();
		for (char ski : skillTree.toCharArray()) {
			skilTreesList.add(String.valueOf(ski));
		}

		// skill_trees ���ڿ� �ʱ�ȭ
		for (char ski : skill.toCharArray()) {
			int addIndex = skilTreesList.indexOf(String.valueOf(ski)) + 1;
			indexList.add(addIndex);
		}
	}

}
