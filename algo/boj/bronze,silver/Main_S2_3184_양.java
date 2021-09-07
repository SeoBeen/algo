package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 1. 문제를 보고 생각난 아이디어
 * 	  a) . 과 #을 구분해서 방문 가능 or 불가능 나누기.
 *    b) 탐색 돌면서 양의 수와 늑대의 수 카운트, 해당 방문이 끝날때마다 값비교
 *    c) 더 많이 남은 동물의 수만 해당 변수에 저장. 탐색이 끝난뒤 남은 양과 늑대의 수를 출력
   2. 문제를 풀면서 바뀐 아이디어
      이번엔 dfs로 풀어보자.
   3. 최종적으로 사용된 아이디어
      변동 없음.
   
 */

public class Main_S2_3184_양 {
	private static char[][] map;
	private static int R,C; // R : 행의 수, C : 열의 수
	private static int wCnt, sCnt; // wCnt : 최종 늑대의 수, sCnt : 최종 양의 수
	private static int wolf, sheep;
//								상, 우, 하, 좌
	private static int[] dr = { -1,  0,  1, 0};
	private static int[] dc = {  0,  1,  0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0; i< R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i< R; i++) {
			for(int j = 0; j<C; j++) {
//				울타리일경우 넘어감
				if(map[i][j] == '#') continue;
				wolf = 0;
				sheep = 0;
				dfs(i,j);
				// 탐색후 양이 더 많을경우만 양이 살고 나머지는 늑대가 다 먹음.
				if(sheep > wolf) sCnt +=sheep;
				else wCnt += wolf;
			}
		}
		System.out.println(sCnt + " "+ wCnt);
		
	}// main
	private static void dfs(int r, int c) {
//		양이면 양++
		if(map[r][c] == 'o') sheep++;
//		늑대면 늑대++
		if(map[r][c] == 'v') wolf++;
//		울타리로 채우면서 방문처리
		map[r][c] = '#';
		
		for(int d = 0 ; d<dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
//			경계 안일때
			if(isIn(nr,nc)) {
//				울타리면 패스
				if(map[nr][nc] == '#') continue;
//				아니면 탐색
				dfs(nr,nc);
			}			
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && R > r && c >=0 && c < C;
	}
} // end class
