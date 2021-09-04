package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_2751_수정렬하기2 {
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
//		절대값 1000000 까지 => -1000000 ~ 1000000 중간에 0 총 2백만 1개
		boolean num[] = new boolean[20000001];
		
		for(int i = 0; i < N; i++) {
//			1 => 인덱스값 1000001
			num[Integer.parseInt(br.readLine())+1000000] = true;
		}
		
		for(int j = 0 ; j < num.length; j++) {
			if(num[j]) {
				sb.append(j-1000000).append("\n");
			}
		}
		System.out.print(sb);
	}
}
