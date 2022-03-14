package nprpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_N과M5 {

	private static int N,M;
	private static boolean[] visited;
	private static int[] nums,answer;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		visited = new boolean[N];
		answer = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		for(int i = 0; i< N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		NandM(0);
		System.out.println(sb.toString());
	}

	private static void NandM(int cnt) {
		// 기저 조건
		if(cnt == M) {			
			for(int n : answer) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[cnt] = nums[i];
				NandM(cnt+1);
				visited[i] = false;
			}
		}
	}

}
