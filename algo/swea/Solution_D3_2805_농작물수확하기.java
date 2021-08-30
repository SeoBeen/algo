package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_2805_농작물수확하기 {
	private static int T;		// 테스트 케이스 수
	private static int N;		// 농장의 크기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tcase = 1; tcase<= T; tcase++) {
			N = Integer.parseInt(br.readLine());
			int sum = 0;							// 농작물 합계
			char[][] arr = new char[N][N];
			for(int i = 0; i<N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
//			위쪽 삼각형
			for(int r = 0 ; r<=N/2; r++) {
				for (int c = N/2-r; c <= N/2+r; c++) {
					sum += arr[r][c]-'0';
				}
			}
			
//			아래쪽 삼각형
			for(int r = N/2; r>0; r--) {
				for(int c = N/2-r+1; c<N/2+r; c++) {
					sum += arr[N-r][c]-'0';
				}
			}
			System.out.println("#"+tcase+" "+sum);
			
		}
	}

}
