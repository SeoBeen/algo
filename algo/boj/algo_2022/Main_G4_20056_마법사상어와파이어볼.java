package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G4_20056_마법사상어와파이어볼 {
	
	private static class Fireball {
		int r, c, m, s, d;

		public Fireball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}		
	}
	
	private static int N,M,K;
	private static ArrayList<Fireball> fireball = new ArrayList<>();
	private static ArrayList<Fireball>[][] map;
	//							상,우상, 우, 우하,하, 좌하, 좌, 좌상
	private static int[] dr = { -1,  -1,  0,  1,   1,   1,  0, -1};
	private static int[] dc = { 0,    1,  1,  1,   0,  -1,  -1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 맵 크기
		M = Integer.parseInt(st.nextToken()); // 명령 수
		K = Integer.parseInt(st.nextToken()); // 이동 수
		map = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		
		// 파이어볼 정보 입력
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireball.add(new Fireball(r,c,m,s,d));
		}
		
		move();
		
	}

	private static void move() {
		// K번만큼 이동
		while(K-- > 0) {
			
			// 1. 파이어볼이 이동
			moveFireball();
			
			// 2. 2개 이상의 파이어볼은 다음 명령 실행
			check();
			// 2-1 같은 칸에있는 파이어볼은 모두 합쳤다가 4개로 나뉘어짐, 질량은 합/5, 속력은 합/ 개수
		}
		int ans = 0;
		for(Fireball cur : fireball) {
			ans += cur.m;
		}
		System.out.println(ans);
	}

	private static void check() {
		for(int r = 0; r < N; r ++) {
			for(int c = 0 ; c < N; c++) {
				if(map[r][c].size() < 2) map[r][c].clear();
				// 2개 이상이면
				if(map[r][c].size() >= 2) {
					int curSize = map[r][c].size();
					int totalM = 0; // 질량의 합
					int totalS = 0; // 속력의 합
					boolean isEven = false; // 짝수
					boolean isOdd = false; // 홀수
					for(Fireball cur : map[r][c]) {
						totalM += cur.m;
						totalS += cur.s;
						if(cur.d % 2 == 0) isEven = true;
						else isOdd = true;
						fireball.remove(cur);
					}
					totalM /=5;
					// 속력 나누기
					totalS /= curSize;
					map[r][c].clear();
					// 질량이 0이면 다 사라진다.
					if(totalM == 0) {
						continue;
					}
					
					if((isEven && !isOdd) || (!isEven && isOdd)) {
						fireball.add(new Fireball(r,c,totalM,totalS,0));
						fireball.add(new Fireball(r,c,totalM,totalS,2));
						fireball.add(new Fireball(r,c,totalM,totalS,4));
						fireball.add(new Fireball(r,c,totalM,totalS,6));
					}
					else {
						fireball.add(new Fireball(r,c,totalM,totalS,1));
						fireball.add(new Fireball(r,c,totalM,totalS,3));
						fireball.add(new Fireball(r,c,totalM,totalS,5));
						fireball.add(new Fireball(r,c,totalM,totalS,7));
					}
				}
			}
		}
	}

	private static void moveFireball() {
		for(Fireball ball : fireball) {
			int nr = (ball.r + dr[ball.d] * (ball.s % N) + N ) % N;
			int nc = (ball.c + dc[ball.d] * (ball.s % N) + N ) % N;
			
			ball.r = nr;
			ball.c = nc;
			map[nr][nc].add(ball);
		}
	}

}
