package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15652_N과M4 {
	
	private static int N,M;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		permutation(1,0);
		System.out.println(sb);
	}

	private static void permutation(int num, int cnt) {
		// 기저조건
		if(cnt == M) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = num; i <= N; i++) {
			arr[cnt] = i;
			permutation(i, cnt+1);
		}
	}

}
