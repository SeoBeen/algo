package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_11659_구간합구하기4 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 수의 개수
		int N = Integer.parseInt(st.nextToken());
		// 합을 구해야 하는 횟수
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		int[] sNums = new int[N+1];
		sNums[0] = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i =1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sNums[i] = nums[i] + sNums[i-1];
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sIdx = Integer.parseInt(st.nextToken());
			int eIdx = Integer.parseInt(st.nextToken());
			System.out.println(sNums[eIdx] - sNums[sIdx-1]);
		}		
	}

}
