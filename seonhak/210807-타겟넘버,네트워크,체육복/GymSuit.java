package com.ji.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GymSuit {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3 }));
		System.out.println(solution(3, new int[] { 3 }, new int[] { 1 }));
		System.out.println(solution(3, new int[] { 1, 2 }, new int[] { 2,3 }));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		Arrays.sort(lost);
		Arrays.sort(reserve);

		List<PersonVO> sendPossibleList = new ArrayList<PersonVO>();
		for (int i = 1; i <= n; i++) {

			PersonVO personVO = new PersonVO();
			personVO.setIndex(i);
			personVO.setTotal(1);

			if (Arrays.binarySearch(lost, i) >= 0)
				personVO.setTotal(personVO.getTotal() - 1);

			if (Arrays.binarySearch(reserve, i) >= 0)
				personVO.setTotal(personVO.getTotal() + 1);
			
			sendPossibleList.add(personVO);
		}

		for (int i = 1; i < sendPossibleList.size(); i++) {

			if (sendPossibleList.get(i).getTotal() > 1 && sendPossibleList.get(i - 1).getTotal() == 0) {
				sendPossibleList.get(i - 1).setTotal(1);
				continue;
			}
			
			if(i+1 >= sendPossibleList.size())
				continue;
			
			if (sendPossibleList.get(i).getTotal() > 1 && sendPossibleList.get(i + 1).getTotal() == 0) {
				sendPossibleList.get(i + 1).setTotal(1);
				continue;
			}

		}

		for (PersonVO vo : sendPossibleList) {
			if (vo.getTotal() > 0)
				answer++;
		}

		return answer;
	}

}

class PersonVO {
	Integer index;
	Integer total;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
