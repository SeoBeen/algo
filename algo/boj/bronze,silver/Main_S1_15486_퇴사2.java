package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_15486_퇴사2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+2][2];
		int[] ans = new int[N+2];
		
		for(int i = 0; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i = 1; i< N+1; i++) {
			// 현재 시점까지의 최대수익
			if(max < ans[i]) {
				max = ans[i];
			}
			if(i + dp[i][0] < N+2) {
				ans[i+dp[i][0]] = Math.max(ans[i+dp[i][0]], max + dp[i][1]);
			}
		}
		System.out.println(Arrays.toString(ans));
	}
}
