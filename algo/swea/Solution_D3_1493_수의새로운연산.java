package com.ssafy.afterclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1493_수의새로운연산 {
	
	private static int T;
	private static int p, q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=T; tcase++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());	// 첫번째 좌표
			q = Integer.parseInt(st.nextToken());	// 두번째 좌표
			
			int[] pArr = getPoint(p);
			int[] qArr = getPoint(q);
			
			int[] sumArr = {pArr[0] + qArr[0] , pArr[1] + qArr[1]};
			ans = getSum(sumArr);
			System.out.printf("#%d %d%n",tcase,ans);
		}		
	}
//	좌표 구하기
	public static int[] getPoint(int point) {
		int cnt = 1;
		for(int i = 1; ; i++) {
//			좌측 위부터 우하 방향으로 진행
			for(int j = 1, k = i;j<=i; j++, k--) {
				if(point == cnt) {
					return new int[] { j,k};
				}
				cnt ++;
			}
		}
	}
	
	public static int getSum(int[] point) {
		int cnt = 1;
		for(int i=1;;i++) {
			for(int j = 1,k = i; j <=i; j++,k--) {
//				j = x좌표, k = y좌표
				if(j == point[0] && k == point[1]) {
					return cnt;
				}
				cnt++;
			}
		}
	}

}
