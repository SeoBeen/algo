package com.ssafy.boj;

import java.util.Scanner;
import java.util.Stack;

public class Main_S3_1874_스택수열 {
	static int n;
	static int[] arr;
	static Stack<Integer> numbers = new Stack<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		arr = new int[n];
		for(int i = 0; i< n; i++) {
			arr[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(arr));
		int idx = 0;
		int cnt = 1;
		while(idx < n) {
			if( arr[idx] >= cnt) {
				numbers.push(cnt);
				sb.append("+\n");
				cnt++;
			}
			if(arr[idx] == numbers.peek()) {
				numbers.pop();
				sb.append("-\n");
				idx++;
			} 
			else if(arr[idx] < numbers.peek()) {
				System.out.println("NO");
				return;
			}			
		}
		System.out.println(sb);
		sc.close();
	}

}
