package study.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lev2_기능개발 {

	public static void main(String[] args) {

	}
	
	public int[] solution(int[] progresses, int[] speeds) {
        
     // 필요 작업 일수
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> ans = new LinkedList<Integer>();
        int days = 0;
        for(int i = 0; i<speeds.length; i++) {
            days = (100 - progresses[i])%speeds[i] == 0 
                ? (100-progresses[i])/speeds[i] 
                : (100-progresses[i])/speeds[i]+1;
            queue.add(days);
        }
        int today = queue.poll();
        int cnt = 1;
        while(!queue.isEmpty()) {
            int nextday = queue.peek();
        	if(today < nextday) {
        		ans.offer(cnt);
                today = queue.poll();
        		cnt = 1;
        	} 
        	else {
        		queue.poll();
        		cnt++;
        	}
            if(queue.isEmpty()) ans.offer(cnt);
        }
        int[] answer = new int[ans.size()];
        int idx= 0;
        System.out.println(ans.size());
        while(!ans.isEmpty()) {
        	answer[idx] = ans.poll();
        	idx++;
        }
        return answer;
    }
}
