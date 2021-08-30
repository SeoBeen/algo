package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum {
////							우, 하, 우하
//	private static int[] dr = { 0 , 1,  1};
//	private static int[] dc = { 1 , 0,  1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tcase = 1; tcase<=10; tcase++) {
			int t = Integer.parseInt(br.readLine());	// 테스트 케이스 번호
			int ans = Integer.MIN_VALUE;				// 최댓값
			int[][] arr = new int[100][100];
			
			for(int i = 0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int sum = 0;	// 각 값들의 합
			for(int r = 0; r<100; r++) {
				sum = 0;	// 각 값들의 합
//				가로 비교
				for(int c= 0; c< 100; c++) {
					sum += arr[r][c];
				}
				ans = Math.max(sum, ans);
				
				sum = 0;	// 각 값들의 합
//				세로 비교
				for(int c= 0; c< 100; c++) {
					sum += arr[c][r];
				}
				ans = Math.max(sum, ans);				
			}
			
//			우하 대각선 비교
			sum = 0;		// 각 값들의 합
			for(int r = 0; r<100; r++) {
				sum += arr[r][r];
			}
			ans = Math.max(sum, ans);
			
//			좌하 대각선 비교
			sum = 0;		// 각 값들의 합
			for(int r = 99; r>=0; r--) {
				sum += arr[r][r];
			}
			ans = Math.max(sum, ans);			
			System.out.println("#"+t+" "+ans);
		}
			
	}

}
