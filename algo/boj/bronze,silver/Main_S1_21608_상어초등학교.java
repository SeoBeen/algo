package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S1_21608_상어초등학교 {

	//						   상, 우,하, 좌
	private static int[] dr = {-1, 0, 1,  0};
	private static int[] dc = { 0, 1, 0, -1};
	private static int[] score = {0,1,10,100,1000};
	private static int N,ans;
	private static int[][] map, likeArr;
	
	public static void main(String[] args) throws Exception{
		// 상,하,좌,우 는 인접해있다고 본다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		likeArr = new int[N * N+1][4];
		StringTokenizer st;
		for(int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int studentNum = Integer.parseInt(st.nextToken());
			for(int j = 0; j < 4; j++) {
				likeArr[studentNum][j] = Integer.parseInt(st.nextToken());
			}
			
			int stdR = 0;
			int stdC = 0;
			int likeMaxCnt = -1;
			int emptyMaxCnt = -1;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					// 빈자리 이면
					if(map[r][c] == 0) {
						int tempLikeCnt = 0;
						int tempEmptyCnt = 0;
						
						for(int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(isIn(nr,nc)) {
								// 빈자리이면 빈자리 추가
								if(map[nr][nc] == 0) tempEmptyCnt++;
								// 좋아하는 학생번호 명단에 있으면 좋아하는 수 카운트 추가
								else if(map[nr][nc] == likeArr[studentNum][0] ||
									map[nr][nc] == likeArr[studentNum][1] ||
									map[nr][nc] == likeArr[studentNum][2] ||
									map[nr][nc] == likeArr[studentNum][3] ) tempLikeCnt++;
							}
						}
						
						if(tempLikeCnt > likeMaxCnt) {
							likeMaxCnt = tempLikeCnt;
							emptyMaxCnt = tempEmptyCnt;
							stdR = r;
							stdC = c;
						}
						// 좋아하는 학생 수가 같으면
						else if(tempLikeCnt == likeMaxCnt) {
							// 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 정하기
							if(emptyMaxCnt < tempEmptyCnt) {
								emptyMaxCnt = tempEmptyCnt;
								stdR = r;
								stdC = c;
							}
							// 비어있는 칸의 수도 같다면
							// 행 정렬 => 열 정렬
							else if (emptyMaxCnt == tempEmptyCnt) {
								if(stdR > r) {
									stdR = r;
									stdC = c;
									// 행도 같다
								} else if(stdR == r) {
									if(stdC > c) {
										stdC = c;
									}
								}
							}
						}
					} // if map == 0
				} // for : c
			} // for : r
			map[stdR][stdC] = studentNum;
		} // 배치 끝
		
		getScore();
		System.out.println(ans);
		
	}
	
	private static void getScore() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int stdNum = map[r][c];
				int favCnt = 0;
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 범위 안이고
					if(isIn(nr,nc)) {
						if(map[nr][nc] == likeArr[stdNum][0] ||
								map[nr][nc] == likeArr[stdNum][1] ||
								map[nr][nc] == likeArr[stdNum][2] ||
								map[nr][nc] == likeArr[stdNum][3]) favCnt++;
					}
				}
				ans += score[favCnt];
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
