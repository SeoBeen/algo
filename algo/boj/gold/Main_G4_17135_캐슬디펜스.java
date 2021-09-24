package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17135_캐슬디펜스 {
	private static int N,M,D,maxKill,killCnt;
	private static int[][] map, copyMap;
	private static int[] archer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	// R
		M = Integer.parseInt(st.nextToken());	// C
		D = Integer.parseInt(st.nextToken());	// 궁수 리치
		map = new int[N][M];
		copyMap = new int[N][M];
		archer = new int[3];	// 궁수 열 위치
		maxKill = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 궁수 위치 조합으로 뽑기
//		  궁수 수,열 위치
		archer(0,0);
		
		System.out.println(maxKill);
		
	}// main
	private static void archer(int cnt, int cur) {
//		기저 조건 궁수는 3명
		if(cnt == 3) {
//			연습용 맵이 필요함.
			for(int i = 0 ; i<N; i++) {
				for(int j = 0; j<M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
//			System.out.println(Arrays.toString(archer));
			play();
			return;
		}
		for(int i = cur; i<M; i++) {
//			cnt번째 궁수의 열위치
			archer[cnt] = i;
			archer(cnt+1, cur+1);
		}
	}
	private static void play() {
		killCnt = 0;
//		N번까지 진행가능.
		for(int i = 0; i<N; i++) {
//			공격 체크를 위한 배열
			boolean[][] attacked = new boolean[N][M];
			
//			acIdx번째 궁수
			for(int acIdx = 0; acIdx < archer.length; acIdx++) {
//				적 좌표
				int enemyR = 0;
				int enemyC = 0;
//				가장 가까운 적과의 거리
				int minDistance = Integer.MAX_VALUE;
				
//				적 찾기
				for(int r = 0; r<N; r++) {
					for(int c = 0; c<M; c++) {
//						적발견
						if(copyMap[r][c] == 1) {
//							새로운 최단거리 발생할 경우									
//													적 위치, 궁수 행위치는 N고정, 열위치
							if(minDistance > distance(r,c, N, archer[acIdx])) {
//								좌표 및 거리 갱신
								enemyR = r;
								enemyC = c;
								minDistance = distance(r,c,N, archer[acIdx]);
							}
//							거리가 같으면 열좌표(c)가 왼쪽인거 우선.
							else if(minDistance == distance(r,c,N, archer[acIdx])) {
								if(c < enemyC) {
									enemyR = r;
									enemyC = c;
								}
							}
						}
					}
				}
//				여기로 떨어짐 ==> 이제 가장 가까운 적 과의 거리 및 좌표 나옴
//				유효사거리 안이면서      아직 잡지 않은경우
				if(D >= minDistance) {
//					System.out.println("R : "+ enemyR+" C : "+enemyC);
//					적 잡음.
					attacked[enemyR][enemyC] = true;
				}
			}// acIdx for
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<M; c++) {
//					적이 공격당했으면
					if(attacked[r][c]) {
//						죽이기
						copyMap[r][c] = 0;
						killCnt++;
					}
				}
			} // kill for
			
//			맨 아래줄(N-1) 값 지우기
			for(int d = 0; d<M; d++) {
				copyMap[N-1][d] = 0;
			}
			
			
//			한 줄씩 밑으로 내려오기
			for(int row = N-1; row>0; row--) {
				for(int col = 0; col<M; col++) {
					copyMap[row][col] = copyMap[row-1][col];
				}
			}
			
			for(int d = 0; d<M; d++) {
				copyMap[i][d] = 0;
			}
			
		}// N for
		maxKill = Math.max(maxKill,killCnt);
	}
	
	private static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
} // end class
