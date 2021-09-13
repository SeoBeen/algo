package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. 문제를 보고 생각난 아이디어
 * 	 - 1-1 아기상어 위치 구하기
 *   - 1-2 아기상어 위치에서 가장 가까운 먹을 수 있는 물고기 찾기 (bfs)
 *   -    1-2-1 물고기가 없다면 종료.
 *   -    1-2-2 물고기가 있다면 물고기 리스트에 저장.
 *   - 1-3 같은 거리에 물고기가 여러마리일 경우 r기준 정렬 -> c 기준 정렬
 *   - 1-4 물고기 먹고 상어 위치 이동.
 *   - 반복
   2. 문제를 풀면서 바뀐 아이디어
     - 상어 위치와 크기를 같이 저장할려면 객체 생성이 편함.
     - 거리순 -> r 오름차순 -> c 오름차순 정렬이 필요함 comparator 사용.
   3. 최종적으로 사용된 아이디어
 */

public class Main_G4_16236_아기상어 {
	
	static class shark {
		int r;	// 좌표값 저장을 위한 r,c
		int c;	
		int size;	// 상어의 크기, 먹은 물고기수 저장.
		int count;		
	}
	
	private static int N,time;
	private static int[][] map;
	private static boolean[][] visited;
	private static shark shark = new shark();
//								상,우,하,좌
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		map = new int[N][N];
		
		for(int i = 0 ; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
//					아기상어 위치
					shark.r = i;
					shark.c = j;
					shark.size = 2;
					shark.count = 0;
				}
			}
		}
		while(hasFish(shark));
		System.out.println(time);
		
	}
	private static boolean hasFish(shark shark) {
		visited = new boolean[N][N];
		Queue<int []> queue = new LinkedList<int []>();
		ArrayList<int[]> list = new ArrayList<>();	// 물고기 리스트
//								r 좌표,  c 좌표, 거리
		queue.offer(new int[] {shark.r, shark.c, 0});
		visited[shark.r][shark.c] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d = 0; d<dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
//				경계 내부이고      방문전
				if(isIn(nr,nc) && !visited[nr][nc]) {
//					방문처리
					visited[nr][nc] = true;
//					아기보다 크면 못 지나감					
					if(map[nr][nc] > shark.size) continue;
//							빈집 이거나				크기가 같다 ==> 지나가기만 가능
					else if(map[nr][nc] == 0 || map[nr][nc] == shark.size) {
//						이동을 위해서 큐에저장
//														현재 상어로부터의 거리
						queue.offer(new int[] {nr,nc, cur[2]+1});
					}
//					여기로 떨어짐 ==> 0은 아님 고로 아래 범위는 0<가 됨.
//					먹이가 있음.
					else {
//						물고기 위치 리스트
						list.add(new int[] {nr, nc, cur[2]+1});
					}					
				}
			} // for
		}//while 
//		먹을수 있는 물고기가 없다.
		if(list.isEmpty()) {
			return false;
		}
//		물고기가 있다.
		else {
			Collections.sort(list, new Comparator<int[]>() {
//							리스트↟ 안의 int 배열들 정렬기준 정함. (1.거리 2.r 3.c)
				public int compare(int[] o1, int[] o2) {
//									거리순
					int compare = o1[2] - o2[2];
//					거리가 같다면
					if(compare == 0) {
						int compare2 = o1[0] - o2[0];
//						r 값이 같다면.
						if(compare2 == 0) {
							return o1[1] - o2[1];
						}
						return compare2;
					}
					return compare;					
				}
			});
//			현재위치 기준 가장가까운 위치부터 정렬 완료.
			eat(list.get(0));
			return true;
		}
	}// bfs
	
	private static void eat(int[] fish) {
//		상어를 옮기고
		map[shark.r][shark.c] = 0;
		shark.r = fish[0];
		shark.c = fish[1];
		map[shark.r][shark.c] = 9;
//		물고기를 먹고
		shark.count++;
//		크기만큼 먹으면
		if(shark.count == shark.size) {
//			사이즈 증가 및 마리수 0
			shark.count = 0;
			shark.size++;
		}
//		이동 시간은 상어로부터의 거리.
		time += fish[2];		
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
