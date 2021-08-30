package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic {
	private static int N;
	private static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tcase = 1; tcase <=10; tcase++) {
			int cnt = 0;		// 교착상태 개수
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0 ; i< N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			1(빨간 자성체)일 경우 true;
			boolean chk = false;
//			위에서 아래로 열 기준 반복문 r 과 c 위치 바꿈
			for(int c = 0 ; c<N; c++) {
				for(int r = 0; r< N; r++) {
//					0이면 아무것도 아님
					if(map[r][c] == 0) continue;
//					1이면 체크
					if(map[r][c] == 1) {
						chk = true;
					}
//					1(N극)을 만난 상태에서 2(S극)를 만나면 교착상태
					if(map[r][c] == 2 && chk) {
						cnt++;
						chk = false;
					}
				}
//				열 단위로 하기때문에 끝나면 초기화
				chk = false;
			}
			System.out.println("#"+tcase+" "+cnt);
		}		
	}
}
