package study.programmers;

import java.util.*;
public class Solution_Lev1_완주하지못한선수 {
	class Solution {
	    public String solution(String[] participant, String[] completion) {
	        
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        String answer = participant[participant.length-1];
	        for(int i = 0; i<completion.length; i++) {
	            if(!participant[i].equals(completion[i])) {
	                answer = participant[i];
	                break;
	            }
	        }        
	        return answer;
	    }
	}
}
