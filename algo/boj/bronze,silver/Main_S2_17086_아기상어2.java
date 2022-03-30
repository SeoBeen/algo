package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_17086_아기상어2 {
	
	//						   상,우상,우,우하,하,좌하,좌,좌상
	private static int[] dr = {-1, -1,  0, 1,  1,  1,  0,  -1};
	private static int[] dc = { 0, 1,   1, 1,  0,  -1, -1, -1};

	private static int N,M,max;
	private static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bfs(i,j);
			}
		}
		System.out.println(max);
	}
	private static void bfs(int i, int j) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				int[] current = queue.poll();
				int r = current[0];
				int c = current[1];
				if(map[r][c] == 1) {
					max = Math.max(max,cnt);
					return;
				}
				
				for(int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 범위 안이고,    방문 전이면
					if(isIn(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
			cnt++;
		}
	}
	
	private static boolean isIn(int r, int c ) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
