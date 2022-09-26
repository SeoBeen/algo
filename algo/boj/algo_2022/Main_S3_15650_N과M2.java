package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15650_N과M2 {
	
	private static int N, M;
	private static int[] arr;
	private static boolean[] isVisited;	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		isVisited = new boolean[N+1];
		permutation(1,0);		
	}

	private static void permutation(int num, int cnt) {
		// 기저조건
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int n : arr) {
				sb.append(n+" ");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i = num; i <= N; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			arr[cnt] = i;
			permutation(i+1, cnt+1);
			isVisited[i] = false;
		}
	}
}
