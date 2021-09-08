package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 *  1. 문제를 보고 생각난 아이디어
 *    - 첫 시작위치의 값을 변수 하나에 저장, 비교해나가면서 더이상 탐색이 불가능할때 cnt++을 한다.
 *    - 색약의 경우 R,G를 하나로 묶고, B만 따로 값을 비교해나간다.
	2. 문제를 풀면서 바뀐 아이디어
	  - 색약의 경우 R인 값을 G로 모두 변경하여 계산한다.
	3. 최종적으로 사용된 아이디어
 */
public class Main_G5_10026_적록색약 {
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;	// 방문 체크
	private static boolean[][] visited_dfs;	// 방문 체크
//								상, 우, 하, 좌
	private static int[] dr = { -1, 0,  1,  0};
	private static int[] dc = {  0, 1,  0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];		// 일반인
		visited = new boolean[N][N]; // 방문 체크
		visited_dfs = new boolean[N][N]; // 방문 체크
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		일반 사람 카운트
		int ans1 = 0;
		int dfs1 = 0;
		for(int i =0; i< N; i++) {
			for(int j=0; j<N; j++) {
//				방문 전이면
				if(!visited_dfs[i][j]) {
//					시작위치 색깔 찾기
					char color = map[i][j];
					//bfs(i,j,color);
					dfs(i,j,color);
					//ans1++;
					dfs1++;
				}
			}
		} // 일반인 for
//		visited 배열 초기화
		for(boolean[] b : visited) {
			Arrays.fill(b, false);
//			System.out.println(Arrays.toString(b));
		}
		for(boolean[] b : visited_dfs) {
			Arrays.fill(b, false);
//			System.out.println(Arrays.toString(b));
		}
		
		
//		색약 카운트
		int ans2 = 0;
		int dfs2 = 0;
//		R색깔을 G색깔로 모두 변경
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
//				방문 전이면
				if(!visited_dfs[i][j]) {
//					시작위치 색깔
					char color = map[i][j];
//					bfs(i,j,color);
					dfs(i,j,color);
//					ans2++;
					dfs2++;
				}
			}
		}// 색약 for		
		
		
//		System.out.println(ans1+" "+ans2);
		System.out.println(dfs1+" "+dfs2);
		
	}// main
	
	
	private static void dfs(int r, int c, char color) {
//		방문 처리
		visited_dfs[r][c] = true;
		for(int d = 0; d<dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
//			   경계 안이고		방문 전이고				색깔이 같다면
			if(isIn(nr,nc) && !visited_dfs[nr][nc] && map[nr][nc] == color) {
				dfs(nr,nc,color);
			}
		}
	}
	private static void bfs(int r, int c, char color) {
//		좌표 저장할 배열 큐
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
//		queue에 담은 좌표 방문 처리
		visited[r][c] = true;
		
//		queue가 empty ==> 방문 완료
		while(!queue.isEmpty()) {
//			방문할 좌표 빼오기
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
//			사방 탐색 시작
			for(int d = 0; d<dr.length; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
//				경계 안이고        방문 전이고			색깔이 같다면
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == color) {
//					방문 처리
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}		
	}// bfs
	
	private static boolean isIn(int r, int c) {
		return r >=0 && r<N && c >=0 && c<N;
	}

}// end class
