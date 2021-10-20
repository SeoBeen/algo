package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_2115_벌꿀채취 {
	private static int T,N,M,C,ans;
	private static int[][] map,sumMap;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int tcase = 1; tcase<=T; tcase++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());	// 벌통 크기
			M = Integer.parseInt(st.nextToken());	// 벌통 개수
			C = Integer.parseInt(st.nextToken());	// 꿀 채취가능한 양
			map = new int[N][N];
			sumMap = new int[N][N];
			ans = 0;								// 답
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<= N-M; j++) {
//							좌표위치,뽑은갯수, 합(기저조건용), 제곱값 합
					powerset(i,j,     0,        0,              0);					
				}
			}
			
//			뽑은것들중 겹치지 않게 2개 뽑기
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<= N-M; j++) {
//					겹치지 않도록 j에 M을 더해준다.
					comb(i, j+M,   0, sumMap[i][j]);
				}
			}
			
			System.out.println("#"+tcase+" "+ans);			
		}// tcase for
	} // end main
	
	private static void comb(int i, int j, int cnt, int sum) {
//		기저 조건
		if(cnt == 1) {
			ans = Math.max(ans,sum);
			return;
		}
		
		for(int r = i; r <N; r++) {
			for(int c = j; c<=N-M; c++) {
				comb(r, c, cnt+1, sum + sumMap[r][c]);
			}
//			다음줄 처음부터
			j = 0;
		}
	}

	private static void powerset(int i, int j, int cnt, int sum, double tSum) {
//		기저조건
		if(sum > C) return;
//		벌통개수 만큼 채취
		if(cnt == M) {
//			맵에다 최댓값 저장하기. j 그대로 쓰면 j+1이 N값이 되어서 경계를 넘어버림. 시작위치에다가 합 저장.
			sumMap[i][j-M] = Math.max(sumMap[i][j-M], (int)tSum);
			return;
		}
		
//		현재위치 뽑기
		powerset(i,j+1,cnt+1,sum+map[i][j], tSum + Math.pow(map[i][j],2));
		
//		현재위치 안뽑기
		powerset(i,j+1, cnt+1, sum, tSum);
	}
	
	
} // end class
