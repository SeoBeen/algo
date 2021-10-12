package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_5653_줄기세포배양 {
	private static int T,N,M,K;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = { -1,1,0,0};
	private static int[] dc = { 0,0,-1,1};
	private static PriorityQueue<Cell> pq;
	private static Queue<Cell> tmp;
	private static class Cell implements Comparable<Cell>{
		int r,c,lifetime,sLifeTime;
//										생명력,    총 유지되는시간
		public Cell(int r, int c, int lifetime, int sLifeTime) {
			super();
			this.r = r;
			this.c = c;
			this.lifetime = lifetime;
			this.sLifeTime = sLifeTime;
		}

		@Override
		public int compareTo(Cell o) {
			return o.lifetime - this.lifetime;
		}		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tcase=1; tcase<=T; tcase++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());	// 세로
			M = Integer.parseInt(st.nextToken());	// 가로
			K = Integer.parseInt(st.nextToken());	// 배양 시간
//			위 아래로 K시간동안 번식가능
			map = new int[K*2+N][K*2+M];
			visited = new boolean[K*2+N][K*2+M];	// 배양 여부 저장
			pq = new PriorityQueue<Cell>();			// 세포 저장
			tmp = new LinkedList<Cell>();			// 세포 임시 저장
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<M; j++) {
					map[K+i][K+j] = Integer.parseInt(st.nextToken());
//					세포가 있으면
					if(map[K+i][K+j] != 0) {
						visited[K+i][K+j] = true;
						pq.offer(new Cell(K+i, K+j, map[K+i][K+j], map[K+i][K+j]*2));
					}
				}
			}
			for(int time=1; time<=K; time++) {
				bfs(time);
			}
			
			System.out.println("#"+tcase+" "+pq.size());			
		}// tcase for
		
	}// main

	private static void bfs(int time) {
		while(!pq.isEmpty()) {
			Cell cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			cur.sLifeTime--;
//			세포가 활성화 되면
			if(cur.lifetime > cur.sLifeTime) {
				for(int d = 0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
//						경계 안이고		배양 전이면
					if(isIn(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
//						배양한 세포 저장.
						tmp.offer(new Cell(nr,nc, cur.lifetime, cur.lifetime*2));
					}
				}
			}
			
//			활성화가 끝남
//			수명이 다하기 전이면
			if(cur.sLifeTime != 0) {
//				다시 저장
				tmp.offer(new Cell(r,c, cur.lifetime, cur.sLifeTime));
			}
			
		} // while
//		남은 세포 다시 저장		
		while(!tmp.isEmpty()) {
			pq.offer(tmp.poll());
		}
	} // bfs
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < K*2+N && c >= 0 && c < K*2+M;
	}
}//end class
