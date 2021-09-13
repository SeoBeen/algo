package com.ssafy.afterclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7236_저수지의물의총깊이구하기 {
	private static int T,N;
//								상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	private static int[] dr = { -1,  -1,   0,   1,   1,  1,   0,   -1};  
	private static int[] dc = { 0,   1,   1,   1,   0,  -1,   -1,  -1}; 
	private static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=T; tcase++) {
			N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][N];
			int max = Integer.MIN_VALUE;
			
			for(int i =0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					
					if(map[r][c] == 'W') {						
						int sum = 0;	// 물 깊이
						
						for(int d = 0; d<dr.length; d++) {
							
							int nr = r + dr[d];
							int nc = c + dc[d];
//							경계 밖이면 넘어감
							if(!isIn(nr,nc)) continue;				
//							경계 안이면 탐색 시작
							if(map[nr][nc] == 'W') {
								sum++;
							}		
						}
					max = Math.max(max,sum);
					}
				}
			}
			
		System.out.println("#"+tcase+" "+(max==0? 1 : max));
		}// tcase for
	}// main
	
	private static boolean isIn(int r, int c) {		
		return r >= 0 && r< N && c>=0 && c<N; 
	}

}// end class


