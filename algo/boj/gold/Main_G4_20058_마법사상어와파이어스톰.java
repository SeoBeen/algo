package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_20058_마법사상어와파이어스톰 {

	private static int N,Q, size,max = -1, total;
	private static int[][] map, temp;
	private static boolean[][] visited;
	private static int[] magic;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		size = (1 << N);
		map = new int[size][size];
		magic = new int[Q+1];
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = Q ; i > 0; i--) {
			magic[i] = Integer.parseInt(st.nextToken());
		}
		process();
		System.out.println(total);
		max = Math.max(max, 0);
		System.out.println(max);
	}
	private static void process() {
		
		while(Q > 0) {
			int magicNum = magic[Q];
			// 0일경우 회전 불필요.
			if(magicNum > 0 ) {
				int seperateSize = (1 << magicNum);
				// 분할 => 회전
				// 시작 위치, 현재크기, 목표크기
				seperate(0,0,size, seperateSize);
			}
			// 얼음덩어리 체크
			melt();
			Q--;
		}
		findMaxSize();
		// 가장 큰덩어리 사이즈 체크
	}
	private static void findMaxSize() {
		visited = new boolean[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				total += map[i][j];
				if(map[i][j] == 0 || visited[i][j]) continue;
				find(i,j);
			}
		}
	}
	
	private static void find(int i, int j) {
		int count = 1;
		Queue<int[]> list = new LinkedList<>();
		list.offer(new int[] {i,j});
		visited[i][j] = true;
		
		while(!list.isEmpty()) {
			int[] current = list.poll();
			int r = current[0];
			int c = current[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 범위 벗어나거나  이미 방문했거나   얼음이 아니면 패스
				if(!isIn(nr,nc) || visited[nr][nc] || map[nr][nc] == 0) continue;
		
				visited[nr][nc] = true;
				list.offer(new int[] {nr,nc});
				count++;
			}
		}
		max = Math.max(max, count);
	}
	
	private static void melt() {
		int[][] tMap = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int count = 0;
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					// 범위 벗어나거나   얼음이 없으면 패스
					if(!isIn(nr,nc) || map[nr][nc] == 0) continue;
					
					// 그게 아니면 인접 얼음 개수 증가
					count++;
				}
				if(count >= 3 || map[i][j] == 0) tMap[i][j] = map[i][j]; 
				else tMap[i][j] = map[i][j] - 1;
			}
		}
		// 백업
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map[i][j] = tMap[i][j];
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < size && c >= 0 && c < size;
	}
	
	
	private static void seperate(int nr, int nc, int len, int goalSize) {
		// 기저조건 원하는 크기만큼 분리가 됨
		if(len == goalSize) {
			temp = new int[size][size];
			// r` => c , c` = N -1 - r		
			// 90도 회전
			for(int r = 0; r < len; r++) {
				for(int c = 0; c < len; c++) {
					temp[nr + c][nc + len - r - 1] = map[nr + r][nc + c];
				}
			}
			// 백업값 돌려주기
			for(int r = 0; r < len; r++) {
				for(int c = 0; c < len; c++) {
					map[nr + r][nc + c] = temp[nr + r][nc + c];
				}
			}
			return;
		}
		
		len /=2;
		seperate(nr, nc, len, goalSize);
		seperate(nr+len, nc, len, goalSize);
		seperate(nr, nc+len, len, goalSize);
		seperate(nr+len, nc+len, len, goalSize);
	}
}
