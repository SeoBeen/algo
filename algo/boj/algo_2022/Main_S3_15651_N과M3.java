package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15651_N과M3 {

	private static int N,M;
	private static int[] arr;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		sb = new StringBuilder(); 
		permutation(0,0);
		System.out.println(sb);
	}
	private static void permutation(int num, int cnt) {
		// 기저조건
		if(cnt == M) {
			
			for(int n : arr) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			arr[cnt] = i;
			permutation(num, cnt+1);
		}
	}

}
