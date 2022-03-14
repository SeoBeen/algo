package nprpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_N과M4 {

	private static int N,M;
	private static boolean[] visited;
	private static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		
		NandM(1,0);
	}

	private static void NandM(int start, int cnt) {
		// 기저 조건
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int n : nums) {
				sb.append(n + " ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i = start; i<=N; i++) {
				nums[cnt] = i;
				NandM(i, cnt+1);
		}
	}

}
