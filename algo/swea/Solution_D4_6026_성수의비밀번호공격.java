package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_6026_성수의비밀번호공격 {
	private static int T,M,N;
	private static int MOD = 1000000007;
	
	private static long[] fac;
	
//	매번 동일한 값이기 때문에 한번만 구해놓고 사용하기.
	static void pre() {
		fac = new long[101];
		fac[0] = fac[1] = 1;
		for(int i = 2; i<fac.length; i++) {
			fac[i] = (fac[i-1]*i) % MOD;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=T; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			pre();
			
			long result = solve();
			
			System.out.println("#"+tcase+" "+ result);
		}// tcase for
	}// main
	
//	함수의 개수 : ∑(-1)^i * kCi * (k-i)^n
	private static long solve() {
		long total = 0;
		for(int i = 0; i<= M; i++) {
			long l1 = i % 2 == 0 ? 1 : -1;  // (-1)^i
			long l2 = nCr(i);				// kCi
			long l3 = pow(M-i, N);			// (k-i)^n
			long result = ((l1*l2)%MOD*l3) %MOD;
			
			total = (total + result + MOD) %MOD;
		}
		return total;
	}
	
//	nCr = ( n! / ((n-r)! * r!) ) % MOD
//	분배법칙 적용 : ( n! * ((n-r)! * r!)^(mod-2)  ) % MOD
	static long nCr(int r) {
		if(r == 0) {
			return 1;
		}
		
		long l1 = fac[M];
		long l2 = pow(fac[M-r], MOD-2);
		long l3 = pow(fac[r], MOD-2);
				
		return ((l1 * l2)%MOD * l3) %MOD;
	}
	
	static long pow(long a, int b) {
		if(b == 1) {
			return a;
		}
		
		long half = pow(a, b/2);
		
		if(b % 2 == 0) {
			return (half * half) % MOD;
		}
		else {
//			나머지 연산의 분배 법칙
			return ((half * half)%MOD * (a)%MOD) % MOD;
		}		
	}

}// end class
