package com.ssafy.boj;

import java.util.Scanner;

public class Main_B2_7482_어서빈 {
	private static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 0; i<N; i++) {
			double num = sc.nextDouble();
			System.out.printf("%.10f\n",num/6);
		}
	}

}
