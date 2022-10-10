package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G3_16236_아기상어 {
	
	private static int N, time;
	private static int[][] map;
	private static boolean isUpdate;
	private static boolean[][] isVisited;
	private static PriorityQueue<Shark> fishList = new PriorityQueue<Shark>(new Comparator<Shark>() {
		@Override
		public int compare(Shark o1, Shark o2) {
			// 거리
			if(o1.d != o2.d) return o1.d - o2.d;
			// r
			if(o1.r != o2.r) return o1.r - o2.r;
			// c
			return o1.c - o2.c;
		}
	});
	private static Shark shark;
	// 							상,우,하,좌
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = {  0, 1, 0, -1};
	
	private static class Shark {
		int r, c, curEat, size, d;

		public Shark(int r, int c, int d, int curEat, int size) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.curEat = curEat;
			this.size = size;
		}

		public Shark(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i,j,0,0,2);					
				}
			}
		}
		process();
		
	}

	private static void process() {
		
		isUpdate = true;
		while(isUpdate) {
			fishList.clear();
			findFish();
			isUpdate = eat();
		}		
		System.out.println(time);
	}

	private static boolean eat() {
		if(fishList.isEmpty()) return false;
		
		// 물고기가 있다.
		Shark fish = fishList.poll();
		map[shark.r][shark.c] = 0;
		shark.r = fish.r;
		shark.c = fish.c;
		map[shark.r][shark.c] = 9;
		shark.curEat++;
		if(shark.curEat == shark.size) {
			shark.curEat = 0;
			shark.size++;
		}
		time += fish.d;
		return true;
	}

	private static void findFish() {
		for(boolean[] s : isVisited) {
			Arrays.fill(s, false);
		}
		
		Queue<Shark> queue = new LinkedList<>();
		queue.offer(new Shark(shark.r, shark.c, 0));
		isVisited[shark.r][shark.c] = true;
			
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {				
				Shark curShark = queue.poll();
				int r = curShark.r;
				int c = curShark.c;
				for(int d = 0 ; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					//
					if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] <= shark.size) {
						isVisited[nr][nc] = true;
						
						// 크기가 같은 물고기다.
						if(map[nr][nc] == shark.size || map[nr][nc] == 0) {
							queue.offer(new Shark(nr,nc,curShark.d+1));						
						}
						else {						
							fishList.offer(new Shark(nr,nc,curShark.d+1));
						}
					}
					
				}
			} // size while			
		}// queue while
	}
	
	private static boolean isIn(int r , int c ) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
