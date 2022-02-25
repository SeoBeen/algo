package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S5_11723_집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hash = new HashMap<>();
		int[] nums = new int[21];
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			if(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());				
			}
//			System.out.println(op + " " + num);
			switch(op) {
			case "add" :
				nums[num] = 1;
				break;
			case "remove" :
				nums[num] = 0;
				break;
			case "check" :
				sb.append(nums[num]).append("\n");
				break;
			case "toggle" :
				nums[num] = nums[num] == 1 ? 0 : 1;
				break;
			case "all" :
				Arrays.fill(nums, 1);
				break;
			case "empty" :
				Arrays.fill(nums, 0);
				break;
			}
		}
		System.out.println(sb);
	}

}
