package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	1. 문제를 보고 생각난 아이디어
 *   - 1~5까지는 방향 유의하고, 6~10 웜홀 좌표 저장할 배열 필요, -1 또는 시작위치로 갈경우 종료
 *   - 시작 위치가 안정해짐 => 모든 좌표에서 다 시작해봐야함.
	2. 문제를 풀면서 바뀐 아이디어
	 -	cnt는 각각 if문에서 증가 시켜주자.
	3. 최종적으로 사용된 아이디어
	 
 * @author Seobeen
 *
 */
public class Solution_모의SW역량테스트_5650_핀볼게임 {
	private static int T,N, ans;
	private static int[][] map;
	private static int[][] warmholeR;
	private static int[][] warmholeC;
//								상,우,하,좌
	private static int[] dr = {-1,  0, 1, 0};
	private static int[] dc = { 0,  1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tcase= 1; tcase<=T; tcase++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			warmholeR = new int[5][2];
			warmholeC = new int[5][2];
			ans = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
//					웜홀이다.
					if(map[i][j] > 5) {
						if(warmholeR[map[i][j]-6][0] == 0 && warmholeC[map[i][j]-6][0] == 0) {
							warmholeR[map[i][j]-6][0] = i;
							warmholeC[map[i][j]-6][0] = j;
						}
						else {
							warmholeR[map[i][j]-6][1] = i;
							warmholeC[map[i][j]-6][1] = j;							
						}
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
//					핀볼 시작
					if(map[i][j] == 0) {
//						바로 4방향 탐색
						for(int d= 0; d<4; d++) {
							start(i,j,d);							
						}
					}
				}
			}
			
			System.out.println("#"+tcase+" "+ans);
		}// tcase for	
	} // main
	private static void start(int r, int c,int dir) {
//		무엇인가를 만나지 않으면 해당방향으로 쭉 진행
		int cnt = 0;
		int nr = r;
		int nc = c;
		int d = dir;
		
		while(true) {
			 nr += dr[d];
			 nc += dc[d];
			 
//			 경계를 벗어날 경우 제일 먼저 체크 해줘야함.
//			 상,우,하,좌
			 if(!isIn(nr,nc)) {
//				 부딪힌 횟수 증가
				 cnt++;
//				 방향 전환
				 d = (d+2)%4;
				 continue;
			 }
			 
//			 출발지일 경우 스탑.
			 if(nr == r && nc == c) break;
//			 블랙홀도 스탑.
			 if(map[nr][nc] == -1) break;
			 
			 int cur = map[nr][nc];
//			 여기로 떨어짐 ==> 0~ 10 을 만나고 이동이 가능한 상태.			 
			 if(cur == 1) {
				 cnt++;
				 if(d == 0 || d == 1) d = (d+2)%4;
				 else if(d == 2) d = 1;
				 else d = 0;
			 }
			 else if(cur == 2) {
				 cnt++;	
				 if(d == 2 || d == 1) d = (d+2)%4;
				 else if(d == 0) d = 1;
				 else d = 2;
			 }
			 else if(cur == 3) {
				 cnt++;	
				 if(d == 2 || d == 3) d = (d+2)%4;
				 else if(d == 0) d = 3;
				 else d = 2;
			 }
//			 0  1  2  3
//			 상,우,하,좌
			 else if(cur == 4) {
				 cnt++;	
				 if(d == 0 || d == 3) d = (d+2) %4;
				 else if(d == 2) d = 3;
				 else d = 0;
			 }
			 else if(cur == 5) {
				 d = (d+2)%4;
				 cnt++;	
			 }
			 else if(cur > 5) {
				 if(warmholeR[cur-6][0] == nr && warmholeC[cur-6][0] == nc) {
					 nr = warmholeR[cur-6][1];
					 nc = warmholeC[cur-6][1];
					 continue;
				 }
				 else {
					 nr = warmholeR[cur-6][0];
					 nc = warmholeC[cur-6][0];
					 continue;					 
				 }
			 }
			 		 
		}// while
		ans = Math.max(ans,cnt);
		
	}// start
	
	private static boolean isIn(int r, int c) {
		return r >=0 && r < N && c>=0 && c <N;
	}
} // end class
