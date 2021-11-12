package study.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 
 */
public class Solution_Lev2_프린터 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public int solution(int[] priorities, int location) {
        int answer = 0;
        
//        역순정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        	
        for(int i = 0; i<priorities.length; i++) {
        	pq.offer(priorities[i]);
        }
        System.out.println(pq);
        
        while(!pq.isEmpty()) {
        	for(int i = 0; i<priorities.length; i++) {
        		if(pq.peek() == priorities[i]){
        			if(i == location) {
        				return ++answer;
                    }
                pq.poll();
        		answer++;
       			}
        	}
       	}
        return answer;
    }
	
}
