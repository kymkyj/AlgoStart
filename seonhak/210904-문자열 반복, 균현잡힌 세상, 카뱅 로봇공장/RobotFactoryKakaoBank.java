package com.ji.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotFactoryKakaoBank {

	static Set<EquipVO> equipList = new HashSet<EquipVO>();//부품 정보 초기화
	static Set<Integer> equipType = new HashSet<Integer>(); //필요한 부품번호 저장
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }, 2));
	}

	public static int solution(int[][] needs, int r) {
		
		//입력값 초기화
		initEquipData(needs);

		//부품 종류 초기화
		int[] typeArr = equipType.stream().mapToInt(Number::intValue).toArray();
		
		//부품 종류 중 r개의 로봇이 선택할 수 있는 모든 경우의 수
		per1(typeArr, 0, equipType.size(), r);
		
		return max;
	}

	public static void initEquipData(int[][] needs) {

		for (int x = 0; x < needs.length; x++) {
			for (int y = 0; y < needs[x].length; y++) {

				if (needs[x][y] == 1) {

					EquipVO savedVO = null;
					for (EquipVO vo : equipList) {
						if (vo.getPrdNum() == x)
							savedVO = vo;
					}
					equipList.remove(savedVO);
					equipType.add(y);

					if (savedVO == null) {
						List<Integer> needEquipList = new ArrayList<>();
						needEquipList.add(y);
						equipList.add(new EquipVO(x, needEquipList));
					} else {
						savedVO.getEquipNum().add(y);
						equipList.add(new EquipVO(x, savedVO.getEquipNum()));
					}

				}

			}

		}
	}

	static void per1(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			
			int count=0;
			for(EquipVO vo : equipList) {
				int chk = 0;
				for (int i = 0; i < r; i++) {
					//로봇이 부품 처리한 경우의 수와 필요한 부품 번호가 동일한 경우 검사
					if(vo.getEquipNum().size() == r && vo.getEquipNum().get(i).equals(arr[i]))
						chk++;
					
					//완제품 번호[0] 필요한 부품 번호 [0] 인 경우
					if(vo.getEquipNum().size() < r) {
						int sChk = 0;
						for(int num : vo.getEquipNum()) { //r개의 로봇이 필요한 부품을 모두 포함하는지 검사
							for (int k = 0; k < r; k++) {
								if(arr[k] == num);
									sChk++; break;
							}
						}
						
						if(sChk == vo.getEquipNum().size())
							chk=r;
					}
						
				}
				
				if(chk == r)
					count++;
			}
			
			if(max < count)
				max = count;
			
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

class EquipVO {
	int prdNum; //완제품 번호
	List<Integer> equipNum; //필요한 부품 번호

	public EquipVO(int prdNum, List<Integer> equipNum) {
		super();
		this.prdNum = prdNum;
		this.equipNum = equipNum;
	}

	public int getPrdNum() {
		return prdNum;
	}

	public void setPrdNum(int prdNum) {
		this.prdNum = prdNum;
	}

	public List<Integer> getEquipNum() {
		return equipNum;
	}

	public void setEquipNum(List<Integer> equipNum) {
		this.equipNum = equipNum;
	}

}
