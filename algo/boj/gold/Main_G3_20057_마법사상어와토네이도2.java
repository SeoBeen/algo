package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_20057_마법사상어와토네이도2 {
	
	//						   좌, 하, 우, 상
	private static int[] dr = { 0,  1,  0, -1};
	private static int[] dc = {-1,  0,  1,  0};
	private static int[] percent = {1,1,2,2,7,7,5,10,10};
	
	private static int[][] sdr = { {1, -1, 2, -2, 1, -1, 0, -1, 1}, // 좌			
								   {-1,-1,0,0,0,0,2,1,1},		// 하								   
									{-1,1,2,-2,-1,1,0,-1,1},	// 우
									{1,1,0,0,0,0,-2,-1,-1}};	// 상
	
	private static int[][] sdc = { {1, 1, 0, 0, 0, 0, -2, -1, -1},			
									{-1,1,-2,2,-1,1,0,-1,1},									
									{-1,-1,0,0,0,0,2,1,1},
									{-1,1,-2,2,-1,1,0,-1,1}};
	
	private static int N, ans = 0;
	private static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move();
		System.out.println(ans);
	}

	private static void move() {
		// 중앙 값
		int r = N/2; int c = N/2;
		
		int d = 0;
		int size = 1;
		int startNum = 2;
		while(true) {
			int two = 2;
			while(two-- > 0) {
				
				for(int i = 0; i < size; i++) {
					r += dr[d];
					c += dc[d];
					
					if(!isIn(r,c)) break;
					startNum++;
					// 0 이면 날려갈 모래가 없다.
					if(map[r][c] == 0) continue;
					
					int nowSand = map[r][c];
					int outSand = 0;
					map[r][c] = 0;
					// 바람 날리기
					for(int idx = 0; idx < 9; idx++) {
						
						// 바람으로 날려가는 좌표값
						int nr = r + sdr[d][idx];
						int nc = c + sdc[d][idx];
						
						// 날려갈 모래 값
						int moveSand = (int) Math.floor( nowSand * (double) percent[idx] / 100);
						
						// 맵 밖으로 나가면 해당 값 만큼 나간거에 더해주기
						if(!isIn(nr,nc)) {
							ans += moveSand;
						}
						// 맵밖으로 나가지 않으면 해당 좌표로 추가
						else {
							map[nr][nc] += moveSand;
						}
						outSand += moveSand;
						
					}
					// 다 돌고 남은 a에 들어갈 모래
					int nr = r + dr[d];
					int nc = c + dc[d];
					// 범위 벗어나면 전체에 더하고
					if(!isIn(nr,nc)) {
						ans += (nowSand - outSand);
					}
					else {
						// 그게아니면 해당좌표에 더해주기
						map[nr][nc] += (nowSand - outSand);
					}
					
//					System.out.println("나간 모래양 : "+ans + " r : " + r + " c : " + c);
					if(r == 0 && c == 0) return;
				} // for
//				System.out.println(d);
				d = (d + 1) % 4;
			} // while(two)
			size++;
			if(startNum >= N * N) break;
		} // while
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
