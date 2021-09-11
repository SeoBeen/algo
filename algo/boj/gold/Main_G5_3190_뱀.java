package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 *  1. 문제를 보고 생각난 아이디어
 *   - 우선 뱀의 머리와 꼬리 위치를 저장할 곳이 필요함 ==> 배열 저장
 *   - 삽입, 삭제가 쉬워야함 ==> LinkedList 
 *   - 방향 전환은 %4를 이용하며, 이동할때마다 지나간 좌표에 몸임을 표시함.
 *   - 사과가 아닐경우 꼬리를 제거함.
 *   - 흐른 시간과 방향전환의 초값이 같으면 방향전환, index 설정.   
 *   
	2. 문제를 풀면서 바뀐 아이디어
	 - 음수의 경우 %4 불가 강제 대입이 필요함. 
	 - 방향 전환 인덱스 사용 => 에러 발생 그냥 한개씩 쓰고 지우는걸로.
	3. 최종적으로 사용된 아이디어
	 - LinkedList 사용,
	 - 반시계 방향일 경우 0이되면 3을 대입함.
 */
public class Main_G5_3190_뱀 {
	private static int N,K,L;
	private static int[][] map;
//								상,우,하,좌
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = {  0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1]; // 1행1열부터 시작.
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
//		방향 변환
		L = Integer.parseInt(br.readLine());
		LinkedList<int[]> dir = new LinkedList<>();
//		방향전환 인덱스
		int dirSec = 0;
		for(int i = 0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sec = Integer.parseInt(st.nextToken());
//														L : 반시계 방향
			int way = st.nextToken().charAt(0)== 'L' ? -1 : 1 ;
			dir.offer(new int[] {sec, way});
		}
//		경과 시간
		int sec = 0;
//		처음에 오른쪽을 향함.
		int way = 1;
		LinkedList<int[]> snake = new LinkedList<>();
		snake.add(new int[] {1,1});
//		첫 시작 표시
		map[1][1] = 2;
		while(true) {
			sec ++;
			int[] head = snake.getLast();
			int[] tail = snake.getFirst();
			int nr = head[0] + dr[way];
			int nc = head[1] + dc[way];
//			경계 벗어남 ==> 벽 부딪힘 끝.
			if(!isIn(nr,nc))
				break;
			
//			사과가 아닐경우
			if(map[nr][nc] == 0) {
//				뱀 이동
				snake.add(new int[] {nr,nc});
//				몸통 표시
				map[nr][nc] = 2;
//				더이상 몸이 아님 0으로 표시.
				map[tail[0]][tail[1]] = 0;
//				꼬리 제거
				snake.remove(0);
			}
//			사과일경우
			else if(map[nr][nc] == 1) {
				snake.add(new int[] {nr,nc});
//				몸통 표시
				map[nr][nc] = 2;
			} 
//			내 몸임.
			else if(map[nr][nc] == 2) {
				break;
			}
//				방향 전환		해당 시간이 흐른뒤 
			if(!dir.isEmpty() && sec == dir.get(0)[0]) {
//				시계 방향일 경우
				if(dir.get(0)[1] == 1) {
					way++;
					way = way % 4;
				}
//				반시계 방향일 경우
				else {
					if(way == 0) {
						way = 3;
					}
//					way = Math.abs(way % 4);
					else {
						way--;						
					}
				}
				dir.remove(0);
			}
		}
		System.out.println(sec);
	}// main
	
	private static boolean isIn(int r, int c ) {
		return r >0 && r <= N && c >0 && c <= N;
	}

}// end class
