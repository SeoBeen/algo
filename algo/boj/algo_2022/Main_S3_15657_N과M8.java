package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_15657_N과M8 {

	private static int N,M;
	private static int[] arr, input;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		arr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		permutation(0, 0);
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
		for(int i = num; i < N; i++) {
			arr[cnt] = input[i];
			permutation(i, cnt+1);
					
		}
	}

}
