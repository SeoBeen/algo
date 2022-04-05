package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1932_정수삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(n >= 2) {
			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			dp[1][1] = map[1][1];
			for(int i = 1; i < n; i++) {
				
			}
		}
		if(n == 1) {
			System.out.println(map[0][0]);
			return;
		}
		
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[n-1][i]);
		}
		System.out.println(ans);
	}

}
