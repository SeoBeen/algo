package leetcode;

public class Solution_991 {

	public static void main(String[] args) {
		int startValue = 3;
		int target = 10;
		
		int answer = 0;
		
		while(target > startValue) {
			if(target % 2 == 0) {
				target /=2;
			}
			else {
				target++;
			}
			answer++;
		}
		System.out.println(startValue);
		System.out.println(target);
		// 마지막 1차이 나거나 똑같을때 처리
		System.out.println(answer + startValue - target);		
	}

}
