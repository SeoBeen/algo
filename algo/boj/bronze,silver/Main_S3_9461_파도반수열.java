package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_9461_파도반수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		long[] nums = new long[102];
		nums[1] = 1;
		nums[2] = 1;
		nums[3] = 1;
		nums[4] = 2;
		nums[5] = 2;
		for(int i = 6; i<102; i++) {
			nums[i] = nums[i-1] + nums[i-5];
		}
		
		for(int tcase = 0 ; tcase<testCase; tcase++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(nums[N]);
		}
	}

}
