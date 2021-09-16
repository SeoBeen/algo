package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_9205_맥주마시면서걸어가기 {
	private static int t,n;
	private static int N,M; // 페스티벌 좌표
	private static boolean[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int tcase = 0; tcase< t; tcase++) {
			n = Integer.parseInt(br.readLine()); // 편의점 개수
			
			map = new boolean[n+2][n+2];	//각 건물들을 0번부터 시작하는 정점을 위한 맵
			int[] dx = new int[n+2];	// x좌표 집합
			int[] dy = new int[n+2];	// y좌표 집합
			
			for(int i = 0; i<n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j <2; j++) {
					if(j == 0) {						
						dx[i] = Integer.parseInt(st.nextToken());
					} else {
						dy[i] = Integer.parseInt(st.nextToken());						
					}
				}
			}
			
			for(int i = 0; i<n+2; i++) {
				for(int j = 0; j<n+2; j++) {
//					x좌표 차
					int x = Math.abs(dx[j] - dx[i]);
//					y좌표 차
					int y = Math.abs(dy[j] - dy[i]);
//					정점끼리의 거리	  1000초과 못감 아니면 감
					map[i][j] = x+y > 1000 ?   false :    true;
				}
			}
			
//			경찰도
			for(int k = 0; k<n+2; k++) {
				for(int i = 0; i<n+2; i++) {
					if(i == k ) continue;
					for(int j = 0; j<n+2; j++) {
						if(k == j | i == j ) continue;
//							직빵 못감		but	경유로 가능
						if(map[i][j] != true && ((map[i][k] & map[k][j]) == true)) {
//							그럼 나도 가능
							map[i][j] = true;
						}
					}
				}
			}
			
//			for(boolean[] c : map) {
//				System.out.println(Arrays.toString(c));
//			}
//			경찰도 끝냄 ==> 이제 집에서 페스티벌까지 가능여부 나옴.
			System.out.println(map[0][n+1] == false ? "sad" : "happy");
			
		}// tcase
	}//main

}// class
