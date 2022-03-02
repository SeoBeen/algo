package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_11726_2xn타일링 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[1002];
		nums[1] = 1;
		nums[2] = 2;
		for(int i = 3; i<= N; i++) {
			nums[i] = (nums[i-1] + nums[i-2]) % 10007;			
		}
		System.out.println(nums[N]);
	}

}
