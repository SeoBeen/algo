package com.ssafy.webex.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS2 {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int N,M,V;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];					// 배열의 index 번호가 Node 정보
		for(int i = 1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();		// 인접 정보를 담을 ArrayList 객체를 미리 생성			
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int ad = Integer.parseInt(st.nextToken());
			list[node].add(ad);		// 노드에 인접 정보 추가
			list[ad].add(node);		// 인접된 노드에도 인접 정보 추가
		}
		
		for(int i = 1; i<=N; i++) {
			Collections.sort(list[i]);		// 인접 행렬과 같은 효과를 주기 위해서는 인접 정보를 오름 차순으로 정렬한다.
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		Arrays.fill(visited,false);
		bfs(V);
	}

	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		visited[cur] = true;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(cur+" ");
			
			for(int i = 0, end = list[cur].size(); i<end; i++) {
				int ad  = list[cur].get(i);			// cur 노드의 인접 정보 추출	<= 인접된 노드만 추출되므로
				if(!visited[ad]) {					// 인접된 노드가 방문했는지 여부만 검사
					visited[ad] = true;
					queue.offer(ad);
				}
			}
		}
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print(cur+" ");
		
		for(int i = 0, end = list[cur].size(); i <end; i++) {
			int ad = list[cur].get(i);
			if(!visited[ad]) {
				dfs(ad);
			}
		}
	}

}
