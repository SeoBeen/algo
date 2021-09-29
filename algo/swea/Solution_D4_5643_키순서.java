package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서 {
	private static int T;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<= T; tcase++) {
			int max = Integer.MAX_VALUE >> 4;
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			
//			초기화
			for(int i = 0; i<N+1; i++) {
				Arrays.fill(map[i],max);				
			}
			
			for(int i = 0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[start][end] = 1;
			}
//			경유지
			for(int k = 1; k<N+1; k++) {
//				출발지
				for(int i = 1; i<N+1; i++) {
					if(i == k) continue;
//					도착지
					for(int j = 1; j<N+1; j++) {
						if(i == j || k == j) continue;						
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
			for(int i = 1; i<N+1; i++) {
				int cnt = 0;
				for(int j = 1; j<N+1; j++) {
					if(i != j && map[i][j] != max || map[j][i] != max) cnt++;
				}
				if(cnt == N-1 ) ans++;
			}			
			
			System.out.println("#"+tcase+" "+ans);
		}// tcase for
	}//main

}// end class

