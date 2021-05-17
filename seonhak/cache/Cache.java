package com.ji.study;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	
	public static int solution(int cacheSize, String[] cities) {
		int excuteTime = 0;
		Queue cacheQueue = new LinkedList<String>();

		if (cacheSize == 0) {
			excuteTime = cities.length * 5;
		} else {

			for (String city : cities) {
				city = city.toLowerCase();

				if (cacheQueue.contains(city)) {
					cacheQueue.remove(city);
					excuteTime++;
				} else {
					if (cacheQueue.size() >= cacheSize)
						cacheQueue.poll();
					
					excuteTime = excuteTime + 5;
				}
				
				cacheQueue.offer(city);
				
			}

		}

		return excuteTime;
	}

}
