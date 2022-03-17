package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_추석트래픽 {

	public static void main(String[] args) {
		
	}


	class Solution {
	    public int solution(String[] lines) {
	        int answer=0;
	        List<Integer> checkPoint = new ArrayList<>();
	        for(String line : lines) {
	        	int[] section = timeToMilliSec(line);
	        	checkPoint.add(section[0]);
	        	checkPoint.add(section[1]);
	        }
	        Collections.sort(checkPoint);
	        
	        for(int standard : checkPoint){
	        	int s = standard;
	        	int e = standard + 999;
	        	
	        	int cnt=0;
	        	for(String line : lines) {
	        		int[] log = timeToMilliSec(line);
	        		
	        		if(e < log[0] || log[1] < s ) continue;
	        		cnt++;
	        	}
	        	answer = Math.max(answer, cnt);
	        }
	        
	        return answer;
		}
		
	}
	static int[] timeToMilliSec(String line) {
		line = line.substring(11, line.length()-1);
		String[] data = line.split(" ");
		String[] time = data[0].split(":");
		double space = Double.parseDouble(data[1])*1000;
		
		int hhToMS = Integer.parseInt(time[0])*60*60*1000;
		int mmToMS = Integer.parseInt(time[1])*60*1000;
		double ssToMS = Double.parseDouble(time[2])*1000;
		
		int endTimeToMS = hhToMS + mmToMS + (int)ssToMS;
		int startTimeToMS = endTimeToMS - (int)space+1;
		
		return new int[] {startTimeToMS, endTimeToMS};
	}

}
