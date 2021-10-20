package com.ssafy.swea;

import java.util.Scanner;
import java.util.Arrays;

public class Solution_D2_1954_달팽이숫자 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int test_case = sc.nextInt();
		
		for (int i = 1; i <= test_case; i++ ) {
			//달팽이의 크기
			int N = sc.nextInt();
			
			// 달팽이 생성
			int [][] snail = new int[N][N];
			// 달팽이에 저장할 값
			int num = 1;
			//방향값(1씩 증가 or 1씩 감소)
			int dir = 1;
			
			// 총움직이는수 = 2N-1; 
			
			// c가 0부터 시작시 IndexOutOfBoundException
			int r =0 , c = -1;
			while(true) {
				// r값이 같을때
				for(int j = 0; j < N; j++ ) {
					c +=dir;
					snail[r][c] = num;
					num++;
				}
				N--;
				// c값이 같을때
				for(int j = 0; j < N; j++) {
					r += dir;
					snail[r][c] = num;
					num++;
				}
				dir *= -1;
				if(N == 0 ) break;
			}
			
			// 모아서 출력
			System.out.println("#"+i);
			for ( int[] x : snail) {
				for(int y : x) {
					System.out.print(y + " ");
				}
				System.out.println();
			}
		}
	}
}
