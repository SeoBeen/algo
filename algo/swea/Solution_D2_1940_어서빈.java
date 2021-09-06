package com.ssafy.swea;

import java.util.Scanner;

public class Solution_D2_1940_어서빈 {
	static int T;
	static int N;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int testcase = 1; testcase <=T; testcase++) {
			int distance = 0;
			int speed = 0;
			int ac = 0 ;
			// Command 수
			N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				// 선택
				int select = sc.nextInt();
				
				if(select == 1) {
					ac = sc.nextInt();
					speed += ac;
				} else if ( select == 2) {
					ac = sc.nextInt();
					speed -= ac;
				} else if(select == 0) {
					// 0일 경우 가속도 입력을 받지 않음.
				} 
				if(speed < 0 ) speed = 0;
				distance += speed;
			}
			System.out.println("#"+testcase+" "+distance);
		}		
	}

}
