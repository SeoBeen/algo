package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15651_N과M3 {
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
		sb = new StringBuilder();
		permu(0);
		System.out.println(sb);
	}
	private static void permu(int cnt) {
//		기저조건
		if(cnt == M) {
			for(int val : nums) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=N; i++) {
			nums[cnt] = i;
			permu(cnt+1);
		}
	}
}
