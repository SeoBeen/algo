package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_14502_연구소 {
	//							상,우,하,좌
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};
	private static int N,M, maxNum;
	private static int[][] map, tempMap;
	private static boolean[][] isVisited, tempVisited;
	private static Queue<int[]> virus = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tempMap = new int[N][M];
		isVisited = new boolean[N][M];
		tempVisited = new boolean[N][M];
		
		for(int r = 0 ; r < N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c = 0 ; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

			}
		}
		
		dfs(0);
		System.out.println(maxNum);
	}

	private static void dfs(int cnt) {
		// 벽을 3개 세웠다.
		if(cnt == 3) {
			int safeCnt = 0;
			// 기존의 값이 변경되면 안되기 때문에 temp를 만들어서 사용.
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					tempMap[r][c] = map[r][c];
					tempVisited[r][c] = isVisited[r][c];
					if(map[r][c] == 2) {
						// 바이러스 위치 저장
						virus.add(new int[] {r,c});
						tempVisited[r][c] = true;
					}
				}
			}
			
			// 바이러스 확산 시작
			while(!virus.isEmpty()) {
				int[] cur = virus.poll();
				int nowR = cur[0];
				int nowC = cur[1];
				
				for(int d = 0 ; d < 4; d++) {
					int nr = nowR + dr[d];
					int nc = nowC + dc[d];
					// 범위 안이고    방문 전이고			빈칸이면
					if(isIn(nr,nc) && !tempVisited[nr][nc] && tempMap[nr][nc] == 0) {
						tempVisited[nr][nc] = true;
						tempMap[nr][nc] = 2;
						virus.offer(new int[] {nr, nc});
					}
				}
			}
			
			// 안전영역 크기 세기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(tempMap[r][c] == 0) safeCnt++;
				}
			}
			
			maxNum = Math.max(maxNum, safeCnt);
			return;
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				// 빈칸이면
				if(map[r][c] == 0) {
					// 벽세우기
					map[r][c] = 1;
					dfs(cnt+1);
					// 원상복구
					map[r][c] = 0;
				}
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
