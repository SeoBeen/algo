package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15650_N과M2 {
	private static int N, M;
	private static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		permutation(0,1);
	}
	private static void permutation(int cnt, int start) {
//		기저 조건
		if(cnt == M) {
			for(int num : numbers ) {
				System.out.printf(num+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i<= N; i++) {			
			numbers[cnt] = i;
			permutation(cnt+1, i+1);
		}
		
	}

}
