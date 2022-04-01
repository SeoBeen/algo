package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S1_2583_영역구하기 {

	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static int N,M,K,ans;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			for(int r = ly; r < ry; r++) {
				for(int c = lx; c< rx; c++) {
					map[r][c] = 1;
				}
			}
		}
		List<Integer> list = new LinkedList<>();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					ans = 0;
					visited[i][j] = true;
					dfs(i,j);
					list.add(ans);
					cnt++;
				}
			}
		}
		Collections.sort(list);
		for(int c : list) {
			sb.append(c+" ");
		}
		System.out.println(cnt);
		System.out.println(sb);
		

	}

	private static void dfs(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r +dr[d];
			int nc = c +dc[d];
			
			// 범위 안이고,		 방문 전이고,       값이 0이면
			if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == 0) {
				visited[nr][nc] = true;
				dfs(nr,nc);
			}
		}
		ans++;
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < M && c >=0 && c < N;
	}

}
