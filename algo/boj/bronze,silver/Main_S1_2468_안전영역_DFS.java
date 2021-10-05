package com.ssafy.webex.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2468_안전영역_DFS {
	private static int N,ans,cnt;
	private static int[][] map; 
	private static boolean[][] visited;
	private static int[] dr = { -1,1,0,0};
	private static int[] dc = { 0,0,-1,1};
	
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
		ans = 1;
//		강수량 0(비가 안옴) ~ 다 잠길때까지
		for(int i = 0; i<=maxH; i++) {
			visited = new boolean[N][N];
			cnt = 0;
			for(int r = 0; r <N; r++) {
				for (int c = 0; c<N; c++) {
//						안전영역이고	방문 전이면
					if(map[r][c] > i && !visited[r][c]) {
						visited[r][c] = true;
						dfs(r,c,i);
						cnt++;
					}
				}
			}
			ans = Math.max(ans,cnt);
		}
		
		System.out.println(ans);
	} // main
	
	private static void dfs(int r, int c, int height) {
		
		for(int d = 0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
//			경계 내부이고		안전영역이고			방문전이면
			if(isIn(nr,nc) && map[nr][nc] > height && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc,height);
			}
		}		
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r <N && c >=0 && c <N;
	}
}// end class
