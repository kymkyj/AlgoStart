package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 봄버맨
 * @author ji
 *
 */
public class Bomberman {

	static char map[][];
	static int fieldCntHorizantal, fieldCntVertical, n;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static Queue<NodeVO> que = new LinkedList<>();
	static int bombtime[][];
	static int time = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] plantCabbageInfo = br.readLine().split(" ");
		
		fieldCntHorizantal = Integer.valueOf(plantCabbageInfo[0]); // 행렬 가로 길이
		fieldCntVertical = Integer.valueOf(plantCabbageInfo[1]);// 행렬 세로 길이
		n = Integer.valueOf(plantCabbageInfo[2]);// 행렬에 1이 있는 위치
		
		map = new char[fieldCntHorizantal][fieldCntVertical];
		bombtime = new int[fieldCntHorizantal][fieldCntVertical];
		for (int i = 0; i < fieldCntHorizantal; i++) {
			String comPairNum = String.valueOf(br.readLine());
			for (int j = 0; j < fieldCntVertical; j++) {
				map[i][j] = comPairNum.charAt(j);
				if (map[i][j] == 'O') {
					que.add(new NodeVO(i, j));
					//3초가 지난 뒤에 폭발하기 때문에 다음과 같이 초기화
					bombtime[i][j] = 3;
				}

			}
		}
		
		 while(time++ <n) {
			 //1초가 지난 후에 아무 일도 벌어지지 않고 폭탄이 설치됨
	            if(time%2==0) {
	                setbomb();
	            }
	            else {
	            	//1초가 더 흐른 후에 폭단 폭발
	                getbomb();
	            }
	        }
	        
	        print();

	}

	public static void getbomb() {
		for (int i = 0; i < fieldCntHorizantal; i++) {
			for (int j = 0; j < fieldCntVertical; j++) {
				if (bombtime[i][j] == time) {
					bomb(i, j);
				}
			}
		}
	}

	public static void bomb(int x, int y) {
		map[x][y] = '.';

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isRange(nx, ny) && map[nx][ny] == 'O' && bombtime[nx][ny] != time) {
				bombtime[nx][ny] = 0;
				map[nx][ny] = '.';
			}
		}
	}

	public static void setbomb() {
		for (int i = 0; i < fieldCntHorizantal; i++) {
			for (int j = 0; j < fieldCntVertical; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
					bombtime[i][j] = time + 3;
				}
			}
		}
	}

	public static void print() {
		for (int i = 0; i < fieldCntHorizantal; i++) {
			for (int j = 0; j < fieldCntVertical; j++) {
				System.out.print(map[i][j] + "");
			}
			System.out.println();
		}
	}

	public static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < fieldCntHorizantal && y < fieldCntVertical) {
			return true;
		}
		return false;
	}
	
}

class NodeVO {
	int x, y;
	
	NodeVO(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

