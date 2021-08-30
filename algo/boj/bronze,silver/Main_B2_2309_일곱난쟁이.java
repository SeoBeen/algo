package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B2_2309_일곱난쟁이 {
	private static int[] dwarfs = new int[9];
	private static int[] nums = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());			
		}
		combination(0,0);
		
	}
	private static void combination(int cnt, int start) {
//		기저 조건
		if(cnt == 7) {
			int sum=0;
			for(int i =0 ; i<7; i++) {
				sum += nums[i];
			}
			if(sum == 100) {
				Arrays.sort(nums);
				for(int i = 0; i<7; i++) {
					System.out.println(nums[i]);
				}
			}			
			return;
		}
		
		for(int i = start; i < 9; i++) {
			nums[cnt] = dwarfs[i];
			combination(cnt+1,i+1);
		}
	}
}
