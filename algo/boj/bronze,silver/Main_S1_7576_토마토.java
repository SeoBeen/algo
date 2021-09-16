package com.ssafy.afterclass.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//퍼져나간다면 bfs문제 (step by step) 
		// 퍼져나가는 길이 몇개인가요? 하면 dfs
				
		// 상자의 크기가 1000보다 작다 -> bfs
		// 만약 백트래킹이 걸리지 않은 상태에서 10 이상 
//			넘어간다면 dfs로 풀게되면 백트래킹 없는 완전탐색으로는 스택오버플로우가 나올 가능성이 큼
public class Main_S1_7576_토마토 {
	static class Tomato {
		int r, c,day;

		public Tomato(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}		
	}
	private static int[] dr = {1,-1,0,0};
	private static int[] dc = {0,0,1,-1};
	private static int N,M,ans;
	private static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N][M];
		Queue<Tomato> queue = new LinkedList<Tomato>();
		
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c<map[r].length; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 1) {
					queue.offer(new Tomato(r,c,0));
				}
			}
		}
		// bfs		
		while(!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			ans = Math.max(ans, tomato.day);
			for(int d = 0; d<4; d++) {
				int nr = tomato.r + dr[d];
				int nc = tomato.c + dc[d];
				
				if(nr>=0 && nr<N && nc<M && nc>=0 && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					queue.offer(new Tomato(nr,nc,tomato.day+1));
				}
			}
		}
		if(check(map)) ans = -1;
		
		System.out.println(ans);
		
	}
	private static boolean check(int[][] map2) {
		for(int r = 0; r<N; r++) {
			for(int c = 0; c < M; c++) {
				if(map2[r][c] == 0) return true;
			}
		}
		return false;
	}
}
