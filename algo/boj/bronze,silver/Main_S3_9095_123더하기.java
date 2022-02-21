package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_9095_123더하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Testcase = Integer.parseInt(br.readLine());
		
		int[] nums = new int[12];
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 4;
		
		for(int i =4 ;i < 11; i++) {
			nums[i] = nums[i-1] + nums[i-2] + nums[i-3];
		}
		
		for(int i = 0 ; i<Testcase; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(nums[num]);
		}
	}

}
