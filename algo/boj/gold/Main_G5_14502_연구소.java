package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14502_연구소 {

	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static int N,M,max,count;
	private static int[][] map, copyMap;
	private static List<int[]> blankList;
	private static int[][] buildWallList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		blankList = new ArrayList<>();
		buildWallList = new int[3][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					blankList.add(new int[] {i,j});
				}

			}
		}
		// 벽세우기
		buildWall(0,0);
		System.out.println(max);		
	}
	
	private static void buildWall(int idx, int cnt) {
		// 기저조건 벽 3개 다세움
		if(cnt == 3) {
			
			arrayClone();
			// 뽑은 3개 벽세우기
			for(int[] arr : buildWallList) {
				// 벽 세우기
				copyMap[arr[0]][arr[1]] = 1;
			}
			// 바이러스 퍼트리기
			spreadVirus();
			// 안전영역 구하기
			findSafeZone();
			return;
		}
		for(int i = idx; i < blankList.size(); i++) {
			int[] current = blankList.get(i);
			buildWallList[cnt][0] = current[0];
			buildWallList[cnt][1] = current[1];
			buildWall(i+1, cnt+1);
			
		}
	}

	private static void arrayClone() {
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	private static void findSafeZone() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) cnt++;
			}
		}
		max = Math.max(cnt,max);
	}

	private static void spreadVirus() {
		
		Queue<int[]> virusList = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(copyMap[i][j] == 2) virusList.offer(new int[] {i,j});
			}
		}
		
		while(!virusList.isEmpty()) {
			int[] current = virusList.poll();
			int r = current[0];
			int c = current[1];
			// 방문 처리
			
			for(int d = 0 ; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				// 범위 안이고,     빈칸이면
				if(isIn(nr,nc) && copyMap[nr][nc] == 0) {
					copyMap[nr][nc] = 2;
					virusList.add(new int[] {nr,nc});
				}
			}			
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
