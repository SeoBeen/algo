package leetcode;

import java.util.Arrays;

public class Solution_881 {

	public static void main(String[] args) {
		int[] people = {3,5,3,4};
		int limit = 5;
		
		Arrays.sort(people);
		
		int answer = 0;
		int lastIdx = people.length-1;
		int startIdx = 0;
		int cnt = people.length;
		while(cnt > 0) {
			// 2명이 못 탈 경우
			if(people[lastIdx] + people[startIdx] > limit) {
				cnt--;
				lastIdx--;
				answer++;
			}
			// 2명이 탑승 가능한 경우
			else {
				cnt-=2;
				answer++;
				lastIdx--;
				startIdx++;
			}
		}
		System.out.println(answer);
	}

}
