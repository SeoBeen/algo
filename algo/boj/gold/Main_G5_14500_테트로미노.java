package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14500_테트로미노 {
	
	private static int N,M,answer = 0;
	//							상, 우, 하, 좌
	private static int[] dr = { -1,  0,  1, 0};
	private static int[] dc = {  0,  1,  0, -1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,1,map[i][j]);				
				visited[i][j] = false;
				edge(i,j);
			}
		}
		System.out.println(answer);
	}
     
	private static void edge(int r, int c) {
		int sum = 0;
		
		// ㅏ
		// 0,0
		// 1,0 1,1
		// 2,0		
		if(r >=0 && r+2 <N && c >= 0 && c+1 <M) {
			sum = map[r][c] + map[r+1][c] + map[r+1][c+1] + map[r+2][c];
			answer = Math.max(sum, answer);
		}
		
		// ㅓ
		//     -1,1
		// 0,0  0,1
		//      1,1
		if(r-1 >=0 && r+1 <N && c >= 0 && c+1 <M) {
			sum = map[r][c] + map[r-1][c+1] + map[r+1][c+1] + map[r][c+1];
			answer = Math.max(sum, answer);
		}
		
		// ㅗ
		//     -1,1
		// 0,0  0,1  0,2
		if(r-1 >=0 && r <N && c >= 0 && c+2 <M) {
			sum = map[r][c] + map[r][c+2] + map[r][c+1] + map[r-1][c+1];
			answer = Math.max(sum, answer);
		}
		
		// ㅜ
		// 0,0  0,1  0,2
		//      1,1
		if(r >=0 && r+1 <N && c >= 0 && c+2 <M) {
			sum = map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c+1];
			answer = Math.max(sum, answer);
		}
	}

	private static void dfs(int r, int c, int cnt, int sum) {
		// 기저조건
		if(cnt == 4) {
			answer = Math.max(answer,sum);
			return;
		}
		
		for(int d = 0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
//			   범위 안이고	 방문 전이면
			if(isIn(nr,nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc, cnt+1, sum + map[nr][nc]);
				visited[nr][nc] = false;				
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
