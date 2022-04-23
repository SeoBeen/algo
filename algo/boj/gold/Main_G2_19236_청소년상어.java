package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G2_19236_청소년상어 {

	//							상, 좌상, 좌, 좌하, 하, 우하 ,우 우상
	private static int[] dr = { -1,  -1,  0,    1,   1,  1,   0,  -1};
	private static int[] dc = { 0,  -1,  -1,    -1,   0,  1,   1,  1};
	private static int[][] map = new int[4][4];
	private static int sum;
	private static List<Fish> fishList;
	private static Fish shark = new Fish();
	private static class Fish implements Comparable<Fish>{
		// 번호, 좌표값, 방향
		int num, r, c, dir;
		boolean isDead;

		public Fish(int r, int c, int num, int dir) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.isDead = false;
		}

		public Fish() {
		}

		@Override
		public int compareTo(Fish o) {
			return this.num - o.num;
		}		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		fishList = new LinkedList<Fish>();
		
		for(int i = 0 ; i < 4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < 4; j++) {
				int number = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken())-1;
				map[i][j] = number;
				// 처음에 바로 상어가 먹을것이기 때문에 0,0은 안넣어준다.
				if(i == 0 && j == 0) {
					shark.r = 0;
					shark.c = 0;
					shark.dir = d;
					sum += map[0][0];
					map[0][0] = 0;
				}
				//					좌표값, 숫자, 방향
				fishList.add(new Fish(i,j,number,d));
			}
		}
		
		// 물고기들 번호순으로 정렬
		Collections.sort(fishList);
		Fish firstFish = fishList.get(map[0][0]);
		firstFish.isDead = true;
		// 물고기 이동
		move();
		// 상어 먹이사냥
		eat();
	} // main

	private static boolean eat() {
		int d = shark.dir;
		
		int nr = shark.r + dr[d];
		int nc = shark.c + dc[d];
		// 범위 벗어나거나   물고기가 없으면 이동불가
		if(!isIn(nr,nc) || map[nr][nc] == -1) return false;
		
		// 이동 가능
		Fish eatenFish = fishList.get(map[nr][nc]);
		sum += map[nr][nc];
		// 상어가 있던곳 빈칸 만들기
		map[shark.r][shark.c] = -1;
		// 상어 이동
		shark.r = nr;
		shark.c = nc;
		shark.dir = eatenFish.dir;
		eatenFish.isDead = true;
		// 먹힘 표시
		map[nr][nc] = -1;
		
		return true;
	}

	private static void move() {
		
		int size = fishList.size();
		for(int idx = 0; idx < size; idx++) {
			Fish currentFish = fishList.get(idx);
			// 먹힌 물고기면 패스
			if(currentFish.isDead) continue;
			int r = currentFish.r;
			int c = currentFish.c;
			int dir = currentFish.dir;
			
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[(dir+d)%8]; 
				int nc = c + dc[(dir+d)%8];
				
				// 범위를 벗어나거나 상어만나면 회전
				if(!isIn(nr,nc) || map[nr][nc] == 0) continue;
				
				// 이동 가능
				// 이동당할 물고기 번호
				int tempFish = map[nr][nc];
				// 이동 위치에 현재 물고기의 값을 넣고
				map[nr][nc] = currentFish.num;
				// 원래 나의 위치에 이동당한 물고기 값 넣기.
				map[r][c] = tempFish;
				currentFish.r = nr;
				currentFish.c = nc;
				currentFish.dir = (dir+d)%8;
				
				Fish moveFish = fishList.get(tempFish);
				moveFish.r = r;
				moveFish.c = r;
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}

}
