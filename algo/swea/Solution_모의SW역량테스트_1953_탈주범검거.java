package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_1953_탈주범검거 {
	private static int T,N,M,R,C,L,ans;
	private static int[][] map;
	private static boolean[][] move;
//								상,하, 좌,우
	private static int[] dr = { -1, 1,  0,0};
	private static int[] dc = {  0, 0, -1,1};
	private static int[][] pipe = {//          상,하,좌,우 
									{0,0,0,0}, {1, 1, 1, 1}, {1,1,0,0}, {0,0,1,1},
									{1,0,0,1}, {0,1,0,1}, {0,1,1,0}, {1,0,1,0}
	};
	
	private static class Point {
		int r, c, t;

		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase= 1; tcase<= T; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());	// 세로크기
			M = Integer.parseInt(st.nextToken());	// 가로크기
			R = Integer.parseInt(st.nextToken());	// 맨홀뚜껑 R위치
			C = Integer.parseInt(st.nextToken());	// 맨홀뚜껑 C위치
			L = Integer.parseInt(st.nextToken());	// 탈출 후 경과 시간
			ans = 0;
			
			map = new int[N][M];					// 파이프 배치도
			move = new boolean[N][M];				// 이동가능 저장 배열
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			findPrisoner();
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(move[i][j]) ans++;
				}
			}			
			
			System.out.println("#"+tcase+" "+ans);
		}// tcase for		
	}// main


	private static void findPrisoner() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(R,C,1));
		move[R][C] = true;
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			int time = cur.t;
			
			if(time == L) break;
			
			for(int d = 0; d< dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
//					경계 안이고	  파이프가있으며		방문전이며, 파이프가 연결이 되어있으면				
				if(isIn(nr,nc) && map[nr][nc] !=0 && !move[nr][nc] && pipe[map[r][c]][d] == 1) {
					int curPipe = map[nr][nc];
//				현재꺼는 상		갈려는곳 파이프는	하
					if(d == 0 && pipe[curPipe][1] == 1) {
						move[nr][nc] = true; // 방문가능
						queue.offer(new Point(nr,nc,time+1));
					}
//							하					상
					else if(d == 1 && pipe[curPipe][0] == 1) {
						move[nr][nc] = true; // 방문가능
						queue.offer(new Point(nr,nc,time+1));
					}
//							좌					우
					else if(d == 2 && pipe[curPipe][3] == 1) {
						move[nr][nc] = true; // 방문가능
						queue.offer(new Point(nr,nc,time+1));
					}
//							우					좌
					else if(d == 3 && pipe[curPipe][2] == 1) {
						move[nr][nc] = true; // 방문가능
						queue.offer(new Point(nr,nc,time+1));
					}					
				}
			}
		}		
		
	}// findPrisoner
	
	private static boolean isIn(int r,int c) {
		return r>=0 && r<N && c >= 0 && c<M;
	}

}// end class
