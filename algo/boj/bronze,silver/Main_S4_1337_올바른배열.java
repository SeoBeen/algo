package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_1337_올바른배열 {
	private static int N;
	private static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		1 <= N <= 10000
		N = Integer.parseInt(br.readLine());
//		배열의 생성
		nums = new int[N];		
		for(int i = 0; i <N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
//		연속된 원소수
		int cnt = 0;
//		마지막 수 (처음수 +4)
		int lastNum = 0;
		int max = Integer.MIN_VALUE;
//		배열의 크기가 5보다 작으면 반복문 한번에 끝낸다.
		int endIdx = N < 5 ? 1 : N;
		
		for(int i = 0; i< endIdx; i++) {
			lastNum = nums[i] +4;
//			j < N-i ==> 현재 비교하는 인덱스 i부터 뒤에 남은 배열의 개수만큼 비교하기 위해
			for(int j = 0; j< N-i; j++) {
				int preNum = nums[i+j];
//				반복문 동안 마지막 숫자가 이전의 숫자 즉 인덱스가 i부터 시작한 숫자보다 같거나 크면
//				연속될 수 있는 범위안에 있음 ==> cnt 1씩 증가
				if(lastNum >= preNum) {
					cnt++;				
				}
//				여기로 떨어짐 ==> 비교하는 숫자가 현재 i번째 숫자에서 최대로 연속하는 +4보다 큼
//				j for문 종료 다음 i값 으로 넘어감.
				else {
					break;
				}
			}
//			각 j반복문에서 나오는 최대 연속 횟수를 max에 저장한다.
			max = max < cnt ? cnt : max;
//			다시 cnt 초기화
			cnt = 0;
		}
		
		System.out.println(5-max);
		
	}// main
}// end class
