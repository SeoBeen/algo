package solved;

import java.util.*;
import java.io.*;

public class Main_S1_11048_이동하기_30후 {
	private static int N,M;
	private static int[][] map,dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 1<= N, M < 100
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 우, 하, 우하 이동가능
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = map[1][1];
		if(N > 1) {
			dp[2][1] = map[1][1] + map[2][1];						
		}		
		if(M > 1) {
			dp[1][2] = map[1][1] + map[1][2];
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				int max = map[r][c] + Math.max(dp[r-1][c], Math.max(dp[r-1][c], dp[r][c-1]));
				dp[r][c] = Math.max(dp[r][c], max);
//				System.out.println("좌표값 nr : "+ nr + " nc : "+ nc);						
//				System.out.println("max 값 : "+max);
//				System.out.println(dp[nr][nc]);
			}
		}
		
//		for(int[] d : dp) {
//			System.out.println(Arrays.toString(d));
//		}
		System.out.println(dp[N][M]);
	}

}
