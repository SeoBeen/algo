package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_1949_등산로조성_DFS {
	private static int T,N,K,ans;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<Peak> peak;
	private static int[] dr = {1,-1,0,0};
	private static int[] dc = {0,0,1,-1};
	
	private static class Peak {
		int r,c;

		public Peak(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
		}		
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tcase = 1; tcase<=T; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int maxPeak = 0;
			peak = new LinkedList<Peak>();
			ans = 0;
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxPeak = Math.max(maxPeak, map[i][j]);
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j] == maxPeak) {
						peak.offer(new Peak(i,j));
					}
				}
			}
			while(!peak.isEmpty()) {
				Peak curPeak = peak.poll();
				visited = new boolean[N][N];
//				시작점 방문처리
				visited[curPeak.r][curPeak.c] = true;
				dfs(curPeak.r,curPeak.c,1,false);				
			}
			
			System.out.println("#"+tcase+" "+ans);
		} // tcase for
		
	} // main
	
	private static void dfs(int r, int c, int len, boolean cut) {
		
		for(int d = 0; d<dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
//			경계 체크			방문전이면
			if(isIn(nr,nc) && !visited[nr][nc]) {
//					이동가능하고
				if(map[r][c] > map[nr][nc] ) {
					visited[nr][nc] = true;
					dfs(nr,nc,len+1,cut);
					visited[nr][nc] = false;
				}
//							깍으면 이동가능하고, 깍지않았으면
				else if(map[r][c] > map[nr][nc] - K &&!cut) {
					for(int cnt = 1; cnt <=K; cnt++) {
						
						if(map[r][c] > map[nr][nc]- cnt) {
							
							map[nr][nc] -= cnt;
							visited[nr][nc] = true;
							
							dfs(nr,nc,len+1,true);
							
							visited[nr][nc] = false;
							map[nr][nc] += cnt;
						}
					}
				}
			}
		}
		
		ans = Math.max(ans,len);
	}
	
	private static boolean isIn(int r, int c) {
		return r >=0 && r<N && c>=0 && c<N;
	}

}// end class
