package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_2999_비밀이메일 {
	private static int N,R,C;
	private static char[] chr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chr = br.readLine().toCharArray();
		N = chr.length;
		for(int i = 1; i< N; i++) {
			if(N %i ==0 && i <= N/i) {
				R = i;
				C = N/i;				
			}
		}		
		if(R==0 && C==0) {
			R=1;
			C=1;
		}
		int idx = 0 ;
		char[][] map = new char[R][C];
		for(int i = 0; i < C; i++) {
			for(int j = 0; j<R; j++) {
				map[j][i] = chr[idx++];
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char[] c : map) {
			sb.append(c);
		}
		System.out.println(sb);		
	}
}
