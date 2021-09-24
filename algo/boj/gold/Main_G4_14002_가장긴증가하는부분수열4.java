package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 *  1. 문제를 보고 생각난 아이디어
 *   - 수열 크기 : LIS 사용
 *   - 해당 수열 출력 : 크기값을 저장할때 해당 배열의 인덱스 값을 따로 저장해서 인덱스에 해당하는 배열을 다시 출력한다
	2. 문제를 풀면서 바뀐 아이디어
	 - 인덱스로 배열에 해당하는 값 부를시 역순(내림차순)으로 값들이 나오기 때문에 스택 사용.
	3. 최종적으로 사용된 아이디어
 */
public class Main_G4_14002_가장긴증가하는부분수열4 {
	private static int N,cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];	// 입력값
		int[] LIS = new int[N];		// 수열 개수 저장배열
		Stack<Integer> stack = new Stack<>();	
		int[] idx = new int[N];		// 수열 인덱스 저장
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int max = 1;
		int maxIdx = 0;
		for(int i = 0; i< N; i++) {
			LIS[i] = 1;
			idx[i] = -1;
			for(int j = 0; j<i; j++) {
				if(nums[j] < nums[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
					idx[i] = j;		// 배열에 들어가는 인덱스 저장
				}
			}
			if(max < LIS[i]) {
				max = LIS[i];
				maxIdx = i;
			}
		}
//		수열 길이
		System.out.println(max);
		
		StringBuilder sb = new StringBuilder();
//		배열 인덱스 값으로 부분수열에 들어가는 값 구하기
		while(maxIdx != -1) {
			stack.push(nums[maxIdx]);
			maxIdx = idx[maxIdx];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
//		System.out.println(Arrays.toString(idx));
		System.out.println(sb);
	}
}
