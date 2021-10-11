package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_4008_숫자만들기 {
	private static int T,N,max,min,ans;
	private static int[] op, nums, ansOp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tcase=1; tcase<=T; tcase++) {
			N = Integer.parseInt(br.readLine()); // 숫자 갯수
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			ans = 0;
			
			st = new StringTokenizer(br.readLine()," ");
			op = new int[4];	// 기호 개수 저장 배열
			ansOp = new int[N-1];	// 기호 뽑은거 저장할 배열
			for(int i = 0; i<4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()," ");
			nums = new int[N];	// 숫자 저장 배열
			for(int i = 0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			ans = max - min;
			System.out.println("#"+tcase+" "+ans);
		}// tcase for
	} // main
	private static void permutation(int cnt) {
//		기저조건 연산자를 다 뽑은경우
		if(cnt == N-1) {
			int calRes = cal();
			min = Math.min(min,calRes);
			max = Math.max(max,calRes);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			if(op[i] != 0 ) {
//				현재꺼 빼고
				op[i]--;
				ansOp[cnt] = i;
				permutation(cnt+1);
//				구하고 원상복귀
				op[i]++;
			}
		}
	}
	private static int cal() {
		int num = nums[0];
		for(int i = 0; i<N-1; i++) {
			switch(ansOp[i]) {
//			+-*/
			case 0:
				num += nums[i+1];
				break;
			case 1:
				num -= nums[i+1];
				break;
			case 2:
				num *= nums[i+1];
				break;
			case 3:
				num /= nums[i+1];
				break;
			}			
		}
		return num;
	}

}// end class
