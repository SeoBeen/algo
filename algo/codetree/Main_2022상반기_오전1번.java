package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2022상반기_오전1번 {
	
	private static int n,m,h,k, score;
	private static ArrayList<Runner>[][] map;	
	private static Killer killer;
	//							우, 좌
	private static int[][] rDr = {{0,0},
		//						상,하
								{1,-1}};
	private static int[][] rDc = {{1,-1},
								{0,0}};
	//							상,우,하, 좌
	private static int[] kDr = {-1, 0, 1, 0};
	private static int[] kDc = { 0, 1, 0,-1};
	
	private static boolean[][] tree;
	
	private static class Runner {
		int r , c , dir, secondDir;

		public Runner(int r, int c, int dir, int secondDir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.secondDir = secondDir;
		}
	}
	
	private static class Killer {
		int r, c, dir, two, size, currentMoved;
		boolean isReverse;
		public Killer(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.dir = 0;
			this.size = 1;
			this.two = 2;
			this.currentMoved = 0;
			this.isReverse = false;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken()); // 맵 크기
		m = Integer.parseInt(st.nextToken()); // 도망자 수
		h = Integer.parseInt(st.nextToken()); // 나무의 수
		k = Integer.parseInt(st.nextToken()); // 턴
		
		map = new ArrayList[n][n];
		tree = new boolean[n][n];
		score = 0;
		killer = new Killer((n-1)/2,(n-1)/2);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<Runner>();
			}
		}
		
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			map[r][c].add(new Runner(r,c,d,0));
		}
		
		for(int i = 0 ; i < h; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			tree[r][c] = true;
		}
		process();
		System.out.println(score);
	}

	private static void process() {
		int turn = 0;
		while(turn++ < k) {
			
			// 도망자 이동
			
			// 술래 이동
			
			// 사냥
			
		}
	}

}
