package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 *  1. 문제를 보고 생각난 아이디어
 *    - 동,서,남,북 탐색 기능 + 주사위의 값 변화를 주면 된다.
 *    - 남,북 이동 ==> 양옆의 주사위 값은 고정 그 외 4개만 변함.
 *    - 동,서 이동 ==> 위,아래 주사위 값은 고정 그 외 4개만 변함.
 *    - 이동 방향별로 분류해서 값 이동시키기.
 *    - 동,서,남,북 혼합 ==> 주사위 인덱스에 혼란이옴.
	2. 문제를 풀면서 바뀐 아이디어
	  - 주사위 인덱스 는 고정 ex) 1은 항상 위를 향함, 3은 항상 오른쪽, 6은 항상 아래쪽 으로 가정.
	  - 인덱스는 고정하고, 인덱스에 해당하는 값만 이동시킴.
	3. 최종적으로 사용된 아이디어
	  - 2번 과정 + 만약 범위를 벗어날경우 이동하기 전으로 좌표를 되돌려줌.
 * 
 *
 */
public class Main_G4_14499_주사위굴리기 {
	private static int N,M,R,C,K,nr,nc;
	private static int[][] map;
	private static int[] move,dice;
//								  동, 서, 북, 남
	private static int[] dr = {0, 0 ,  0,  -1, 1};
	private static int[] dc = {0, 1 ,  -1,  0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// R크기
		M = Integer.parseInt(st.nextToken());	// C크기
		R = Integer.parseInt(st.nextToken());	// 주사위 R좌표
		C = Integer.parseInt(st.nextToken());	// 주사위 C좌표
		K = Integer.parseInt(st.nextToken());	// 연산 수
		dice = new int[7];	// 주사위
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move = new int[K];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<K; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		
		move(R,C);
		
		
	}// main
	
	private static void move(int r, int c) {
		nr = r;
		nc = c;
		for(int i = 0; i<K; i++) {
//			i번째 이동명령 수행
			nr = nr + dr[move[i]];
			nc = nc + dc[move[i]];
//			System.out.println("move[i] : "+move[i]);
//			System.out.println("nr : "+ nr + " nc : " + nc);
//			지도안에 있을때
			if(isIn(nr,nc)) {
				switch(move[i]) {
//					동
				case 1:
					int temp1 = dice[1];
					dice[1] = dice[4];
					dice[4] = dice[6];
					dice[6] = dice[3];
					dice[3] = temp1;
					mapChk(nr,nc);
					break;
//					서
				case 2:
					int temp2 = dice[1];
					dice[1] = dice[3];
					dice[3] = dice[6];
					dice[6] = dice[4];
					dice[4] = temp2;
					mapChk(nr,nc);
					break;
//					남
				case 3:
					int temp3 = dice[1];
					dice[1] = dice[2];
					dice[2] = dice[6];
					dice[6] = dice[5];
					dice[5] = temp3;
					mapChk(nr,nc);
					break;
//					북
				case 4:
					int temp4 = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[6];
					dice[6] = dice[2];
					dice[2] = temp4;
					mapChk(nr,nc);
					break;
				}
				System.out.println(dice[1]);
			}// if 경계 체크
//			지도 범위 밖일경우 다시 빽
			else {
				nr = nr - dr[move[i]];
				nc = nc - dc[move[i]];
			}
		}
	}
	private static void mapChk(int r, int c) {
//		0이면 바닥숫자 복사
		if(map[r][c] == 0) {
			map[r][c] = dice[6];
		}
//		0이 아니면
		else {
			dice[6] = map[r][c];
			map[r][c] = 0;
		}
		nr = r;
		nc = c;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r <N && c >= 0 && c < M;
	}

}// end class
