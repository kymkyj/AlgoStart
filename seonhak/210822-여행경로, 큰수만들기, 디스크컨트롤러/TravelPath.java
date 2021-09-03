package com.ji.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 여행 경로
 * 
 * @author ji
 *
 */
public class TravelPath {

	public static void main(String[] args) {

//		String[] result1 = solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
//		for (String res : result1)
//			System.out.print(res + " ");
//		System.out.println();
		String[] result2 = solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" },
				{ "ATL", "ICN" }, { "ATL", "SFO" } });
//		for (String res : result2)
//			System.out.print(res + " ");
	}

	static boolean visit[];
	static List<String> list = new ArrayList<>();
	static String route = "";

	public static String[] solution(String[][] tickets) {
		String[] answer = {};

		visit = new boolean[tickets.length];

		for (int i = 0; i < tickets.length; i++) {
			// 반복
			String departure = tickets[i][0];
			String destination = tickets[i][1];

			if (departure.equals("ICN")) {
				visit[i] = true; // tickets[i][0]이 기준
				route = departure + ","; // ICN
				dfs(tickets, destination, 1);
				visit[i] = false; // 다시 경로를 찾으려고
			}
		}
		
		// 다음 모든 경우에 수가 나옴
		//ICN,ATL,ICN,SFO,ATL,SFO,
		//ICN,ATL,SFO,ATL,ICN,SFO,
		//ICN,SFO,ATL,ICN,ATL,SFO,
		Collections.sort(list);
		answer = list.get(0).split(",");

		return answer;
	}

	static void dfs(String[][] tickets, String end, int count) {

		//다음 티켓 정보가 append 됨
		route += end + ",";

		if (count == tickets.length) {
			list.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			String depart = tickets[i][0];
			String desti = tickets[i][1];

			//ICN,ATL,ICN,SFO,ATL,SFO,
			//ICN,ATL,SFO,ATL,ICN,SFO, 
			//백트래킹으로 통해서 다음 2가지 경우 모두 찾음!!!
			// 출발-도착 -> 출발-도착 로 이어진거 찾으려고
			if (end.equals(depart) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, desti, count + 1);
				visit[i] = false; // 다시 찾으려고
				// 기존에 경로를 하나씩 지우면서 다시 검색
				route = route.substring(0, route.length() - 4); 
			}
		}
	}

}
