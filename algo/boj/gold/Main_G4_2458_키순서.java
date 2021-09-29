package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_2458_키순서 {
	private static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	// 학생 수
		M = Integer.parseInt(st.nextToken());	// 비교 수
		int ans = 0;
//		N은 1부터 시작
		int[][] map = new int[N+1][N+1];
		int max = Integer.MAX_VALUE >> 3;
		
//		초기값 세팅 모든 간선비용은 max로
		for(int i = 0; i<N+1; i++) {
			Arrays.fill(map[i],max);
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
//			비교 가능한 간선은 0으로 세팅
			map[start][end] = 1;
		}
		
//		경유지
		for(int k = 1; k<N+1; k++) {
//			출발지
			for(int i = 1; i<N+1; i++) {
				if(i == k) continue;	// 경유지가 출발지가 같은경우는 통과
//				도착지
				for(int j = 1; j<N+1; j++) {
					if(i == j || k == j) continue;	// 도착지와 출발지가 같거나, 도착지와 경유지가 같은경우는 패스
//					이전 경유지 비용	현 경유지 비용
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
//		for(int i = 1 ; i<N+1; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		for(int i = 1; i<N+1; i++) {
			int cnt = 0;
			for(int j =1; j<N+1; j++) {
//				자기자신한테 가는게 아니고, 내가 몇등인지 알 수 있으면
				if(i != j && map[i][j] != max || map[j][i] != max) {
					cnt++;
				}
			}
			if(cnt == N-1) ans++;
		}
		
		System.out.println(ans);
	}// main

}// end class
