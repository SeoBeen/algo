package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_16174_점프왕쩰리_DP {
//							  우, 하
	private static int[] dr = {0, 1};
	private static int[] dc = {1, 0};
	private static int N;
	private static int[][] map;
	private static int[][] dp;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				for(int d = 0; d<2; d++) {
					if(dp[r][c] != 0 && isIn(r + map[r][c] * dr[d], c + map[r][c] * dc[d])) {
						dp[r + map[r][c] * dr[d]][c + map[r][c] * dc[d]]++;						
//					System.out.println("현재 위치 - r : "+ r + " c : "+ c);
//					System.out.println("이동 가능 위치 nr : "+ (r + map[r][c]*dr[d]) 
//							+ " nc : "+ (c + map[r][c]* dc[d]));
//					System.out.println();
					}
				}
			}
		}
		
		if(dp[N-1][N-1] == 0) System.out.println("Hing");
		else System.out.println("HaruHaru");
//		for(int[] d : dp) {
//			System.out.println(Arrays.toString(d));
//		}
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r< N && c >=0 && c<N;
	}

}
