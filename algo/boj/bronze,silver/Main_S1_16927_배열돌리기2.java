package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 문제를 보고 생각난 아이디어
 *   - 값 하나를 tmp에 임시 저장한뒤 값들을 이동시키고 마지막에 tmp값을 빈자리에 넣는다.
 *   - 값 이동시 경계안에 속하면 같은방향으로 이동하고, 아닐시 방향전환을 해준다.
   2. 문제를 풀면서 바뀐 아이디어
     - 최대 회전수 10^9만큼 회전할 필요가 없고, 회전은 일정한 규칙을 띈다.
   3. 최종적으로 사용된 아이디어
     - 해결 방법은 똑같으나 회전수만 변화함.
     - 총 회전수를 R만큼 다 돌지 않고 일정한 규칙을 띄기 때문에
     - R을 내부 회전 주기로 나눈 나머지 만큼만 회전시킨다.
 */
public class Main_S1_16927_배열돌리기2 {
	
	private static int N,M,R;	// 배열 크기 N X M , 회전수 R
	private static int[][] map; // 회전시킬 배열
//								우, 하, 좌, 상
	private static int[] dr = { 0 , 1,  0, -1};
	private static int[] dc = { 1 , 0,  -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		내부 회전수는 둘중 작은 수를 2로 나눈 값이다.
		int subRotation = Math.min(N,M) /2;
		
//		세로 길이		
		int nRow = N;
//		가로 길이
		int nCol = M;
		
		for(int subR = 0; subR < subRotation; subR++) {
//			다시 제자리로 돌아오는데 걸리는 회전 수
			int rotaNum = (nRow+nCol)*2 - 4;
//			실제로 회전해야 하는수 = 총 회전수 % 다시 제자리로 돌아오는데 걸리는 회전 수
			int turn = R % rotaNum;
			for(int i = 0; i< turn; i++ ) {
//				시작 좌표 0,0 // 1,1 // 2,2 
				int r = subR;
				int c = subR;
//				첫 위치를 tmp에 임시 저장
				int temp = map[subR][subR];
				
//				탐색 방향
				int dir = 0;				
				while(dir < 4) {					
					int nr = r + dr[dir];
					int nc = c + dc[dir];
//					경계 안에 있다면
					if(nr >=subR && nr < N-subR && nc >= subR && nc < M-subR) {
//						회전 시킨다.
						map[r][c] = map[nr][nc];
//						회전후 이동할 다음좌표를 좌표에 입력
						r = nr;
						c = nc;
					}
//					경계를 벗어나면 방향 전환
					else dir++;					
				}
//				임시 저장한 값 빈자리에 넣어주기.
				map[subR+1][subR] = temp;
			} // 각각의 내부 회전
//			한번 회전하고 나면 가로 길이와 세로 길이가 2씩 감소한다.
			nRow -=2;
			nCol -=2;
		}// subRotation for
		
		for(int i = 0; i< N; i++) {
			for(int j= 0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);        
	}// main
}// end class


