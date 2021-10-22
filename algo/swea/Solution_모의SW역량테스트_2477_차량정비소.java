package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_2477_차량정비소 {
	private static int T,N,M,K,A,B,ans;	
	private static int[] reception, repair;
	
	private static class person implements Comparable<person> {
		int 
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tcase = 1; tcase<=T; tcase++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());	// 접수 창구 개수
			M = Integer.parseInt(st.nextToken());	// 정비 창구 개수
			K = Integer.parseInt(st.nextToken());	// 고객수
			A = Integer.parseInt(st.nextToken());	// 찾을 접수 창구 번호
			B = Integer.parseInt(st.nextToken());	// 찾을 정비 창구 번호
//			창구 번호들은 1부터 시작한다.
			ans = 0;
			
			reception = new int[N+1];	// 접수
			repair = new int[N+1];		// 정비
//			접수 소요시간
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <=N; i++) {
				reception[i] = Integer.parseInt(st.nextToken());
			}
//			수리 소요시간
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <=M; i++) {
				repair[i] = Integer.parseInt(st.nextToken());
			}
			
//			도착 시간
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i<=K; i++) {
				
			}
			
			
			System.out.println("#"+tcase+" ");
		} // tcase for
	} // end main

} // end class
