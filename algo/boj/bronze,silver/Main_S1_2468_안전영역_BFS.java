package com.ssafy.webex.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2468_안전영역_BFS {
	private static int N,ans;
	private static int[][] map;
	private static int[] dr = { -1,1,0,0};
	private static int[] dc = { 0,0,-1,1};
	
	private static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxH = Integer.MIN_VALUE;
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = maxH > map[i][j] ? maxH : map[i][j];
			}
		}
		
//		강수량 0(비가 안옴) ~ 다 잠길때까지
		for(int i = 0; i<=maxH; i++) {
			bfs(i);			
		}
		
		System.out.println(ans);
	} // main
	
	private static void bfs(int height) {
		int cnt = 0;		
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] <= height) visited[i][j] = true;
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
//					안전영역이면
				if(!visited[i][j]) {
					Queue<Point> queue = new LinkedList<Point>();
					
					queue.offer(new Point(i,j));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Point cur = queue.poll();
						
						int r = cur.r;
						int c = cur.c;
						
						for(int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(isIn(nr,nc) && !visited[nr][nc]) {
								visited[nr][nc] = true;
								queue.offer(new Point(nr,nc));
							}
						}
					}
					cnt++;					
				}
				
			}
		}
		ans = Math.max(ans,cnt);		
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r <N && c >=0 && c <N;
	}
}// end class
