package nprpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1149_RGB거리 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		for(int i = 1; i<= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			// red
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
			// green
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
			// blue
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + map[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));
		
	}

}
