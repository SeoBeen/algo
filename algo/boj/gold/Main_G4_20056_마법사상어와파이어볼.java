package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G4_20056_마법사상어와파이어볼 {

	//							상, 우상,우,우하,하,좌하,좌,좌상
	private static int[] dr = {  -1, -1,  0,  1,  1 , 1,  0,  -1};
	private static int[] dc = {  0,  1,   1,  1,  0, -1, -1, -1};
	private static ArrayList<fireBall> [][] map;
	private static ArrayList<fireBall> fireBallList = new ArrayList<>();
	private static int N;
	static class fireBall {
		// r,c는 위치
		// m : 질량
		// d : 방향
		// s : 속령
		int r,c,m,s,d;
		
		public fireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// N : 격자 크기
		// M : 파이어볼 개수
		// K : 명령한 횟수		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				map[i][j] = new ArrayList<fireBall>();
			}
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBallList.add(new fireBall(r, c, m, s, d));
			
		}
		
		for(int i = 0; i<K; i++) {
			
//		1. 이동
			move();
//		2. 이동이 끝난후 2개 이상일 경우
			check();
		}
		int ans = 0;
		for(fireBall fb : fireBallList) {
			ans += fb.m;
		}
		System.out.println(ans);
	}


	private static void check() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j].size() == 1) {
					map[i][j].clear();
				}
				// 사이즈가 2보다 작으면 패스
				if(map[i][j].size() < 2) {
					continue;
				}
				
				// 질량 합계
				int sumM = 0;
				// 속도 합계
				int sumS = 0;
				boolean even = false;
				boolean odd = false;
				
				for(fireBall fb : map[i][j]) {
					// 질량 합
					sumM += fb.m;
					// 속도 합
					sumS += fb.s;
					if(fb.d %2 == 0) even = true;
					else odd = true;
					// 리스트에서 제거
					fireBallList.remove(fb);
				}
				
				sumM /= 5;
				sumS /= map[i][j].size();
				map[i][j].clear();
				
				// 질량이 0이면 사라진다.
				if(sumM == 0) continue;
				
				// 모두 짝수이거나 모두 홀수 일때
				if((even && !odd) || (!even && odd)) {
					fireBallList.add(new fireBall(i,j,sumM,sumS,0));
					fireBallList.add(new fireBall(i,j,sumM,sumS,2));
					fireBallList.add(new fireBall(i,j,sumM,sumS,4));
					fireBallList.add(new fireBall(i,j,sumM,sumS,6));
				}
				else {
					fireBallList.add(new fireBall(i,j,sumM,sumS,1));
					fireBallList.add(new fireBall(i,j,sumM,sumS,3));
					fireBallList.add(new fireBall(i,j,sumM,sumS,5));
					fireBallList.add(new fireBall(i,j,sumM,sumS,7));					
				}
			}
		}

	}
	private static void move() {
		for(fireBall fb : fireBallList) {
			int nr = (fb.r +N+ dr[fb.d] * (fb.s%N)) % N;
			int nc = (fb.c +N+ dc[fb.d] * (fb.s%N)) % N;
			
			fb.r = nr;
			fb.c = nc;
			map[nr][nc].add(fb);
		}
	}
	
}
