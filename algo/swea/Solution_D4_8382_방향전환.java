package com.ssafy.swea;

import java.util.Scanner;

public class Solution_D4_8382_방향전환 {
	private static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tcase=1; tcase<=T; tcase++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int X = Math.abs(x1-x2);
			int Y = Math.abs(y1-y2);
			int maxX = Math.max(X,Y);
			int Kun = X+Y; // 군 (Kun/2, Kun/2)
			int ans = 0;
//			짝수
			if(Kun % 2 == 0) {
				ans = 2 * Kun; 
			}
//			홀수
			else {
				ans = 2 * Kun - 1;
			}
			int diff = (Kun-maxX)*2;	// 군 에서 중앙을 향해 한칸 이동할 때마다 2씩 줄어듬.
			ans -= diff;
			System.out.println("#"+tcase+" "+ ans);
		}
	}// main
}
