package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_8458_원점으로집합 {
	private static int T;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=T; tcase++) {
//			N개의 격자점
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int ans = 0;
//			최고의 군을 구하기 위한 변수( 여기서 군은 x 좌표 + y좌표)
			int maxKun = Integer.MIN_VALUE;
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<2; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}				
				maxKun = Math.max(maxKun, Math.abs(map[i][0])+Math.abs(map[i][1]));
			}
			
			for(int i = 0; i<N-1; i++) {
//				홀수 또는 짝수로 통일이 안되어 있음 ==> 원점으로 못감.
				if(Math.abs((map[i][0]+ map[i][1])) % 2 != Math.abs((map[i+1][0]+map[i+1][1]) %2)) {
					ans = -1;
					break;
				}
			}
//			홀수 or 짝수로 통일이 되어있을 경우 
			int sum = 0;
			if(ans != -1) {
				while(true) {
//					sum : i 차례때 움직인 거리
					sum += ans;
//					거리가 maxKun보다 크거나 같고, 차이가 짝수일때 원점에 도달가능.
//													=> 각 정점들의 차이는 무조건 짝수만큼 나게 되어있음.
//													홀수 - 홀수 = 짝수, 짝수 - 짝수 = 짝수
					if(sum >= maxKun && (sum-maxKun)%2 == 0) {
						break;
					}
//					ans : 움직인 횟수
					ans++;
				}
			}
			
			System.out.println("#"+tcase+" "+ ans);
		}// tcase for
	}// main

}// end class


