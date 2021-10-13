package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_D4_1249_보급로_DFS {
	private static int T,N,ans;
	private static boolean[][] visited;
	private static int[][] map;
	private static int[] dr = {1,-1,0,0};
	private static int[] dc = {0,0,1,-1};
	
	private static class Pos implements Comparable<Pos>{
		int r, c,time;

		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			return this.time - o.time;
		}		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase =1; tcase<=T; tcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = 0;
			for(int i = 0; i<N; i++) {				
				String str = br.readLine();
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(str.charAt(j)+"");
				}
			}
			
			dfs(0,0);
			ans = map[N-1][N-1];
			System.out.println("#"+tcase+" "+ans);
		} // tcase for
		
	} // main
	
	private static void dfs(int startR, int startC) {
		visited[startR][startC] = true;
		
		for(int i = startR; i < N; i++) {
			for(int j = startC; j<N; j++) {
				int mintemp = 0;
				for(int d = 0; d<dr.length; d++) {
					int r = i + dr[d];
					int c = j + dc[d];
					int temp = map[i][j] + map[r][c];
//					경계 안이고	     방문 전일때
					if(isIn(r,c) && !visited[r][c] ) {
//						temp = Math.min(temp, map[r][c] + map[i][j]);
						dfs(r,c);
					}
				}
//				map[i][j] = temp;
			}
		}		 
	}
	
	private static boolean isIn(int r, int c ) {
		return r >=0 && r < N && c >= 0 && c<N;
	}

} // end class

