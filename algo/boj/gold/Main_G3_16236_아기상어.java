package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_16236_아기상어 {

	private static int[][] map;
	private static int N,time;
	private static Shark shark;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,1,-1};

	private static class Shark {
		int r,c,size,eatCnt,d;

		public Shark(int r, int c, int d, int size, int eatCnt) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.eatCnt = eatCnt;
			this.d = d;
		}
		
		public Shark(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	// 거리가 가장 가깝다.
	// 가장 위 => 가장 왼쪽 정렬
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 아기상어
				if(map[i][j] == 9) {
					shark = new Shark(i,j,0,2,0);
				}
				map[i][j] = 0;
			}
		}
		while(bfs());
		System.out.println(time);
	}
	
	private static void eat(Shark fish) {		
		map[shark.r][shark.c] = 0;
		shark.r = fish.r;
		shark.c = fish.c;
		shark.eatCnt++;
		map[shark.r][shark.c] = 9;
		
		if(shark.eatCnt == shark.size) {
			shark.size++;
			shark.eatCnt=0;
		}
		System.out.println("여기는오나?");
		time += fish.d;
	}

	private static boolean bfs() {
		boolean[][] visited = new boolean[N][N];				
		Queue<Shark> sQueue = new LinkedList<Shark>();
		PriorityQueue<Shark> fishList = new PriorityQueue<Shark>(new Comparator<Shark>() {
			@Override
			public int compare(Shark o1, Shark o2) {
				// 거리순 정렬
				if(o1.d != o2.d) return o1.d - o2.d;
				// 가장 위에 있는 물고기
				if(o1.r != o2.r) return o1.r - o2.r;
				// 가장 왼쪽
				else return o1.c - o2.c;
			}
		});
		sQueue.offer(new Shark(shark.r, shark.c, 0));
		// 방문처리
		visited[shark.r][shark.c] = true;

		while(!sQueue.isEmpty()) {
			Shark currentShark = sQueue.poll();
			int r = currentShark.r;
			int c = currentShark.c;
			int size = currentShark.size;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(isIn(nr,nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					
					// 1. 상어보다 크다 => 못지나감
					if(map[nr][nc] > currentShark.size) continue;
					
					// 2. 물고기가 없거나 사이즈가 같다 => 지나간다
					else if(map[nr][nc] == 0 || map[nr][nc] == currentShark.size) {
						sQueue.offer(new Shark(nr,nc,currentShark.d+1,size,currentShark.eatCnt));
					}
					else {
						fishList.offer(new Shark(nr,nc,currentShark.d+1));
						System.out.println("물고기는잡나?");
					}
				}
			}
		}
		if(fishList.isEmpty()) return false;
		
		else {
			eat(fishList.poll());
			return true;
		}
	} // bfs

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
