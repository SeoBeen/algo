package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_21610_마법사상어와비바라기 {

	//						     좌, 좌상, 상, 우상, 우 ,우하, 하, 좌하
	private static int[] dr = {0, 0,  -1,  -1,   -1,  0 ,  1,   1,  1};
	private static int[] dc = {0, -1, -1,  0,   1,    1,   1 ,  0,  -1};
	private static int N,M, sum;
	private static int[] dArr, sArr;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<int[]> cloudList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		dArr = new int[M+1]; // 방향 배열
		sArr = new int[M+1]; // 거리 배열
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = M ; i > 0; i--) {
			st = new StringTokenizer(br.readLine()," ");
			dArr[i] = Integer.parseInt(st.nextToken());
			sArr[i] = Integer.parseInt(st.nextToken());
		}
		
		process();
		System.out.println(totalWater());
		
	}

	private static int totalWater() {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	private static void process() {
		cloudList = new LinkedList<>();
		cloudList.add(new int[] {N-2, 0});
		cloudList.add(new int[] {N-2, 1});
		cloudList.add(new int[] {N-1, 0});
		cloudList.add(new int[] {N-1, 1});
		
		while(M > 0) {
			// 구름 생성 및 이동, 비내림 => 1씩 추가
			cloudMove();
			
			// 구름 있던칸 제외 모두 구름 생성, -2
			makeCloud();
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					visited[i][j] = false;
				}
			}
			M--;
		}
	}

	private static void makeCloud() {
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] >= 2 && !visited[i][j]) {
					map[i][j] -= 2;
					cloudList.add(new int[] {i,j});
				}
			}
		}
	}

	private static void cloudMove() {
		int size = cloudList.size();
		for(int i = 0 ; i < size; i++) {
			int[] current = cloudList.poll(); 
			int r = current[0];
			int c = current[1];
			
			int nr = (r + dr[dArr[M]] * (sArr[M] % N) + N) % N;
			int nc = (c + dc[dArr[M]] * (sArr[M] % N) + N) % N;
			
			// 비내려서 1씩 추가
			map[nr][nc]++;
			visited[nr][nc] = true;
			// 이동한 구름 좌표 추가
			cloudList.add(new int[] {nr,nc});
		}

		// 물복사 버그 시전
		while(!cloudList.isEmpty()) {
			int[] current = cloudList.poll(); 
			int r = current[0];
			int c = current[1];
			int cnt = 0;
			for(int d = 2; d <9; d+=2) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 경계 벗어나면 패스
				if(!isIn(nr,nc) || map[nr][nc] == 0) continue;
				
				// 아니면 벗어나지 않는 대각선 갯수 카운트
				cnt++;				
			}
			map[r][c] += cnt;
		}

	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
