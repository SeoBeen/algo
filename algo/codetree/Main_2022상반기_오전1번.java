package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2022상반기_오전1번 {
	
	private static int n,m,h,k, score, turn;
	private static ArrayList<Runner>[][] map, temp;	
	private static Killer killer;
	//							우, 좌
	private static int[][] rDr = {{0,0},
		//						하,상
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
		temp = new ArrayList[n][n];
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
		turn = 0;
		while(turn++ < k) {
			
			// 도망자 이동
			runnerMove();
			// 술래 이동
			killerMove();
			// 사냥
			kill();
		}
	}

	private static void kill() {
		for(int cnt = 0; cnt < 3; cnt++) {
			int nr = killer.r + kDr[killer.dir] * cnt;
			int nc = killer.c + kDc[killer.dir] * cnt;
			// 범위 벗어나면 정지
			if(!isIn(nr,nc)) break;
			
			// 나무가 있으면 숨어서 못잡음
			if(tree[nr][nc]) continue;
			
			score += (map[nr][nc].size() * turn);
			map[nr][nc].clear();
		}
	}

	private static void killerMove() {
		
//		int[][] test = new int[n][n];
//		for(int r = 0; r < n; r++) {
//			for(int c = 0; c < n; c++) {
//				test[r][c] = 0;
//			}
//		}
		
		int r = killer.r;
		int c = killer.c;
		int d = killer.dir;
		
//		test[r][c] = 1;
//		System.out.println("----------- 구분선 ----------------");
//		for(int[] tes : test) {
//			System.out.println(Arrays.toString(tes));
//		}
		
		// 해당 방향으로 이동
		int nr = r + kDr[d];
		int nc = c + kDc[d];
		// 이동횟수 증가
		killer.currentMoved++;
		
		// 사이즈 만큼 이동했으면
		if(killer.size == killer.currentMoved) {
			
			killer.currentMoved = 0;
			
			killer.two--;
			// 만약 2번만큼 사이즈를 다 돌았으면
			if(killer.two == 0) {
				killer.two = 2;
				if(killer.isReverse) {
					// 역방향이면 사이즈 감소
					killer.size--;
				}
				else {
					// 다음 사이즈 증가
					killer.size++;			
				}
			}			
			// 방향 전환
			if(killer.isReverse) { 					// 역방향이면
				killer.dir = (killer.dir + 3) % 4;
			}
			else { 									// 정방향이면
				killer.dir = (killer.dir + 1) % 4;
			}
		}
		
		// 이동한 곳이 0,0이면
		if(nr == 0 && nc == 0) {
			killer.r = 0;
			killer.c = 0;
			killer.dir = 2;
			killer.size = n-1;
			killer.two = 3;
			killer.currentMoved = 0;
			killer.isReverse = true;
		}
		
		else if (nr == (n-1)/2 && nc == (n-1)/2) {
			killer.r = (n-1)/2;
			killer.c = (n-1)/2;
			killer.dir = 0;
			killer.size = 1;
			killer.two = 2;
			killer.currentMoved = 0;
			killer.isReverse = false;			
		}
		
		else {
			killer.r = nr;
			killer.c = nc;
		}
	}

	private static void runnerMove() {
		makeTemp();
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				// 비어있으면 패스
				if(map[r][c].isEmpty()) continue;
				
				// 거리가 3 초과이면 패스
				if((Math.abs(killer.r - r) + Math.abs(killer.c - c)) > 3) continue;
							
				// 그게아니면 다 움직인다.
				for(int idx = 0; idx < map[r][c].size(); idx++) {
					Runner current = map[r][c].get(idx);
					int runnerR = current.r;
					int runnerC = current.c;
					int runnerDir = current.dir;
					int runnerSDir = current.secondDir;
					
					int nr = runnerR + rDr[runnerDir][runnerSDir];
					int nc = runnerC + rDc[runnerDir][runnerSDir];
					// 술래가 있으면 이동하지 않고 그대로
					if(nr == killer.r && nc == killer.c) {
						temp[r][c].add(current);
						continue;
					}
					
					// 벽을 넘어가면
					if(!isIn(nr,nc)) {
						// 방향 틀어주기
						runnerSDir = (runnerSDir+1) % 2;
						
						// 바뀐 방향으로 1칸 이동
						nr = runnerR + rDr[runnerDir][runnerSDir];
						nc = runnerC + rDc[runnerDir][runnerSDir];
						
						// 방향 바꾸고 이동할려고 하는데 킬러가 있으면
						if(nr == killer.r && nc == killer.c) {
							// 방향 전환만 하고 저장
							current.secondDir = runnerSDir;
							temp[r][c].add(current);
							continue;
						}
					}					
					
					// 이동이 가능하면
					current.r = nr;
					current.c = nc;
					current.secondDir = runnerSDir;
					temp[nr][nc].add(current);
				}
				// 이동한거 없애주기
				map[r][c].clear();
			}
		}
		
		for(int r = 0; r < n; r++ ) {
			for(int c = 0; c < n; c++) {
				if(temp[r][c].isEmpty()) continue;
				
				for(Runner run : temp[r][c]) {
					map[r][c].add(run);
				}
			}
		}
	}

	private static void makeTemp() {
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				temp[r][c] = new ArrayList<>();
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}

}
