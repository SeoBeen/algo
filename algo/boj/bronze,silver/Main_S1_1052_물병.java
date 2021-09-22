package study.boj.prepareExam;

import java.util.Scanner;

/**
 * 
	1. 문제를 보고 생각난 아이디어
	- 물병을 합칠려면 2의 n제곱이 되는 물병수가 있으면 해결가능.
	- 즉, N을 2로 계속 나누면서 나머지가 있는지 체크, 있다면 물병 구매 cnt++
	- 여기서 2로 나눈 몫은 합쳐진 후의 병의 개수, 나머지는 남아있는 물병.
	- 만약, K가 N보다 크다면 0 출력
	2. 문제를 풀면서 바뀐 아이디어
	
	3. 최종적으로 사용된 아이디어
 */
public class Main_S1_1052_물병 {
	private static int N,K,cnt,bottleCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(N <= K) {
			System.out.println(0);
			return;
		}
		
		while(true) {
//			현재 물병수 ( 추후 합친 물병수가 됨)
			bottleCnt = N;
//			들고가는 병수
			int bottle = 0;
//			최대로 합치기
			while(bottleCnt > 0) {
				if(bottleCnt%2 != 0) {
//				남은 병이 있음 ==> 들고가는 병 개수 증가
					bottle++;				
				}
//				병 합치기
				bottleCnt /= 2;
			}
			
//			들고가는 병 수가 K보다 작거나 같아지면
			if(bottle <= K) {
				break;
			}
			
//			물병구매
			cnt++;
//			총 물병수도 증가
			N++;			
		}			
		System.out.println(cnt);		
	} // main

} // end class
