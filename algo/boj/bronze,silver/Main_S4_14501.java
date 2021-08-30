package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_14501 {
	private static int N, max = Integer.MIN_VALUE;
	private static int[] T,P;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		기간
		T = new int[N];
//		금액
		P = new int[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		work(0,0);
		System.out.println(max);
	}
	private static void work(int day, int money) {
//		기저 조건 
//		마지막날 새로운 상담 불가능하기 때문에 =도 종료 조건으로 포함.
		if(day >= N) {
			max = Math.max(max, money);
			return;
		}
//		상담 할때 늦어도 마지막날에 끝나야 함.
		if(day + T[day] <= N) {
			work(day + T[day], money+P[day]);			
		}
//		상담 안할때
		work(day+1, money);		
	}
}
