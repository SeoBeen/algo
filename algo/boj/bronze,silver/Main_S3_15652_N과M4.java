package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15652_N과M4 {
	private static int N,M;
	private static int[] nums;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		nums = new int[M];
		comb(0);
		System.out.println(sb);
	}
	private static void comb(int cnt) {
		if(cnt == M) {
			for(int val : nums) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i<=N;i++) {
			if(cnt != 0 && nums[cnt-1]> i) continue;
			nums[cnt] = i;
			comb(cnt+1);
		}
	}
}
