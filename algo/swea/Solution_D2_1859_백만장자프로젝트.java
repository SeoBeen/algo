package com.ssafy.afterclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {
	private static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=T; tcase++) {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int temp = num[N-1];
			long ans = 0;
			for(int i = N-2; i>=0; i--) {
				if(num[i] < temp) {
					ans += temp - num[i];					
				} else {
					temp = num[i];
				}
			}		
			System.out.println("#"+tcase+" "+ans);
		}
	}//main
}//class
