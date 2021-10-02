package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_4014_활주로건설 {
	private static int T,N,X,ans;
	private static int[][] map,map2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tcase = 1; tcase<=T; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 지형의 크기
			X = Integer.parseInt(st.nextToken());	// 경사로 길이
			map = new int[N][N];
			map2 = new int[N][N];
			ans = 0;
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<N; j++) {
//					가로방향
					map[i][j] = Integer.parseInt(st.nextToken());
//					세로방향 
					map2[j][i] = map[i][j];
				}
			}
			for(int i = 0; i<N; i++) {
				buildLanding(map,i);		
				buildLanding(map2,i);		
			}
		
			System.out.println("#"+tcase+" "+ans);
		}// tacse for
		
	} // main

	private static void buildLanding(int[][] curMap, int idx) {
//		첫 기준 값
		int first = curMap[idx][0];
//		기준값과 같은 수
		int cnt = 1;
		
		for(int i = 1; i<N; i++) {
//			값이 같다면 카운트
			if(first == curMap[idx][i]) {
				cnt++;
			}
//			값이 다르다 ==> 경사로 건설 (좌 -> 우)
			else if( curMap[idx][i] - first == 1) {
//				경사로 만큼의 이전 길이가 안된다면 통과
				if(cnt < X) {
					return;
				}
//				cnt >= X 경사로 건설함.
				else {
//					여기서 경사로 생겼다고 끝내면 안됨 => 해당 라인 전부가 이어져 있어야 함.
					cnt = 1;
					first = curMap[idx][i];
				}
			}
//			역방향 건설 ( 우 -> 좌)
			else if (first - curMap[idx][i] == 1) {
//				경계 벗어날경우 패스
//				건설시 현재 위치부터 건설하기 때문에 같을 경우도 가능.
				if(N < X +i) {
					return;
				}
//				오른쪽들이 건설할만큼 연속되는지 체크
//				인덱스가 i인것은 이미 포함 => 그 뒤 부터 탐색.
				for(int j = 1; j<X; j++) {
					i++;
					if( first - curMap[idx][i] != 1) {
						return;
					}
				}
//				경사로 건설
				first = curMap[idx][i];
//				경사로를 건설한 곳이기 때문에 위에 또 못지음. cnt를 1로 시작하면 안됨.
				cnt = 0;
			}
//			그 이외에 2이상 차이나는 경우 패스
			else {
				return;
			}
		}
		ans++;
	} // buildLanding

} // end class
