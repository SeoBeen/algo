package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G4_17144_미세먼지안녕 {
	private static int R,C,T,cleanerR,ans;
	private static int[][] map;
	private static int[] dr = {1,-1,0,0};
	private static int[] dc = {0,0,1,-1};
	
	private static class Dust {
		int r, c, weight;

		public Dust(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]== -1) cleanerR = i; 	// 공기청정기 행값 저장
			}
		}
		
		for(int tcase = 1; tcase <=T; tcase++) {
			findDust();			
			turnOn();
		}
		for(int i = 0; i<R; i++) {
			for(int j = 0 ; j<C; j++) {
				if(map[i][j] != -1) {
					ans += map[i][j];
				}
			}
		}
//		for(int[] c : map) {
//			System.out.println(Arrays.toString(c));
//		}
		System.out.println(ans);
	}// main
	
	private static void turnOn() {
//		위쪽 좌표
		int topR = cleanerR -1;
//		아래쪽 좌표
		int bottomR = cleanerR;
		
//		공기 청정기 위쪽 열
		for(int i = topR-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
//		맨 윗줄
		for(int i = 0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
//		위쪽 맨 오른쪽 열
		for(int i = 0; i<topR; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
//		위쪽 공기청정기 행
		for(int i = C-1; i>1; i--) {
			map[topR][i] = map[topR][i-1];
		}
//		공기청정기에서 나온 바람
		map[topR][1] = 0;
		
//		공기 청정기 아래쪽 열
		for(int i = bottomR+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
//		맨 아랫줄
		for(int i = 0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
//		아랫쪽 맨 오른쪽 열
		for(int i = R-1; i>bottomR; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
//		아래쪽 공기청정기 행
		for(int i = C-1; i> 1; i--) {
			map[bottomR][i] = map[bottomR][i-1];
		}
//		공기청정기에서 나온 바람
		map[bottomR][1] = 0;		
		
	}

	private static void findDust() {
//		먼지 찾아서 위치 저장하기
		LinkedList<Dust> dust = new LinkedList<Dust>();
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
//					먼지 위치 저장
					dust.offer(new Dust(i,j,map[i][j]));
				}
			}
		}
//		먼지 확산
		while(!dust.isEmpty()) {
			Dust cur = dust.poll();
//			확산되는 양은 /5 이고 소수점은 버리기 때문에 5보다 작을경우 확산 X
			if(cur.weight < 5) continue;
			int r = cur.r;
			int c = cur.c;
//			확산되는 양
			int spreadDust = cur.weight/5;
//			확산되는 방향의 개수
			int wayCnt = 0;
			for(int d = 0; d<dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
//					경계 안이고		공기청정기가 아니면
				if(isIn(nr,nc) && map[nr][nc] != -1) {
//					확산이 일어남
					map[nr][nc] += spreadDust;
//					확산 방향 개수 증가
					wayCnt++;
				}
			}
//			남은 미세먼지 양
			map[r][c] -= spreadDust * wayCnt;
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}// end class

/*
7 6 1
1 2 3 4 5 6
6 5 4 3 2 1
-1 2 3 4 5 6
-1 6 5 4 3 2
1 2 3 4 5 6
6 5 4 3 2 1
1 2 3 4 5 6

ans : 138
*/