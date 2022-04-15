package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S1_14888_연산자끼워넣기 {

	private static int N, max = Integer.MIN_VALUE ,min = Integer.MAX_VALUE;
	private static int[] nums, operations;
	private static char[] op = {'+','-','*','/'}, selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		operations = new int[4];
		selected = new char[N-1];
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		input = br.readLine().split(" ");
		for(int i = 0; i < 4; i++) {
			operations[i] = Integer.parseInt(input[i]);
		}
		
		operate(0,0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void operate(int idx, int cnt) {
		// 기저조건
		if(cnt == N-1) {
			int ans = nums[0];
			for(int i = 0; i < N-1; i++) {
				if(selected[i] == '+') {
					ans += nums[i+1];
				}
				else if(selected[i] == '-') {
					ans -= nums[i+1];
				}
				else if(selected[i] == '*') {
					ans *= nums[i+1];
				}
				else if(selected[i] == '/') {
					ans /= nums[i+1];
				}
			}
			max = max < ans ? ans : max;
			min = min > ans ? ans : min;
			return;
		}
		
		for(int i = idx; i < 4; i++) {
			if(operations[i] != 0) {
				selected[cnt] = op[i];
				operations[i]--;
				operate(idx, cnt+1);
				operations[i]++;
			}
		}
	}

}
