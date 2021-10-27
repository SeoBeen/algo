package study.programmers;

import java.util.ArrayList;

public class Solution_Lev1_모의고사 {

	public int[] solution(int[] answers) {
		
		int[] tmp = new int[3];
		int[] person1 = {1,2,3,4,5};			// 5
		int[] person2 = {2,1,2,3,2,4,2,5};		// 8
		int[] person3 = {3,3,1,1,2,2,4,4,5,5};			// 10
		
		int ans1 = 0, ans2 = 0, ans3 = 0;
		for(int idx = 0; idx<answers.length; idx++) {
			if(answers[idx] == person1[idx%5]) ans1++;
			if(answers[idx] == person2[idx%8]) ans2++;
			if(answers[idx] == person3[idx%10]) ans3++;
		}
		int max = Math.max(ans1,Math.max(ans2,ans3));
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(max == ans1) list.add(1);
		if(max == ans2) list.add(2);
		if(max == ans3) list.add(3);
		
			
		int[] answer = new int[list.size()];
		for(int i = 0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}
