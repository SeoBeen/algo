package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1948_날짜계산기 {
	private static int T,ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
//		index 0은 사용하지 않음.
		int[] month = new int[] {
				0,
//				1월 2월    3월      4월
				0, 31, 28+31,28+31*2,
//				5월     	6월			 7월			8월
				28+31*2+30,28+31*3+30, 28+31*3+30*2, 28+31*4+30*2,
//				9월				10월		11월			12월
				28+31*5+30*2, 28+31*5+30*3, 28+31*6+30*3,28+31*6+30*4
		};
		for(int i = 1; i <=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int month1 = Integer.parseInt(st.nextToken());	// 첫번째 월
			int day1 = Integer.parseInt(st.nextToken());	// 첫번째 일
			int month2 = Integer.parseInt(st.nextToken());	// 두번째 월
			int day2 = Integer.parseInt(st.nextToken());	// 두번째 일
			day1 += month[month1];
			day2 += month[month2];
			
			ans = day2 - day1+1;
			System.out.println("#"+i+" "+ans);
		}		
	}
}
