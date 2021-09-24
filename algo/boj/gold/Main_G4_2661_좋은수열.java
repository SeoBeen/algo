package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 *  1. 문제를 보고 생각난 아이디어
 *    - 좋은 수열 => 수열내에서 인접한 부분이 동일한게 없음.
 *    - 즉, 뒤에서부터 1개 ~ N/2길이 까지 비교    N은 최대 80 => 숫자로 처리불가 문자열 사용
 *    - 비교 도중 이미 좋은수열이 아닐경우 가지치기
	2. 문제를 풀면서 바뀐 아이디어
	  - 가장 작은 수열을 찾아도 다 출력이됨 ==> flag로 출력보다 위에 체크하기
	3. 최종적으로 사용된 아이디어
 */
public class Main_G4_2661_좋은수열 {
	private static int N;
	private static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flag = false;
		bt("1");
	}
	private static void bt(String str) {
//		출력 중복 방지
		if(flag) return;
		
//		좋은수열인지 체크 하곤나서 출력해야함.		
		if(!chk(str)) return;
//		기저 조건
		if(str.length() == N) {
			System.out.println(str);
			flag = true;
			return;
		}
		
//		수열 생성
		for(int i =1; i<=3; i++) {
			bt(str+i);
		}
	}
	private static boolean chk(String str) {
		int len = str.length();
//		뒤에서부터 체크
		int startIdx = len - 1;
		int endIdx = len;
		for(int i = 1; i<= len/2; i++) {
			String front = str.substring(startIdx-i, endIdx-i);
			String back = str.substring(startIdx, endIdx);
//			겹침 => 나쁜수열
			if(front.equals(back)) return false;
//			시작점이 한칸씩 앞으로 가야함.
			startIdx--;
		}
//		좋은수열
		return true;
	}
}
