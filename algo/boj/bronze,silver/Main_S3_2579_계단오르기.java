package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_2579_계단오르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[301];
		int[] dp = new int[301];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
		}
		
		// 1개
		dp[0] = arr[0];
		// 2개 연속
		dp[1] = arr[0] + arr[1];	
		dp[2] = Math.max(arr[0],arr[1]) + arr[2];		
		
		for(int i = 3; i<N; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
		}
		System.out.println(dp[N-1]);
		
	}

}
