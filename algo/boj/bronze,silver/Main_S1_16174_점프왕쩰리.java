package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_16174_점프왕쩰리 {
//							  우, 하
	private static int[] dr = {0, 1};
	private static int[] dc = {1, 0};
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		if(visited[N-1][N-1]) System.out.println("HaruHaru");
		else System.out.println("Hing");
		// 0,0 출발 고정
		// 오른쪽, 아래로만 이동
		
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();		
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			
			for(int d = 0; d<2; d++) {
				int nr = r + dr[d] * map[r][c];
				int nc = c + dc[d] * map[r][c];
				// 범위 안이고		방문 전이면
				if(isIn(nr,nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r< N && c >=0 && c<N;
	}

}
