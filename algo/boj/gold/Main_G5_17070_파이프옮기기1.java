package com.ssafy.webex.algo.boj;

import java.util.Scanner;

public class Main_G5_17070_파이프옮기기1 {
	private static int N;
	private static int[][] map;
	private static int cnt;
//							 우, 우하, 하
	private static int[] dr = {0, 1, 1};
	private static int[] dc = {1, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N;j ++) {
				map[i][j] = sc.nextInt();
			}
		}
//		0은 가로, 1는 대각선, 2은 세로
		dfs(0,1,0);
		System.out.println(cnt);
		sc.close();
	}
	private static void dfs(int r, int c, int way) {
//		기저 조건
		if(r == N-1 && c == N-1) {
			cnt++;
			return;
		}
//		가로
		if(way == 0) {
			for(int d = 0; d<2; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
//			    경계 내부		
				if(isIn(nr,nc)) {
					if(d == 0 && map[nr][nc] != 1)
					{ 						
//						방문
						dfs(nr,nc,d);
					}
					else if(d == 1 && map[nr][nc] != 1 && map[nr-1][nc] != 1 && map[nr][nc-1] != 1) {
						dfs(nr,nc,d);
					}						
				}
			}			
		} // if
//		대각선
		else if(way == 1) {
			for(int d = 0; d<dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
//			    경계 내부		
				if(isIn(nr,nc)) {
					if(d == 0 && map[nr][nc] != 1)
					{ 						
//						방문
						dfs(nr,nc,d);
					}
					else if(d == 1 && map[nr][nc] != 1 && map[nr-1][nc] != 1 && map[nr][nc-1] != 1) {
						dfs(nr,nc,d);
					}
					else if(d == 2 && map[nr][nc] != 1)
					{ 						
//						방문
						dfs(nr,nc,d);
					}
				}
			}
		}// else if
//		세로
		else if(way == 2) {
			for(int d = 1; d<dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
//			    경계 내부		
				if(isIn(nr,nc)) {
					if(d == 1 && map[nr][nc] != 1 && map[nr-1][nc] != 1 && map[nr][nc-1] != 1)
					{
//						방문
						dfs(nr,nc,d);
					}
					else if(d == 2 && map[nr][nc] != 1) {
						dfs(nr,nc,d);
					}						
				}
			}			
		}
		
	}
	private static boolean isIn(int r , int c) {
		return r >=0 && r < N && c >= 0 && c < N; 
	}

}
