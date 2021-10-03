package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2 {
	private static int T,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tcase = 1; tcase <= T; tcase++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int max = Integer.MAX_VALUE>>2;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0)
						map[i][j] = max;
				}
			}
//			경유지
			for(int k = 0; k <N; k++) {
//				출발지
				for(int i = 0; i <N; i++) {
					if(k == i ) continue;
//					도착지
					for(int j = 0; j<N; j++) {
						if(k==j || i==j) continue;						
						if(map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}					
				}
			}
//			for(int[] c : map) {
//				System.out.println(Arrays.toString(c));
//			}
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<N; i++) {
				int sum = 0;
				for(int j = 0; j<N; j++) {
					sum += map[i][j];
				}
				min = Math.min(sum,min);
			}
			
			System.out.println("#"+tcase+" "+min);
		}// tcase
	}

}
