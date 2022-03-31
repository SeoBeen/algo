package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2573_빙산 {
						//    상, 우, 하,좌
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};
	private static int N,M, ans, cnt;
	private static int[][] map;
	private static Queue<int[]> list = new LinkedList<>();;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 빙산 위치값 저장
				if(map[i][j] != 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		while(!list.isEmpty()) {
			// 시간
			ans++;
			
			// 1. 빙하 녹는다.
			bfs();
			
//			for(int[] c : map) {
//				System.out.println(Arrays.toString(c));
//			}
//			System.out.println("-----------------------");
			// 2. 빙하 덩어리들 개수 세어보기.
			if(!list.isEmpty()) {				
				cnt = 0;
				boolean[][] visited = new boolean[N][M];
				for(int i = 0; i <N; i++) {
					for(int j = 0; j < M; j++) {
						if(map[i][j] != 0 && !visited[i][j]) {
							visited[i][j] = true;
							cnt += count(i,j,visited);							
						}
					}
				}
//				System.out.println("cnt : "+ cnt);
				if(cnt >= 2) {
					System.out.println(ans);
					break;
				}
			}
		}
		if(list.isEmpty()) System.out.println(0);

	}
	
	private static int count(int r, int c, boolean[][] visited) {
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 빙산이고, 			방문전이면
			if(map[nr][nc]!=0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				count(nr,nc,visited);
			}
		}	
		
		return 1;
	}


	private static void bfs() {
		int size = list.size();
		boolean[][] visited = new boolean[N][M];
		while(size-- > 0) {
			int[] current = list.poll();
			int r = current[0];
			int c = current[1];
			visited[r][c] = true;
			for(int d = 0 ; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 바다면 줄어들기		방문 안한거면 즉 빙산이 아니었으면.
				if(map[nr][nc] == 0 && !visited[nr][nc]) {
					if(map[r][c] < 1) break;
					// 감소한다.
					map[r][c]--;
				}
			}
			// 아직 살아지지 않았으면 다시 리스트에 추가.
			if(map[r][c] > 0) list.offer(new int[] {r,c});
		}
	}

}
