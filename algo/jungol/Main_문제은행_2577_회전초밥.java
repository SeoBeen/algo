package com.ssafy.webex.algo.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_문제은행_15961_회전초밥 {
	private static int N,d,k,c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	// 접시의 수
		d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		int ans = 0;
		
		int[] sushi = new int[N];	// 초밥 수
		int[] had = new int[d+1];	// 해당 초밥 먹었는지 확인
		for(int i = 0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		int start;
		for(start = 0 ; start < k; start++) {
//			아직 안먹어본 초밥임
			if(had[sushi[start]] == 0) {
				cnt++;
			}			
//			먹어본 초밥일 경우
			had[sushi[start]]++;
		}		
//		쿠폰 초밥을 아직 안먹어 봤을 경우
		if(had[c] == 0) {
			ans = cnt +1;
		} else {
			ans = cnt;
		}
		
//		슬라이딩 윈도우 시작
//		현재 start는 k, 원형 이기 때문에 N-1 + k
		while(start < N-1 + k) {
//			첫번째꺼 버리기,	원형이기 때문에 %N 필수
			had[sushi[(start-k)%N]]--;
			if(had[sushi[(start-k)%N]] == 0) {
				cnt--;
			}
//			다음꺼 먹기
			had[sushi[start %N]]++;
//			처음먹어본다면
			if(had[sushi[start% N]] == 1) cnt++;
			
//			쿠폰 체크						
			ans = Math.max(ans,had[c] == 0 ? cnt+1 : cnt);
//			다음으로 넘어가기
			start++;
		}
		
		System.out.println(ans);
	}// main

} // end class
