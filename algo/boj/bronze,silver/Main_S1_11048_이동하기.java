package solved;

import java.util.*;
import java.io.*;

public class Main_S1_11048_이동하기 {
//							   우,하,우하
	private static int[] dr = { 0, 1, 1};
	private static int[] dc = { 1, 0, 1};
	private static int N,M;
	private static int[][] map,dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 우, 하, 우하 이동가능
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		dp[1][0] = map[0][0] + map[1][0];
		dp[0][1] = map[0][0] + map[0][1];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				for(int d = 0; d < 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					// 범위 안일때
					if(isIn(nr,nc) && nr-1 >=0 && nc-1 >=0) {
						System.out.println("좌표값 nr : "+ nr + " nc : "+ nc);						
						int max = map[nr][nc] + Math.max(dp[nr-1][nc], Math.max(dp[nr-1][nc-1], dp[nr][nc-1]));
						System.out.println("max 값 : "+max);
						dp[nr][nc] = Math.max(dp[nr][nc], max);
						System.out.println(dp[nr][nc]);
					}
				}
			}
		}
		
		for(int[] d : dp) {
			System.out.println(Arrays.toString(d));
		}
		
//		System.out.println(dp[N-1][M-1]);
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
