package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_모두0으로만들기 {

	public static void main(String[] args) {
		
	}
	
	// 위상정렬
	class Solution {
	    
	    ArrayList<Integer>[] list;
	    boolean[] visited;
	    // 가중치
	    long[] weight;
	    // 진입 차수
	    int[] indegree;
	    long answer = 0;
	    
	    // a의 값들의 합이 홀수이면 불가능
	    public long solution(int[] a, int[][] edges) {
	                
	        long sum = 0;
	        weight = new long[a.length];
	        list = new ArrayList[a.length];
	        indegree = new int[a.length];
	        visited = new boolean[a.length];
	        
	        boolean flag = false;
	        for(int i = 0; i < a.length; i++) {
	            sum += a[i];
	            weight[i] = a[i];
	            list[i] = new ArrayList<>();
	            if(a[i] != 0) {
	                flag = true;
	            }
	        }
	        
	        // 합이 0이 아니면 만들기 불가능
	        if(sum != 0) return -1;
	        
	        // 합이 짝수이다.
	        // 전부다 0이면 0 리턴
	        if(!flag) return 0;
	        
	        for(int i = 0; i<edges.length; i++) {
	            list[edges[i][0]].add(edges[i][1]);
	            list[edges[i][1]].add(edges[i][0]);
	            // 진입 차수
	            indegree[edges[i][0]]++;
	            indegree[edges[i][1]]++;
	        }
	        
	        // 합이 짝수이고, 값이 1개라도 0이 아닐 경우
	        // 이때 될려면 합이 0 이어야 한다.
	        
	        topology();     
	        
	        return answer;
	    }
	    
	    public void topology() {
	        Queue<Integer> queue = new LinkedList<>();
	        for(int i = 0; i< indegree.length; i++) {
	            // 진입 차수가 1인 간선부터 큐에 넣어준다.
	            if(indegree[i] == 1) queue.offer(i);
	        }
	        
	        while(!queue.isEmpty()) {
	            int current = queue.poll();
	            visited[current] = true;
	            
	            for(int i = 0; i < list[current].size(); i++) {
	                int next = list[current].get(i);
	                // 방문 전이면
	                if(!visited[next]) {
	                    // 도착점의 진입차수 감소
	                    indegree[next]--;
	                    weight[next] += weight[current];
	                    answer += Math.abs(weight[current]);
	                    weight[current] = 0; // 현재 점의 가중치를 도착점의 가중치로 모두 이동하였기 때문에 0으로 초기화
	                    // 진입 차수가 1이 된 다음 점 큐에 넣기
	                    if(indegree[next] == 1) queue.offer(next);
	                }
	            }
	        }
	    }
	}

}
