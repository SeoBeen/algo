package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1520_내리막길 {
	private static int N,M;
	private static int[][] map, cntMap;
	
	//							우  하  좌  상
	private static int[] dr = { 0 , -1, 0,  1};
	private static int[] dc = { 1 , 0, -1,  0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		// 갈 수 있는 방법의 수
		cntMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cntMap[i][j] = -1;
			}
		}
		dfs(0,0);
		System.out.println(cntMap[0][0]);
		
	}
	
	private static int dfs(int r, int c) {
		// 기저조건
		if(r == N-1 && c == M-1) {
			return 1;
		}
		
		// 이미 방문한 적이 있으면  원래값 리턴
		if(cntMap[r][c] != -1) return cntMap[r][c];
		
		// 현위치부터 시작점
		cntMap[r][c] = 0;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 안이고    현재 위치보다 다음위치가 작으면 이동
			if(isIn(nr,nc) &&  map[r][c] >map[nr][nc] ) {
				cntMap[r][c] += dfs(nr,nc);
				
			}
		}
		return cntMap[r][c];
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
