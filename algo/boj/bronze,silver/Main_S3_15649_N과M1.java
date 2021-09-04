package com.ssafy.boj;

import java.util.Scanner;

public class Main_S3_15649_N과M1 {
	private static int N;
	private static int R;
	private static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		num = new int[R];
		permutation(0,0);
	}
	private static void permutation(int cnt, int flag) {
		if(cnt == R) {
			for(int val : num) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= N; i++) {
//			중복체크
			if( (flag & 1 << i) == 0) {
				num[cnt] = i;
				permutation(cnt+1, flag | 1 << i);
			}
		}
	}

}
