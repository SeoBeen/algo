package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_1463_1로만들기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		for(int i = 2; i<= N; i++) {
			// -1일때
			nums[i] = nums[i-1] + 1;
			if(i % 2 == 0) {
				nums[i] = Math.min(nums[i],nums[i/2]+1);
			}
			if( i % 3 == 0) {
				nums[i] = Math.min(nums[i],nums[i/3]+1);
			}			
		}
		System.out.println(nums[N]);
	}

}
