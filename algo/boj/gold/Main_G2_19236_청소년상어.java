package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G2_19236_청소년상어 {

	//							상, 좌상, 좌, 좌하, 하, 우하 ,우 우상
	private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1};
	private static int res, N = 4;
	
	private static class Fish {
		// 번호, 좌표값, 방향
		int r, c, dir;

		public Fish(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[N][N];
		// 물고기는 16마리
		Fish[] fishes = new Fish[17];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j = 0; j < N; j++) {
				int number = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				map[i][j] = number;
				fishes[number] = new Fish(i,j,dir);
			}
		}
		
		res = map[0][0];
		// 상어정보 추가
		Fish shark = new Fish(0,0, fishes[map[0][0]].dir);
		// 먹힌 물고기 없애주기
		fishes[map[0][0]] = null;
		// 상어표시
		map[0][0] = -1;
		
		moveAndEat(map, fishes, shark, res);
		
		System.out.println(res);
	}
		
	private static void moveAndEat(int[][] map, Fish[] fishes, Fish shark, int sum) {
		
		// 재귀를 이용할것이기 때문에 temp 생성
		// 맵 복사
		int[][] tempMap = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		// 상어 복사
		Fish tempShark = new Fish(shark.r, shark.c, shark.dir);
		
		// 물고기 복사
		Fish[] tempFishes = new Fish[17];
		for(int i = 1; i <= 16; i++) {
			if(fishes[i] == null) continue;
			tempFishes[i] = new Fish(fishes[i].r, fishes[i].c, fishes[i].dir);
		}
		
		
		// 물고기 이동
		for(int f = 1; f <= 16; f++) {
			Fish now = tempFishes[f];
			// 먹힌물고기면 패스
			if(now == null) continue;
			
			int origDir = now.dir;
			do {	
				int nr = now.r + dr[now.dir];
				int nc = now.c + dc[now.dir];
				
				// 범위 밖이거나   상어가 있으면 회전
				if(nr < 0 || nr >=N || nc < 0 || nc >= N || tempMap[nr][nc] == -1) {
					now.dir = (now.dir + 1) % 8;
					continue;
				}
				
				// 이동 가능하다
				
				// 이동 당할 물고기
				Fish ftmp = tempFishes[tempMap[nr][nc]];
				// 이미 먹힌 물고기가 아니면
				
				if(ftmp == null) {
					// 내위치만 갱신
					tempFishes[f] = new Fish(nr, nc, now.dir);
				}
				else {
					tempFishes[tempMap[nr][nc]] = new Fish(now.r, now.c, ftmp.dir);
					tempFishes[f] = new Fish(nr, nc, now.dir);
				}
				
//				if(tempFish != null) {
//					tempFishes[tempMap[nr][nc]] = new Fish(currentFish.r,currentFish.c, tempFish.dir);
//				}
//				tempFishes[idx] = new Fish(nr, nc, dir);
				
				// 이동당한 물고기를 현재 물고기 위치에 저장 
				int nTemp = tempMap[nr][nc];
				tempMap[nr][nc] = f;
				// 이동할 위치에 현재 물고기 값 입력
				tempMap[now.r][now.c] = nTemp;
				
				break;
			} while(now.dir != origDir);
		} // for : 물고기 이동
		// 물고기 이동 끝
			
		// 상어 이동 시작			
		for(int d = 1; d <= 3; d++) {
			int nr = tempShark.r + dr[tempShark.dir] * d;
			int nc = tempShark.c + dc[tempShark.dir] * d;
			
			// 범위넘어가면 정지
//			if(!isIn(nr,nc)) break;
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			
			// 물고기가 없다 => 다음 위치로 이동
			if(tempMap[nr][nc] == 0) continue;
			
			// 물고기 먹었다
			// 먹힌 물고기 번호
			int eatNum = tempMap[nr][nc];
			// 먹힌 물고기 정보
			Fish fish = tempFishes[tempMap[nr][nc]];
			
			
			// 먹힌 물고기 삭제
			tempFishes[tempMap[nr][nc]] = null;
			
			// 상어 정보 수정
			tempShark = new Fish(fish.r, fish.c, fish.dir);
			
			// 상어 표시
			tempMap[nr][nc] = -1;
			
			// 상어가 있던곳 이제 아무것도 없음 => 0
			tempMap[shark.r][shark.c] = 0;
			
			moveAndEat(tempMap, tempFishes, tempShark, sum + eatNum);
			// 되돌리기
			// 상어가 있던곳 다시 표시
			tempMap[shark.r][shark.c] = -1;			
			// 상어가 물고기 먹은곳 물고기 재생
			tempMap[nr][nc] = eatNum;
			// 상어 정보 수정
			tempShark = new Fish(shark.r, shark.c, shark.dir);
			// 먹힌 물고기 살리기
			tempFishes[tempMap[nr][nc]] = new Fish(fish.r, fish.c, fish.dir);
		} // for : 상어 이동
		
		res = Math.max(res, sum);
	} 
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
