package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {
	private static int T,N,L;
	private static int[] taste;
	private static int[] kcal;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = sc.nextInt();
		
		for(int tcase = 1; tcase<=T; tcase++) {
//			재료의 수
			N = sc.nextInt();
//			제한 칼로리
			L = sc.nextInt();
			taste = new int[N+1];
			kcal = new int[N+1];
			for(int i = 1; i<=N; i++) {
//				맛 점수
				taste[i] = sc.nextInt();
//				칼로리
				kcal[i] = sc.nextInt();				
			}
			
			int[][] ans = new int[N+1][L+1];
			for(int i = 1; i<=N; i++) {
				for(int cal = 1; cal <= L; cal++) {
					if(kcal[i] <= cal) {
						ans[i][cal] = Math.max(ans[i-1][cal], taste[i] + ans[i-1][cal-kcal[i]]);
					}
//				재료를 넣을 수 없다.
					else {
						ans[i][cal] = ans[i-1][cal];
					}
				}
			}			
			System.out.println("#"+tcase+" "+ans[N][L]);
		}// tcase
		
	}

}
