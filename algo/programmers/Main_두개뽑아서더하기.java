package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main_두개뽑아서더하기 {

	public static void main(String[] args) {
		
	}
	
	class Solution {
	    public int[] solution(int[] numbers) {
	        List<Integer> list = new LinkedList<>();
	        for(int i = 0; i < numbers.length-1; i++) {
	            for(int j = i+1; j<numbers.length; j++) {
	                int sum = numbers[i] + numbers[j];
	                if(!list.contains(sum))
	                    list.add(sum);
	            }            
	        }
	        int[] answer = new int[list.size()];
	        int idx = 0;
	        for(int num : list) {
	            answer[idx] = num;
	            idx++;
	        }
	        Arrays.sort(answer);
	        return answer;
	    }
	}
}
