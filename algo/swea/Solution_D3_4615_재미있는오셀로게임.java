package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_4615_재미있는오셀로게임 {
	private static int T,N,M;
	private static int[][] map;
//								상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	private static int[] dr = {	-1,	-1,	   0,  1,   1,    1,  0,   -1};
	private static int[] dc = {  0,  1,    1,   1,  0,   -1,  -1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase <=T; tcase++) {
			int bCnt = 0;	// 흑돌 개수
			int wCnt = 0;	// 백돌 개수
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 한변의 길이
			M = Integer.parseInt(st.nextToken());	// 돌을 놓는 횟수
			map = new int[N+1][N+1];
//			흑돌 : 1 백돌 : 2
//			초기 중앙 값 설정
			map[N/2][N/2] = 2;
			map[N/2+1][N/2+1] = 2;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2] = 1;
			
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());	// r 좌표 
				int c = Integer.parseInt(st.nextToken());	// c 좌표 
				int stone = Integer.parseInt(st.nextToken());	// 돌 색깔				
				push(r,c,stone);
			}
			
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j <=N; j++) {
					if(map[i][j] == 1) bCnt++;
//					1이 아니라고 전부다 백돌카운트를 늘려주면 오답!
					else if(map[i][j] == 2) wCnt++;
				}
			}
			System.out.println("#"+tcase+" "+bCnt+" "+wCnt);
		}
	}
	private static void push (int r, int c, int stone) {
//		흑돌 1 백돌 2
		map[r][c] = stone;
//		8방 탐색
		for(int i = 0; i <dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			while(true) {
//				경계를 벗어나거나  0이면 종료 (0행과 0열 미사용)
				if(!isIn(nr,nc) || map[nr][nc] == 0) break;
//				여기로 떨어짐 => 경계 안에 속함
//				놓은곳의 돌과 탐색하는 돌이 같은색이면 정지
				if(map[r][c] == map[nr][nc]) break;
//				0이 아니고, 같지 않다 => 해당방향으로 같은 색깔 만날때 까지 탐색.
				else if(map[nr][nc] != 0){
					nr += dr[i];
					nc += dc[i];					
				}
//				0인 경우 정지.
				else {
					break;
				}
			}
			
//			여기로 떨어짐 => nr과 nc는 같은색을 만난 위치 or 경계에 속하지 않거나 값이 0이다.
			if(isIn(nr,nc) && map[r][c] == map[nr][nc]) {
//				nr 과 nc 위치에서 r 까지 진행해온 방향 반대로 돌아오면서 뒤집기
				while(nr != r || nc != c) {
//					돌 뒤집기
					map[nr][nc] = stone;
					nr -= dr[i];
					nc -= dc[i];
				}
//				for(int x = nr, y = nc; x ==r || y== c; x-=dr[i],y-=dr[i]) {
//					map[x][y] = map[r][c];
//				}
				
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <= N;
	}
}