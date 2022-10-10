package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G4_15683_감시 {

	private static int N, M, minSpot = 300, size;
	private static int[] rotation = { 4, 2, 4, 4, 1};
	private static int[][] map;
	private static ArrayList<CCTV> cctv;
	
	private static class CCTV {
		int type, r, c;

		public CCTV(int type, int r, int c) {
			super();
			this.type = type;
			this.r = r;
			this.c = c;
		}		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<CCTV>();
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] != 0 && map[r][c] != 6) {
					cctv.add(new CCTV(map[r][c]-1, r, c));
				}
			}
		}
		size = cctv.size();
		dfs(0);
		System.out.println(minSpot);
	}
	
	private static void dfs(int idx) {
		// 기저조건
		if(size == idx) {
			// 빈공간 count
			int temp = 0;
			for(int r = 0 ; r < N; r++) {
				for(int c = 0 ; c < M; c++) {
					if(map[r][c] == 0) temp++;
				}
			}
			if(minSpot > temp) minSpot = temp;
			return;
		}
		int type = cctv.get(idx).type;
		for(int d = 0; d < rotation[type]; d++) {
			int[][] tempMap = new int[N][M];
			// map Backup
			mapCopy(tempMap, map);
			// map update
			if(type == 0) {
				update(d, cctv.get(idx));				
			}
			else if(type == 1) {
				update(d, cctv.get(idx));				
				update(d+2, cctv.get(idx));			
			} else if(type == 2 ) {
				update(d, cctv.get(idx));				
				update(d+1, cctv.get(idx));						
			} else if(type == 3 ) {
				update(d, cctv.get(idx));				
				update(d+1, cctv.get(idx));				
				update(d+2, cctv.get(idx));
			} else if(type == 4 ) {
				update(d, cctv.get(idx));				
				update(d+1, cctv.get(idx));				
				update(d+2, cctv.get(idx));
				update(d+3, cctv.get(idx));
			}
			dfs(idx+1);
			mapCopy(map, tempMap);
			// map return
		}		
	}

	private static void update(int d, CCTV cctv2) {
		d = d % 4;
		// 우
		if(d == 0) {
			for(int c = cctv2.c+1; c < M; c++) {
				if(map[cctv2.r][c] == 6) break;
				map[cctv2.r][c] = -1;
			}
		}
		// 상
		else if (d == 1) {
			for(int r = cctv2.r-1; r >= 0; r--) {
				if(map[r][cctv2.c] == 6) break;
				map[r][cctv2.c] = -1;
			}
		}
		// 좌
		else if(d == 2) {
			for(int c = cctv2.c-1; c >= 0; c--) {
				if(map[cctv2.r][c] == 6) break;
				map[cctv2.r][c] = -1;
			}
		}
		// 하
		else if(d == 3) {
			for(int r = cctv2.r+1; r < N; r++) {
				if(map[r][cctv2.c] == 6) break;
				map[r][cctv2.c] = -1;
			}
		}
	}

	private static void mapCopy(int[][] tempMap2, int[][] map2) {
		for(int r = 0; r< N; r++) {
			for(int c = 0; c < M; c++) {
				tempMap2[r][c] = map2[r][c];
			}
		}
	}
}
