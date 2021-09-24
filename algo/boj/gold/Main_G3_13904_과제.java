package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 *  1. 문제를 보고 생각난 아이디어
 *    - 그리디 알고리즘 사용
 *    - 1일부터 순차적으로가 아닌 마지막날부터 역순으로 그날 가능한 과제중 점수가 가장 큰것 선택.
	2. 문제를 풀면서 바뀐 아이디어
	
	3. 최종적으로 사용된 아이디어
 */
public class Main_G3_13904_과제 {
	private static int N,maxDay=Integer.MIN_VALUE,ans;
	
	private static class Assignment {
		int day, score;

		public Assignment(int day, int score) {
			super();
			this.day = day;
			this.score = score;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		과제 저장할 리스트
		ArrayList<Assignment> list = new ArrayList<Assignment>(N);
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Assignment(d,w));
			maxDay = Math.max(d,maxDay);
		}
		ans = 0;
		
//		maxDay : 과제들의 마감일중 제일 마지막날
		for(int i = maxDay; i>0; i--) {
//			리스트 전체 탐색
			int dailyScore = 0;
			int idx = -1;
			for(int d = 0; d<list.size(); d++) {
				if(list.get(d).day >= i && dailyScore < list.get(d).score) {
					idx = d;
					dailyScore = list.get(d).score;
				}
			}
//			여기로 떨어짐 ==> dailyScore 최댓값
			ans += dailyScore;
//			테케에서의 5일 같이 해당하는 날이 없을경우 패스
			if(idx != -1) list.remove(idx);
		}		
		System.out.println(ans);
	}
}
