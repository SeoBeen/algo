package com.ssafy.afterclass.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2206_벽부수고이동하기 {
	private static int N,M,ans = Integer.MAX_VALUE;
	private static int[][] map;
	private static int[] dr = {1,-1,0,0};
	private static int[] dc = {0,0,-1,1};
	
	private static class Point {
		int r,c,cnt,puk;
		public Point(int r, int c, int cnt, int puk) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.puk = puk;
		}		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for(int i = 1; i <=N; i++) {
			String str = br.readLine();
			for(int j = 1; j<=M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
			}
		}
		
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
//		for(int[] c : map) {
//			System.out.println(Arrays.toString(c));
//		}
		
	} // main

	private static void bfs() {
		Queue <Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N+1][M+1][2];
		queue.add(new Point(1,1,1,0));
		visited[1][1][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.r == N && p.c == M) {
				ans = Math.min(ans, p.cnt);
				break;
			}
			for(int d = 0; d<dr.length; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
//				경계 체크
				if(isIn(nr,nc)) {
//						이동가능하고			아직 방문 전이면
					if(map[nr][nc] == 0 && !visited[nr][nc][p.puk]) {
						visited[nr][nc][p.puk] = true;
						queue.offer(new Point(nr,nc, p.cnt+1, p.puk));
					} 
//								벽이고			아직 부순적이 없다면
					else if(map[nr][nc] == 1 && p.puk == 0) {						
						visited[nr][nc][1] = true;
						queue.add(new Point(nr,nc, p.cnt+1, 1));
					}
				}				
			}			
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <=M;
	}

}// end class
