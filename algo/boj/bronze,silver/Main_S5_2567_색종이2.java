package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_2567_색종이2 {
	private static int N;	// 색종이 수
	private static int[][] map;
//								상, 우, 하, 좌
	private static int[] dr = { -1,  0, 1,  0};
	private static int[] dc = {  0,  1, 0,  -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // 색종이 수
		map = new int[101][101];
		int perimeter = 0;					// 둘레
		for(int i = 0; i< N; i++) {
//			자 연 수	자 연 수 	자 연 수	자 연 수
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int c = Integer.parseInt(st.nextToken());	// 왼쪽 변과의 거리 => 열 
			int r = Integer.parseInt(st.nextToken());	// 아래쪽 변과의 거리 => 행
			for(int j = r; j< r+10; j++) {
				for(int k = c; k < c+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int r = 1 ; r<=100; r++) {
			for(int c = 1 ; c<= 100; c++) {
//				4방 탐색 시작
				if(map[r][c] == 1) {					
					for(int d = 0; d<dr.length; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
//					도화지 범위를 벗어나거나 탐색한 곳의 값이 1이면 막혀있음
//							if(!isIn(nr,nc) || map[nr][nc] == 1) continue;
							
//					경계를 벗어나지 않고 값이 0 이다 => 둘레에 포함
							if(map[nr][nc] == 0 ) {
								perimeter++;
							}						
						}
					}
				}
			}
		System.out.println(perimeter);
	}	// main
	
	private static boolean isIn(int r, int c) {
		return r >0 && r <= 100 && c >0 && c <= 100;
	}
	
}// class end
