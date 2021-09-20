package com.ssafy.webex.algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	private static int N,M,V;
	private static boolean[][] map;
	private static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());				
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true; 
			map[c][r] = true;			
		}
		
		dfs(V);
		Arrays.fill(isVisited, false);
		System.out.println();
		bfs(V);
	}
	
	private static void dfs(int cur) {
		isVisited[cur] = true;
		System.out.printf("%d ",cur);
		
		for(int ad = 1; ad <= N; ad++) {
			if(map[cur][ad] && !isVisited[ad]) {
				dfs(ad);
			}
		}
	}
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();	// 탐색할 노드를 담을 queue
//		시작 노드를 queue에 담고 시작
		queue.offer(cur);
		
//		queue에 담은 node방문처리
		isVisited[cur] = true;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();	 // 현재 방문할 노드를 queue에서 꺼내온다.
			System.out.printf("%d ",cur);
			
//			간선으로 연결된 node를 방문
			for(int adj = 1; adj<=N; adj++) {
				if(map[cur][adj] && !isVisited[adj]) {
					queue.offer(adj);
					isVisited[adj] = true;
				}
			}
		}	
	}
}
