package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 	1. 문제를 보고 생각난 아이디어
 * 	 - 우선 걸리는 시간 => 최악의경우 10억명 * 10^9 -> 10^18 long 사용
 *   - 최단시간 ~ 최악의 시간까지 각 심사대별로 해당 시간동안 몇명을 처리가능한지 구하기
 *   - 구한 값들의 몫의 합 == 사람수 이면 종료
 *   
	2. 문제를 풀면서 바뀐 아이디어
	
	3. 최종적으로 사용된 아이디어
 */
public class Main_S1_3079_입국심사 {
	private static int N,M;
	private static int[] time;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());		//심사대 수
		M = Integer.parseInt(st.nextToken());		//친구 수
		time = new int[N];
		for(int i = 0; i<N; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(time);
//		끝 위치 => int로 크기 선언하면 틀림
		long end = time[time.length-1];
		takeTime(end);
	}
	private static void takeTime(long end) {
		long passSum, mid;	// 입국심사 통과한사람의 합, 이진 탐색을 위한 중간 값
		long start = 1;	//가장 짧게 걸리는 시간
		long curEnd = end * M;	// 최대로 걸리는 시간
		while(start <= curEnd) {
			passSum = 0;
			mid = (start + curEnd) / 2;
//			System.out.println("st : " + start + " end : "+curEnd);
//			System.out.println("mid : " + mid);
			for(int i = 0; i<N; i++) {
//				여기서 해당 시간동안 각 입국심사대별 통과 인원 구하기
				passSum +=  mid / time[i];
			}
//			통과수가 친구수보다 많으면 이분 정렬중 왼쪽 집합으로 이동 => 시간 줄이기
//			passSum이 M과 같은경우가 들어가는 이유 => 예시처럼 28초와 30초의 경우에 30초가 답으로 나올수가 있음
			if(passSum >= M) curEnd = mid -1;
//			통과수가 친구수보다 작은경우 이분 정렬중 오른쪽 집합으로 이동 => 시간 + 
			else start = mid + 1;
		}
//		여기로 떨어짐 => 시작지점이 끝지점보다 크다.  
		System.out.println(start);
	}

}
