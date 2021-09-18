package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B1_3985_롤케이크 {
	public static class Person {
		int no;
		int P;
		int K;
		public Person(int no, int p, int k) {
			super();
			this.no = no;
			P = p;
			K = k;
		}		
	}
	private static int L,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		LinkedList<Person> list = new LinkedList<Person>();
		
		for(int i = 1; i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Person(i,
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		int num = list.get(0).K - list.get(0).P;
		int expectNum = list.get(0).no;
		for(int i = 1; i<N; i++) {
			if(num < list.get(i).K - list.get(i).P) {
				num = list.get(i).K - list.get(i).P;
				expectNum = list.get(i).no;
			}
		}
		int[] cake = new int[L+1];
		int[] cnt = new int[N+1];
		Arrays.fill(cake,0);
		for(int i = 0; i<N; i++) {
			for(int j = 1; j<= L; j++) {
				if(cake[j] == 0) {
					if(list.get(i).P <= j && list.get(i).K >= j ) {
						cake[j] = list.get(i).no;
						cnt[list.get(i).no] ++;
					}
				}
			}
		}
		int realNum = 1;
		int realNumcnt = cnt[1];
		for(int i = 1; i < cnt.length; i++) {
			if(cnt[i] > realNumcnt) {
				realNumcnt = cnt[i];
				realNum = i;
			}
		}
//		System.out.println(Arrays.toString(cake));
//		System.out.println(Arrays.toString(cnt));
		System.out.println(expectNum);
		System.out.println(realNum);
	}

}
