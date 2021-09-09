package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  1. 문제를 보고 생각난 아이디어
 *    - 방의개수, MAX 방의 넓이 ==> bfs탐색 돌면서 한번에 처리가능. but 이동가능 처리 어떻게함?
 *      하나의 벽을 제거 해서 얻을 수 있는 넓은방의 크기 :  MAX방과 연결된 방 중에 찾는다==>함정 반례가능
 *      해당 벽과 &연산후 0이 나온다  ==> 그 방향으로 이동가능. 
 *      
	2. 문제를 풀면서 바뀐 아이디어
		벽을 제거해서 얻을 수 있는 넓은 방의 크기 : 벽을 한개씩 없애면서 최대값을 구해본다.
		
	3. 최종적으로 사용된 아이디어
	
 */

public class Main_G4_2234_성곽 {
	private static int n,m; // n : col, m : row  // m개의 줄에 n개의 정수
	private static int[][] map;
	private static boolean[][] visited;
	private static int cnt, maxRoom;
//								1, 2, 4, 8 비교 
//								서, 북, 동, 남
	private static int[] dr = { 0, -1, 0, 1};
	private static int[] dc = { -1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visited = new boolean[m][n];
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<m; i++) {
			for(int j =0; j<n; j++) {
//				방문 전이라면
				if(!visited[i][j]) {
					bfs(i,j);
//					방 개수 카운트
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxRoom);
		
//		다시 방문 배열 초기화
//		for(boolean[] b : visited) {
//			Arrays.fill(b, false);
//		}
		
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				for(int wall = 1; wall <=8; wall= wall <<1) {
//						벽과 & 후 값이 0이 아니면 벽이 있음.
					if((map[i][j] & wall) != 0) {
//						벽 제거
						map[i][j] -= wall;
//						방문은 매번 새롭기 때문에 매번 초기화!!!!!!
						visited = new boolean[m][n];
//						다시 탐색
						bfs(i,j);
//						돌았으니 다시 복구
						map[i][j] += wall;
						
					}
				}
			}
		}
		System.out.println(maxRoom);
				
	}// main
	
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
//		방문 처리
		visited[r][c] = true;
//		방 넓이 구하기 현재 첫번째꺼 포함하기 때문에 1로 시작.
		int room = 1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int qr = cur[0];
			int qc = cur[1];
			
//			비트 연산을 위한 벽 체크
			int door = 1;
			
			for(int i = 0; i<dr.length; i++) {
//				1과 & 연산 값이 0 ==> 서쪽은 벽이없다. 이동 가능 
				if((map[qr][qc] & door) == 0) {
					int nr = qr + dr[i];
					int nc = qc + dc[i];
//						경계 안이고, 방문 전이면
					if(isIn(nr,nc) && !visited[nr][nc]) {
//						방문처리
						visited[nr][nc] = true;
//						다시 탐색
						queue.offer(new int[] {nr,nc});
//						방 넓이 증가
						room++;
					}
				}
//				다음벽으로 진행
				door = door<<1;
			}
		}//while
		maxRoom = Math.max(maxRoom,room);
	} // bfs
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r< m && c <n && c >=0;
	}

}// end class
