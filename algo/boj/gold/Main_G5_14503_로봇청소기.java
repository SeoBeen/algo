package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14503_로봇청소기 {

	//						   북, 동, 남, 서
	private static int[] dr = {-1,  0,  1,  0};
	private static int[] dc = { 0,  1,  0, -1};
	private static int[][] map;
	private static int N, M, cnt;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r,c,dir);
		System.out.println(cnt);
	}


	private static void clean(int r, int c, int dir) {
		
		if(map[r][c] == 1) {
			return;
		}
		// 1. 현재위치 청소
		if(map[r][c] == 0) {
			// 청소 표시
			map[r][c] = -1;
			cnt++;
		}
		// 벽이면 돌아감
		
		int ddr = dir;
		for(int d = 0; d < 4; d++) {
			ddr = (ddr+3) % 4;
			int nr = r + dr[ddr];
			int nc = c + dc[ddr];
			
			// 청소 전이면
			if(map[nr][nc]==0) {
				// 한칸 전진하고 1번부터 진행.
				clean(nr,nc,ddr);
				return;
			}
		}
		// 여기 까지옴 => 4방향 모두 청소가 이미 되어있다.
		// 바라보는 방향을 유지한 채로 한칸 후진
		clean(r-dr[dir], c-dc[dir], dir);	
		return;
	}
}
