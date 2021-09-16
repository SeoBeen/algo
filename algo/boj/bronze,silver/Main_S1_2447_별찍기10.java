package study.boj.prepareExam;

import java.util.Scanner;
/**
 *	1. 문제를 보고 생각난 아이디어
 *    - 일단 작은 부분 N=3일때 부터 먼저 for문으로 구현한다.
 *    - 이후 N = 3일때 구현한 부분을 재귀로 나타낸다.
	2. 문제를 풀면서 바뀐 아이디어
	  - 공백의 위치를 좌표로 생각하지 않고, 일정수 *뒤에 온다고 가정
	  - cnt를 세준뒤 공백 차례일시 if로 조건 처리
	3. 최종적으로 사용된 아이디어 
	  - 재귀 조건 설정시 공백 => * 순
 *
 */
public class Main_S1_2447_별찍기10 {
	private static int N;
	private static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		recursion(0,0,N,false);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< N; i++) {
			for(int j = 0; j<N; j++) {
				sb.append(map[i][j]);				
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	private static void recursion(int x, int y, int num, boolean blank) {		
		
//		공백 차례
		if(blank) {
			for(int i = x; i< x + num; i++) {
				for(int j = y; j < y + num; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
//		출력 조건
		if(num == 1) {
			map[x][y] = '*';
			return;
		}
//		공백차례 카운트
		int cnt = 0; // 5번째마다 공백
		for(int i = x; i < x + num; i+=num/3) {
			for(int j = y; j < y + num; j+=num/3) {
				cnt++;
				if(cnt == 5) {
					recursion(i,j,num/3,true);
				}
				else {
					recursion(i,j,num/3, false);
				}
			}
		}
	}
}
