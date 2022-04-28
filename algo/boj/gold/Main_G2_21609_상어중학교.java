package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_21609_상어중학교 {
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static Queue<int[]> maxGroupList, currentGroupList;
	private static int N,M,totalScore, maxRainbowCnt;
	private static boolean flag;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		process();
		System.out.println(totalScore);
	}
	private static void process() {
		// 블록그룹이 존재하는동안 계속 된다.
		
		while(true) {
			// 1. 가장 큰 블록그룹 찾기
			boolean flag = findBigGroup();
			if(!flag) break;
			// 2. 해당 블록 그룹 제거
			getPoint();
			
			// 3. 중력 작용
			gravity();
			// 4. 반시계 방향 회전
			rotate();
			// 5. 다시 중력 작용.
			gravity();
		}
	}
	
	private static void rotate() {
		int[][] temp = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				temp[N-c-1][r] = map[r][c];
			}
		}
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = temp[r][c];
			}
		}
	}
	
	private static void gravity() {

		for(int c = 0; c < N; c++) {
			int blank = 0;
			for(int r = N-1; r > -1 ; r--) {
				
				if(map[r][c] == -2) {
					blank++;
				}
				else if(map[r][c] == -1) {
					blank = 0;
				}
				else {
					if(blank != 0 ) {
						map[r+blank][c] = map[r][c];
						map[r][c] = -2;
					}
				}
			}
		}
	}
	
	private static void getPoint() {
		totalScore += (maxGroupList.size() * maxGroupList.size());
		for(int[] current : maxGroupList) {
			// 빈칸처리
			map[current[0]][current[1]] = -2;
		}
	}
	
	private static boolean findBigGroup() {
		
		maxGroupList = new LinkedList<>();
		flag = false;
		for(int num = 1; num <= M; num++) {
			// 무지개는 반복 가능하기 때문에 해당 숫자마다 새로 생성
			visited = new boolean[N][N];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					
					if(map[r][c] == num && !visited[r][c]) {
						
						currentGroupList = new LinkedList<>();
						findGroup(r,c, num);
					}
				}
			}			
		}
		return flag;
	}
	
	private static void copyList(Queue<int[]> currentGroupList2) {
		maxGroupList.clear();
		for(int[] arr : currentGroupList2) {
			maxGroupList.add(arr);
		}
	}
	
	private static void findGroup(int i, int j, int num) {
		
		Queue<int[]> list = new LinkedList<>();
		visited[i][j] = true;
		list.offer(new int[] {i,j});
		currentGroupList.add(new int[] {i,j});
		
		// 무지개 갯수
		int currentRainbowCnt = 0;
		
		while(!list.isEmpty()) {
			int[] current = list.poll();
			int r = current[0];
			int c = current[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 범위 안이고,   방문전이고			현재 숫자와 같거나 무지개이면
				if(isIn(nr,nc) && !visited[nr][nc] && (map[nr][nc] == num || map[nr][nc] == 0)) {
					// 사이즈 증가 , 방문처리, 현재 그룹 리스트에 추가
					
					visited[nr][nc] = true;
					list.offer(new int[] {nr,nc});
					currentGroupList.add(new int[] {nr,nc});
					if(map[nr][nc] == 0) currentRainbowCnt++;
				}
			}
		}
		
		// 그룹을 찾았다.
		// 그룹 크기가 2이상일때
		if(currentGroupList.size() > 1) {
			flag = true;
			// 현재 크기보다 크면
			if(maxGroupList.size() < currentGroupList.size()) {
				copyList(currentGroupList);
				maxRainbowCnt = currentRainbowCnt;
			}
			// 크기가 같으면
			else if(maxGroupList.size() == currentGroupList.size()) {
				// 무지개 블럭 개수로 비교
				if(maxRainbowCnt < currentRainbowCnt) {
					copyList(currentGroupList);
					maxRainbowCnt = currentRainbowCnt;
				}
				// 무지개 블럭 개수도 같으면
				else if(maxRainbowCnt == currentRainbowCnt) {
					// 기준 블록의 행이 가장 큰것 => 열이 가장큰것
					// Queue를 썻기 때문에 제일 첫번째가 제일 큰 기준값이다.
					int[] maxList = maxGroupList.peek();
					int[] currentList = currentGroupList.peek();
					
					// 행 기준
					if(maxList[0] < currentList[0]) {
						copyList(currentGroupList);
						maxRainbowCnt = currentRainbowCnt;						
					}
					else if(maxList[0] == currentList[0]) {
						if(maxList[1] < currentList[1]) {
							copyList(currentGroupList);
							maxRainbowCnt = currentRainbowCnt;	
						}
					}
				}
			}
		}
	}
	
	private static boolean isIn(int r, int c ) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
