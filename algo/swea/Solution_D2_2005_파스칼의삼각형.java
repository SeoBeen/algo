package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_2005_파스칼의삼각형 {
	private static int T;		// 테스트 케이스 수
	private static int N;		// 삼각형의 크기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=T; tcase++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<=i; j++) {
//					각행의 맨 앞과 맨뒤
					if(j == 0 || j == i) arr[i][j] = 1;
//					맨 앞과 맨뒤가 아닐 경우
					else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}					
				}
			}
			System.out.println("#"+tcase);
			for(int r = 0; r<N; r++) {
				for(int c= 0; c<=r; c++) {
					System.out.printf("%d ",arr[r][c]);
				}
				System.out.println();
			}
		}		
	}
}
