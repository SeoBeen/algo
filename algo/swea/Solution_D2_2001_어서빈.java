package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_D2_2001_어서빈 {

	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int testcase = 1; testcase<=T; testcase++) {			
			// N : 파리 배열 크기 , M : 파리채 크기 M*M
			int n,m;
			n = sc.nextInt();
			m = sc.nextInt();
			int max = Integer.MIN_VALUE;
			// 파리 배열
			int[][] fly = new int [n][n];
			//					우, 하, 우하
			int [] dr = {1, 	0,  1};
			int [] dc = {0, 	1,  1};
			for(int i = 0 ; i<n; i++) {
				for(int j = 0; j < n; j++ ) {
					fly[i][j] = sc.nextInt();
				}
			}			
//								3,2
			for(int r = 0; r <= n-m; r++) {
				for(int c = 0; c <= n-m; c++) {
					int sum = 0;
					// 파리채로 잡기1      r+2
						for(int x = r; x < r+m; x++) {
							for(int y = c; y < c+m; y++) {
								sum += fly[x][y];
							}
						}
						max = Math.max(sum,max);
						//System.out.println(r+"\t"+c+"\t "+max);
					}
				}
			System.out.printf("#%d %d%n",testcase,max);
		}
//		"#1 49\r\n" + 
//		"#2 159\r\n" + 
//		"#3 428\r\n" + 
//		"#4 620\r\n" + 
//		"#5 479\r\n" + 
//		"#6 941\r\n" + 
//		"#7 171\r\n" + 
//		"#8 968\r\n" + 
//		"#9 209\r\n" + 
//		"#10 1242\r\n" + 
//		""
	}

}
