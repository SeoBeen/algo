package com.ssafy.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_어서빈 {
		
	public static void main(String [] args) {
		
		int test_case = 10;
		int[] box = new int[100];
		// 높이차
		int gap = 0;
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i<= test_case; i++) {
			// 덤프 횟수 입력
			int dCnt = sc.nextInt();
			
			if(dCnt >=1 && dCnt<= 1000) {
				// 상자 높이 입력
				for(int j = 0; j < 100; j++) {
					box[j] = sc.nextInt();
				}
				
				while( dCnt-- >= 0 ) {
					Arrays.sort(box);
					if( box[0] >=1 && box[box.length-1] <= 100) {
						gap = box[box.length-1] - box[0];
						if(gap <= 1) break;
						box[box.length-1]--;
						box[0] ++;
					}
				}
				System.out.println("#"+i+" "+gap);
			}
		}
	}
}
