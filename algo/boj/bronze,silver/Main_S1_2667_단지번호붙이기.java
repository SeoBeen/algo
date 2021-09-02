package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_S1_2667_단지번호붙이기 {
	private static int N;	// 지도 크기
	private static int[][] map;	// 지도
	private static boolean[][] isVisited; // 방문여부 체크
	private static int aptCnt;	// 단지 내 아파트 수
	private static int aptNum = 1 ;	// 단지 번호, 집과 구분을 위해 1대입, 이후 1씩 더해가서 2부터 시작.
//								상, 우, 하, 좌
	private static int[] dr = { -1 , 0,  1, 0};
	private static int[] dc = {  0 , 1,  0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
//		단지내의 집의 수를 오름차순 정렬 및 단지가 몇개가 나올지 모르기 때문에 ArrayList사용
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
//				현재 위치가 집이면 진행 1이 아니다 ==> 단지에 속해있다.
				if(map[i][j] == 1) {
//					단지번호 1 증가.
					aptNum++;
//					현위치 단지에 포함
					map[i][j] = aptNum;
//					단지내 아파트 수 1로 시작
					aptCnt = 1;
					dfs(i,j);
//					dfs를 돌고나면 단지내의 아파트 수가 나옴.
					list.add(aptCnt);
				}
			}
		} // 탐색 for문
//		단지번호가 2부터 시작했으므로 -1
		System.out.println(aptNum-1);
		Collections.sort(list);
		for(int i : list) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}//main
	
	private static void dfs(int stR, int stC) {
		for(int d= 0 ; d<dr.length; d++) {
			int nr = stR + dr[d];
			int nc = stC + dc[d];
//			경계범위 안이고 단지가 정해지지 않았다면
			if(isIn(nr,nc) && map[nr][nc] == 1) {
//				단지에 속하는 아파트 수 증가
				aptCnt++;
//				해당 좌표 단지 표시
				map[nr][nc] = aptNum;
//				현위치에서 다시 탐색
				dfs(nr,nc);
			}
		}		
	} // end dfs

	private static boolean isIn(int r, int c) {
		return r >=0 && r < N && c >= 0 && c < N; 
	}
}// end class

//					어딘가 꼬임

/*				경계 범위 안이고	방문 전이면
			if(isIn(nr,nc) && !isVisited[nr][nc]) {
//				현재 위치 방문 처리
				isVisited[nr][nc] = true;
//				방문하려는 곳이 집이면 dfs 호출
				if(map[nr][nc] == 1) {
//					여기로 떨어짐 ==> 같은 집임 아파트 수 증가.
					aptCnt++;
//					dfs 호출
					dfs(nr,nc);				
				}
			}*/