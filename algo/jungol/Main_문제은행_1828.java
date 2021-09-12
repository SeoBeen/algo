package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main_문제은행_1828 {
	static class Ref implements Comparable<Ref>{
		int minTemp;
		int maxTemp;
		
		public Ref(int minTemp, int maxTemp) {
			super();
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
		}
		@Override
		public int compareTo(Ref o) {
			if(this.maxTemp == o.maxTemp) return this.minTemp - o.minTemp;
			return maxTemp - o.maxTemp;
//			int temp = minTemp - o.minTemp;
//			if(temp == 0) { temp = maxTemp - o.maxTemp;
//			return temp;
		}
	}
	
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Ref> list = new ArrayList<>(N);
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
//		최저온도 기준 오름차순 정렬
		Collections.sort(list);
//		for(Ref x : list) {
//			System.out.println(x.minTemp);
//		}
		int mTemp = list.get(0).maxTemp; 
		for(int i = 1; i<N; i++) {
			if(mTemp < list.get(i).minTemp) {
				mTemp = list.get(i).maxTemp;
				ans++;
			}
		}
		System.out.println(ans);
	}	
}
