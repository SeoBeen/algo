package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2156_포도주시식 {
	private static int n,ans;
	private static int[] arr,dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(n == 1) {
			System.out.println(arr[0]);
		} else if(n == 2) { 
			System.out.println(arr[0]+arr[1]);
		} else {
			dp[0] = arr[0];
			dp[1] = arr[0]+arr[1];
//							OOX, 					OXO,		 XOO
			dp[2] = Math.max(dp[1], Math.max(dp[0]+arr[2],arr[1]+arr[2]));
			for(int idx=3; idx<n; idx++) {
//										OOX, 		       OXO, 			XOO
				dp[idx] = Math.max(dp[idx-1],Math.max(dp[idx-2]+arr[idx],dp[idx-3]+arr[idx-1]+arr[idx]));
			}
			System.out.println(dp[n-1]);		
		}
	}
}
