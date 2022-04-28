package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17144_미세먼지안녕 {
	private static int[][] map;
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static int R,C,T,ans,airCleaner; // 공기청정기의 아래쪽 담당
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					airCleaner = i;
				}
			}
		}
		
		process();
		System.out.println(ans);
	}

	private static void process() {
		
		while(T > 0) {
			// 미세먼지 확산
			spread();
			// 공기청정기 작동
			work();
			T--;
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == -1 || map[r][c] == 0) continue;
				ans += map[r][c];
			}
		}
	}

	private static void work() {
		// 위쪽부터 바람이 나온다.
		int upSide = airCleaner-1;
		// 하
		for(int r = upSide-1; r > 0; r--) {
			map[r][0] = map[r-1][0];
		}		
		// 좌
		for(int c = 0; c +1 < C; c++) {
			map[0][c] = map[0][c+1];
		}
		// 상
		for(int r = 0; r < upSide; r++) {
			map[r][C-1] = map[r+1][C-1]; 
		}
		// 우
		for(int c = C-1; c > 1; c--) {
			map[upSide][c] = map[upSide][c-1];
		}
		map[upSide][1] = 0;
		
		int lowerSide = airCleaner;
		
		// 상
		for(int r = lowerSide+1; r + 1 < R; r++) {
			map[r][0] = map[r+1][0];
		}
		// 좌
		for(int c = 0; c + 1 < C; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		// 하
		for(int r = R-1; r > lowerSide; r--) {
			map[r][C-1] = map[r-1][C-1];
		}
		// 우
		for(int c = C-1; c > 1; c--) {
			map[lowerSide][c] = map[lowerSide][c-1];
		}
		map[lowerSide][1] = 0;
	}

	private static void spread() {
		// 임시 저장용 배열
		int[][] temp = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				// 비어있거나       공기청정기가 아니고 
				if(map[r][c] != 0 && map[r][c] != -1) {
					// 5보다 작으면 확산이 일어나지 않는다.
					if(map[r][c] < 5) {
						temp[r][c] += map[r][c];
						continue;
					}
					
					// 확산이 일어난다
					int spreadCnt = 0;
					int nowDust = map[r][c] / 5;
					
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						//범위 벗어나거나 공기청정기이면 패스
						if(!isIn(nr,nc) || map[nr][nc] == -1) continue;
						
						// 확산이 일어난다.
						spreadCnt++;
						temp[nr][nc] += nowDust;
					}
					
					temp[r][c] += map[r][c] - nowDust * spreadCnt;
				}
			}
		}
		
		temp[airCleaner][0] = -1;
		temp[airCleaner-1][0] = -1;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
