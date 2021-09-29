package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_4485_녹색옷입은애가젤다지 {
	private static int N;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,1,-1};
	
	private static class Node implements Comparable<Node> {
		int r,c,rupe;

		public Node(int r, int c, int rupe) {
			super();
			this.r = r;
			this.c = c;
			this.rupe = rupe;
		}

		@Override
		public int compareTo(Node o) {
			return this.rupe - o.rupe;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			cnt++;
			int[][] map = new int[N][N];			// 인접 행렬
			boolean[][] visited = new boolean[N][N]; 	// 방문 처리 배열
			int[][] distance = new int[N][N];			// 최소 비용 저장 배열
			int start = 0;							// 출발 정점
			int end = N-1;							// 도착 정점
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			초기값 갱신
			for(int i = 0; i<N; i++) {
				Arrays.fill(distance[i],Integer.MAX_VALUE);				
			}
			
			
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(start, start, map[start][start]));
//			출발지 값 갱신
			distance[start][start] = map[start][start];
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				int r = cur.r;
				int c = cur.c;
				int rupe = cur.rupe;
				
//				이미 방문했으면 패스
				if(visited[r][c]) continue;
				
				visited[r][c] = true;
				for(int d = 0; d<dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
//					경계 내부에 있고	바로 가는게		경유해서 가는것보다 크면
					if(isIn(nr,nc) && distance[nr][nc] > rupe + map[nr][nc]) {
//						바로가는 값 갱신
						distance[nr][nc] = rupe + map[nr][nc];
						pq.add(new Node(nr,nc, distance[nr][nc]));
					}
				}
			}			
			
			System.out.println("Problem "+cnt+": "+distance[end][end]);
		}
	}//main
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >=0 && c <N;
	}
}// end class
