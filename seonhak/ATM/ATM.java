package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int personCount = Integer.valueOf(br.readLine());
		String[] delayTime = br.readLine().split(" ");

		List<Person> personList = new ArrayList<Person>();
		
		for (int i = 0; i < personCount; i++) 
			personList.add(new Person(i, Integer.valueOf(delayTime[i])));

		//사람 별 지연시간 오름차수 정렬
		personList.sort(new Comparator<Person>() {
			@Override
			public int compare(Person arg0, Person arg1) {
				int age0 = arg0.getDealyTime();
				int age1 = arg1.getDealyTime();
				if (age0 == age1)
					return 0;
				else if (age0 > age1)
					return 1;
				else
					return -1;
			}
		});

		//중첩 시간 합
		int result = 0;
		int sum = 0;
		for (Person per : personList) {
			sum += per.getDealyTime();
			result += sum;
		}
		
		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();
	}

}

class Person {
	Integer index;
	Integer dealyTime;

	public Person(Integer index, Integer dealyTime) {
		super();
		this.index = index;
		this.dealyTime = dealyTime;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getDealyTime() {
		return dealyTime;
	}

	public void setDealyTime(Integer dealyTime) {
		this.dealyTime = dealyTime;
	}
}
