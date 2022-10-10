package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14503_로봇청소기 {
	
	private static class Cleaner {
		int r, c, d;

		public Cleaner(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}		
	}
	
	private static int N, M, cleanCnt;
	private static int[][] map;
	private static Cleaner cleaner;
	//							상,우,하,좌
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		cleaner = new Cleaner(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		for(int r = 0 ; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		process();
		System.out.println(cleanCnt);
	}

	private static void process() {
		
		while(true) {			
			// 1. 현재 위치를 청소한다.
			cleanNowPosition();
			// 2. 현재칸 주변 4칸중 청소되지 않은 빈 칸이 없는 경우
			int r = cleaner.r;
			int c = cleaner.c;
			int emptyCnt = 4;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 맵 안이고,  청소되지 않은 빈칸 체크
				if(isIn(nr,nc) && map[nr][nc] != 0) {
					emptyCnt--;
				}
			}
			// 청소되지 않은 빈칸이 없다
			if(emptyCnt == 0 ) {
				// 		2-1. 바라보는 방향을 유지한 채로 한칸 후진 가능하면 후진 하고 1번으로 돌아가기 / 만약 뒤쪽이 벽이라 후진 못하면 정지
				int curDir = cleaner.d;
				int nr = r + dr[(curDir+2)%4];
				int nc = c + dc[(curDir+2)%4];
				// 범위를 벗어나거나 벽이면
				if(!isIn(nr,nc) || map[nr][nc] == 1 ) return;
				
				// 그게 아니면 후진하고 다음으로
				cleaner.r = nr;
				cleaner.c = nc;
				continue;
			}
			// 3. 청소되지 않은 빈 칸이 있을경우
			else {
				// 3-1. 반시계 방향으로 회전
				cleaner.d = (cleaner.d + 3 ) % 4;
				// 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진.
				int nr = r + dr[cleaner.d];
				int nc = c + dc[cleaner.d];
				// 앞쪽 칸이 범위 안이고 빈칸인경우
				if(isIn(nr,nc) && map[nr][nc] == 0) {
					cleaner.r = nr;
					cleaner.c = nc;
				}
				// 3-3 1번으로 돌아가기.				
			}
		}
	}

	private static void cleanNowPosition() {
		int r = cleaner.r;
		int c = cleaner.c;
		// 청소가 안되었으면 청소하기
		if(map[r][c] == 0) {
			map[r][c] = -1;
			cleanCnt++;
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >=0 && c < M;
	}

}
