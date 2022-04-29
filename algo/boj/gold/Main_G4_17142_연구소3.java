package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_17142_연구소3 {
//							  상,하,좌,우
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int[][] map;
	private static int[] selectedVirus;
	private static int N,M,zeroCnt, time = Integer.MAX_VALUE;
	private static ArrayList<int[]> virusList = new ArrayList<>();
	private static boolean totalFlag = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		selectedVirus = new int[M];
		
		for(int r = 0 ; r < N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 바이러스 이면 바이러스 명단에 추가
				if(map[r][c] == 2) {
					virusList.add(new int[] {r,c});
				}
				if(map[r][c] == 0) zeroCnt++;
			}
		}
		if(zeroCnt == 0) {
			System.out.println(0);
			return;
		}
		putVirus(0,0);
		if(!totalFlag) System.out.println(-1);
		else System.out.println(time);
	}



	private static void putVirus(int idx, int cnt) {
		// 바이러스를 다 놓았다. 
		if(cnt == M) {
//			System.out.println(Arrays.toString(selectedVirus));
			int zCnt = zeroCnt;
			int currentTime = 0;
			boolean[][] visited = new boolean[N][N];
			// 복사용 맵
			int[][] temp = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					temp[r][c] = map[r][c];
				}
			}
			
			Queue<int[]> list = new LinkedList<int[]>();
			// 선택된 바이러스들 넣기
			for(int i = 0; i < M; i++) {
				int[] current = virusList.get(selectedVirus[i]); 
				list.offer(current);
				// 선택된 바이러스 방문 처리
				visited[current[0]][current[1]] = true;
			}
			boolean zFlag = false;
			// 퍼진 바이러스 중심으로 진행하기
			while(!list.isEmpty()) {
				int size = list.size();
				while(size-- > 0) {
					int[] current = list.poll();
					int r = current[0];
					int c = current[1];
					
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 범위 벗어나거나 벽이거나 방문했으면 패스
						if(!isIn(nr,nc) || temp[nr][nc] == 1 || visited[nr][nc]) continue;
						
						if(temp[nr][nc] == 0) zCnt--;
						
						// 방문처리하고 다음 확산될 곳으로 추가
						visited[nr][nc] = true;
						// 빈칸 흔적 없애기
						temp[nr][nc] = -1;
						list.offer(new int[] {nr,nc});						
						// 만약 빈칸이 모두 사라지면 정지
						if(zCnt == 0) {
							zFlag = true;
							break;
						}
					}
					if(zFlag) break;
				}
				// 시간 증가
				currentTime++;
				if(zFlag) break;
			}		

			// 안퍼진곳이 없다면 time값 갱신 아니라면 패스.
			if(zFlag) {
				totalFlag = true;
				time = Math.min(time, currentTime);
			}
			return;
		}
		
		for(int i = idx; i < virusList.size(); i++) {
			selectedVirus[cnt] = i;
			putVirus(i+1, cnt+1);
		}
		
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
 