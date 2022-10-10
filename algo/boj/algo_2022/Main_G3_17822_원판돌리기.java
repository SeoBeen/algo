package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_17822_원판돌리기 {
	
	private static int N,M,T;
	private static int[][] map;
	//							상,우,하,좌
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};
	private static boolean[][] isVisited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 원판의 개수		
		M = Integer.parseInt(st.nextToken()); // 원판에 적히는 수의 개수		
		T = Integer.parseInt(st.nextToken()); // 회전 수
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(T-- > 0 ) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken()); // 원판의 번호, 배수도 전부 회전해야함 
			int d = Integer.parseInt(st.nextToken());	// 방향 0: 시계, 1: 반시계
			int k = Integer.parseInt(st.nextToken());	// 회전수
			if(d == 1) k = -k;
			for(int i = 0 ; i < N; i++) {
				Arrays.fill(isVisited[i], false);				
			}
			
			// 회전
			for(int cur = x-1; cur < N; cur+=x) {
				int[] tempArr = new int[M];
				for(int i = 0 ; i <M ; i++) {
					tempArr[(i + k + M) % M] = map[cur][i];
				}
					
				for(int i = 0 ; i < M; i++) {
					map[cur][i] = tempArr[i];
				}
			}
			// 회전 끝
			
			// 수 지우기
			boolean flag = false;
			for(int r = 0 ; r < N; r++) {
				for(int c = 0; c < M; c++) {
					for(int nd = 0 ; nd < 4; nd++) {
						int nr = r + dr[nd];
						int nc = (c + dc[nd] + M) % M;
						
						// 범위 안이고    	지워진 숫자가 아니면서 값이 같으면
						if(isIn(nr,nc) && map[nr][nc] != -1 && map[r][c] == map[nr][nc]) {
							isVisited[nr][nc] = true; // 겹침 표시
							isVisited[r][c] = true;
							flag = true; // 이러한 수가 있다 flag 수정
						}
					}
				}
			}
			
			// 지울 수가 있을 경우
			if(flag) {
				for(int r = 0 ;r < N; r++) {
					for(int c = 0 ; c < M; c++) {
						// 같은 수 지우기
						if(isVisited[r][c]) map[r][c] = -1;						
					}
				}
			} else { // 지울 수가 없을 경우	
				int sum = 0, count = 0;
				for(int r = 0; r< N; r++) {
					for(int c = 0; c < M; c++) {
						if(map[r][c] != -1) {
							sum+= map[r][c];
							count++;
						}
					}
				}
				for(int r = 0; r< N; r++) {
					for(int c = 0; c < M; c++) {
						if(map[r][c] != -1 ) {
							if(map[r][c] * count > sum) {
								map[r][c]--;
							} else if (map[r][c] * count < sum) {
								map[r][c]++;
							}							
						}
					}
				}
			}			
			
		} // while
		int ans = 0;
		for(int r = 0; r< N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] > 0) {
					ans+= map[r][c];					
				}
			}
		}
		System.out.println(ans);
	}
	private static boolean isIn(int r , int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
 