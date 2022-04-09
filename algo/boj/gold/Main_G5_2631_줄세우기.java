package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G5_2631_줄세우기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] dp = new int[N];
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && dp[j] +1 > dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			max = Math.max(max,dp[i]);
		}
		System.out.println(N-max);
	}

}
