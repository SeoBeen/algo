package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15649_N과M {
	private static int N,M;
	private static int[] nums;
	private static boolean[] isSelected;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		isSelected = new boolean[N+1];
		permu(0);
	}
	private static void permu(int cnt) {
//		기저조건
		if(cnt == M) {
			sb = new StringBuilder();
			for(int val : nums) {
				sb.append(val + " ");
			}
			System.out.println(sb.toString());
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(isSelected[i]) continue;
			nums[cnt] = i;
			isSelected[i] = true;
			permu(cnt+1);
			isSelected[i] = false;
		}
	}
}
