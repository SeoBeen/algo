package leetcode;

import java.util.Arrays;

public class Solution_1029 {

	public static void main(String[] args) {
		int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
		
		// a 도시 합
		int sumA = 0;
		// b와 a의 차이값 저장
		int[] sub = new int[costs.length];
		for(int i = 0; i<costs.length; i++) {
			sumA += costs[i][0];
			sub[i] = costs[i][1] - costs[i][0];
		}
		
		Arrays.sort(sub);
		
		// N명만
		for(int i = 0; i < costs.length/2; i++) {
			sumA += sub[i];
		}
		System.out.println(sumA);
	}

}
