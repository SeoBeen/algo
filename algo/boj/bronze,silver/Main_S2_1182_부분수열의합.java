package study.boj.prepareExam;

import java.util.Scanner;
/**
 *	1. 문제를 보고 생각난 아이디어
 *  - 부분집합 합 구하듯이 하면 될듯. but 백트래킹 연습 필요 dfs 이용
 *  - 여기서 백트래킹을 어떻게 쓰나? ==> 만약 값들이 양수만 이루어져있으면 가능 but 음수 포함이라 의미가 없을듯?
 *  
	2. 문제를 풀면서 바뀐 아이디어
	
	3. 최종적으로 사용된 아이디어 
 *
 */
public class Main_S2_1182_부분수열의합 {
	private static int N,S;
	private static int cnt;
	private static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		정수 개수
		N = sc.nextInt();
//		합
		S = sc.nextInt();
		nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		dfs(0,0);
		sc.close();
//		합이 0인경우에 모든걸 미포함 하는 초기값 0도 cnt가 증가함.
		if(S == 0) cnt--;
		System.out.println(cnt);
	}
	private static void dfs(int curCnt, int sum) {
//		기저조건
		if(curCnt == N) {
			if(sum == S) {
				cnt++;
			}
			return;
		}
//		현재꺼 포함
		dfs(curCnt+1, sum+nums[curCnt]);
//		현재꺼 미포함
		dfs(curCnt+1, sum);		
	}

}
