package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
/**
 *  1. 문제를 보고 생각난 아이디어
 *    - N/4 만큼 회전, 각 숫자는 N/4만큼 끊어서 만든다.
	2. 문제를 풀면서 바뀐 아이디어
	
	3. 최종적으로 사용된 아이디어
 * @author Seobeen
 *
 */
public class Solution_모의SW역량테스트_5658_보물상자비밀번호 {
	private static int T,N,K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tcase = 1; tcase<=T; tcase++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			Set<String> set = new HashSet<String>();
			
			char[] chr = new char[N];
			chr = br.readLine().toCharArray();
//			N/4 만큼 회전
			for(int i = 0; i<N; i++) {
				String str = "";				
				for(int j = i; j< i+N/4; j++) {
					str +=chr[j%N];
				}
				set.add(str);
			}
			
			List<String> list = new ArrayList<String>(set);
			// set -> list로 변환 후
			Collections.sort(list,Collections.reverseOrder());
			
			int ans = Integer.parseInt(list.get(K-1),16);
			
			System.out.println("#"+tcase+" "+ans);
		}// tcase for
		
	}// main

}// end class
