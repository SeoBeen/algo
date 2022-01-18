package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1012_유기농배추 {
	private static int[][] map;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tcase = Integer.parseInt(br.readLine());
		for(int i = 0; i <Tcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 가로길이
			M = Integer.parseInt(st.nextToken());
			// 세로길이
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			int cnt = 0;
			for(int j = 0 ; j<K; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st2.nextToken());
				int r = Integer.parseInt(st2.nextToken());
				map[r][c] = 1;
			}
			
			for(int r = 0; r<N; r++) {
				for (int c = 0; c<M; c++) {
					if(map[r][c] == 1) {
						dfs(r,c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int r, int c) {
		// 방문처리
		map[r][c] = 0;
		
		for(int d = 0; d<4; d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			if(isIn(nr,nc) && map[nr][nc] == 1) {
				dfs(nr,nc);
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r >=0 && r<N && c>=0 && c<M;
	}

}
