package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색 {

	//						 상,우,하,좌
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static int N,M;
	private static int[][] map;
	private static boolean[][] isVisited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for(int r = 0; r < N; r++) {
			String num = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(num.charAt(c)+"");
			}
		}
		bfs(0,0);
	}
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		isVisited[r][c] = true;
		// 시작위치 포함
		int cnt = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {				
				int[] cur = queue.poll();
				int curR = cur[0];
				int curC = cur[1];
				for(int d = 0; d < 4; d++) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					
					if(nr == N-1 && nc == M-1) {
						// 마지막 위치 포함
						System.out.println(cnt+1);
						return;
					}
					
					//  범위안에 있고	방문 전이고			1이면
					if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] == 1) {
						isVisited[nr][nc] = true;
						queue.offer(new int[] {nr,nc});					
					}
				}
			}
			cnt++;
		}
		
	}
	
	private static boolean isIn(int r, int c) {
		return r < N && r >= 0 && c < M && c >= 0;
	}

}
