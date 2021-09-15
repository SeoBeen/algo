package com.ssafy.webex.algo.boj;

import java.util.Scanner;

public class Main_S1_1149_RGB거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N+1][3];
//		비용 저장할 배열
		int[][] cost = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j<3; j++) {
				map[i][j]= sc.nextInt();
			}
		}
		for(int i = 1; i<= N; i++) {
//			red
			cost[i][0] = Math.min(cost[i-1][1],cost[i-1][2]) + map[i][0];
//			green
			cost[i][1] = Math.min(cost[i-1][0],cost[i-1][2]) + map[i][1];
//			blue
			cost[i][2] = Math.min(cost[i-1][0],cost[i-1][1]) + map[i][2];			
			
		}
		System.out.println(Math.min(Math.min(cost[N][0],cost[N][1]), cost[N][2]));
		sc.close();
	}
}
