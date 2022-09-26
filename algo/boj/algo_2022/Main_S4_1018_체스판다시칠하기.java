package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1018_체스판다시칠하기 {

	private static int N, M, min = 64;
	private static boolean[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			for(int c = 0; c < M; c++) {
				if(str.charAt(c) == 'W') {
					map[r][c] = true; // W => true
				} else {
					map[r][c] = false; // B => false
				}
			}
		}		
		
		int mRow = N - 7;
		int mCol = M - 7;
		
		for(int i = 0 ; i < mRow; i++) {
			for(int j = 0; j < mCol; j++) {
				find(i,j);
			}
		}
		System.out.println(min);
				
	}

	private static void find(int r, int c) {
		int endRow = r + 8;
		int endCol = c + 8;
		int count = 0;
		
		boolean color = map[r][c]; // 첫 번째 색
		
		for(int i = r; i < endRow; i++) {
			for(int j = c; j < endCol; j++) {
				
				// 올바른 색이 아니면 count 1 증가
				if(map[i][j] != color) {
					count++;
				}
				// 이전과 색상 변경
				color = !color;
			}
			color = !color;
		}
		
		count = Math.min(count, 64 - count);
		
		min = Math.min(min, count);
	}

}
