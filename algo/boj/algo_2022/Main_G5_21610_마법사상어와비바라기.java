package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_21610_마법사상어와비바라기 {
	
	private static int N,M;
	//							좌, 좌상, 상, 우상, 우, 우하, 하, 좌하
	private static int[] dr = { 0,   -1, -1,  -1,   0,  1,   1,   1};
	private static int[] dc = { -1,  -1,  0 ,  1 ,  1,   1,   0,  -1};
	private static int[][] map;
	private static boolean[][][] cloudMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cloudMap = new boolean[N][N][2];
		// 물 저장
		for(int r = 0; r< N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 초기 구름 위치
		cloudMap[N-1][0][0] = true;
		cloudMap[N-1][1][0] = true;
		cloudMap[N-2][0][0] = true;
		cloudMap[N-2][1][0] = true;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken())-1; // 인덱스 0부터 시작
			int s = Integer.parseInt(st.nextToken());
			cloudMove(dir, s); // 구름 이동
			addWater(); // 물 1씩 증가
			magic();	// 구름이 있었던 칸에 물복사 버그 시전
			newCloud();	// 물의 양이 2이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
		}
		int sum = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				sum += map[r][c];
			}
		}
		System.out.println(sum);
	}
	
	private static void newCloud() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 구름이 사라진 칸이 아니고 2 이상이면
				if(!cloudMap[r][c][0] && map[r][c] >= 2) {
					// 물이 2줄어들고
					map[r][c] -=2;
					// 구름이 생긴다
					cloudMap[r][c][1] = true;
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				cloudMap[r][c][0] = cloudMap[r][c][1];
			}
		}
	}

	private static void magic() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 구름이 있었으면
				if(cloudMap[r][c][0]) {
					int count = 0;
					// 마법 시전 대각선 체크
					for(int d = 1; d < 8; d+=2) {
						int nr = r + dr[d];
						int nc = c + dc[d];						
						//  범위 안이고		물이 있으면
						if(isIn(nr,nc) && map[nr][nc] > 0) {
							count++;							
						}
					}
					map[r][c] += count;
				}
			}
		}
	}

	private static void addWater() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(cloudMap[r][c][0]) {
					map[r][c] +=1;
				}
			}
		}
	}

	private static void cloudMove(int dir, int s) {
		// false로 임시 구름 맵 초기화
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				cloudMap[r][c][1] = false;
			}
		}
		int dirR = dr[dir] * s + (N * 50);
		int dirC = dc[dir] * s + (N * 50);
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 구름이면
				if(cloudMap[r][c][0]) {
					int nr = (r + dirR) % N;
					int nc = (c + dirC) % N;
					cloudMap[nr][nc][1] = true;
				}					
			}
		}
		
		// 구름위치 저장
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				cloudMap[r][c][0] = cloudMap[r][c][1];
				cloudMap[r][c][1] = false;
			}
		}		
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
