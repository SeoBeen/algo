package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1629_곱셈 {
	private static int A,B,mod;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());	// 밑
		B = Integer.parseInt(st.nextToken());	// 지수
		mod = Integer.parseInt(st.nextToken());	// 제수
		
		long ans = 1;
		long multiply = A % mod;
		
		while(B > 0) {
			if(B%2 == 1) {
//				홀수일경우 mulyiply * multiply * A 에서 A에 해당하는 ans을 미리 곱해준 상태.
				ans *= multiply;
				ans %= mod;
			}
			multiply = ((multiply%mod) *(multiply%mod))%mod;
			B>>=1;
		}
		System.out.println(ans);
	}

}
