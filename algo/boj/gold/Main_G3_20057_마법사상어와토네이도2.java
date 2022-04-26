package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_20057_마법사상어와토네이도2 {
	
	//						   좌, 하, 우, 상
	private static int[] dr = { 0,  1,  0, -1};
	private static int[] dc = {-1,  0,  1,  0};
	
	//							상, 상상, 우상, 우하, 하, 하하, 좌하, 좌, 좌좌, 좌상, 우, 우우
	private static int[] sdr = { -1,  -2,   -1,   1,   1,  2,    1,   0,    0 ,  -1,   0,  0 };
	private static int[] sdc = { 0,   0,    1,    1,   0,  0 ,   -1,  -1,   -2,  -1,   1,  2 };
	private static int N, ans;
	private static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int[] q : map) {
			System.out.println(Arrays.toString(q));
		}
		move();
		System.out.println(ans);
	}

	private static void move() {
		// 중앙 값
		int r = N/2; int c = N/2;
		
		int[][] temp = new int[N][N];
		temp[r][c] = 1;
		int d = 0;
		int startNum = 2;
		int size = 1;
		while(true) {
			int two = 2;
			while(two-- > 0) {
				
				for(int i = 0; i < size; i++) {
					r += dr[d];
					c += dc[d];
					System.out.println(startNum);
					if(!isIn(r,c)) break;
					startNum++;
					
					int nowSand = map[r][c];
					if(nowSand == 0) continue;
					System.out.println("이동전 현재 모래 값 : "+nowSand);
					for(int[] q : map) {
						System.out.println(Arrays.toString(q));
					}
					map[r][c] = 0;
					if(d == 0) {
						//							0    1    2     3     4    5     6    7     8     9
						//							상, 상상, 우상, 우하, 하, 하하, 좌하, 좌, 좌좌, 좌상
						for(int wayIdx = 0; wayIdx < 10; wayIdx++) {
							
							int nr = r + sdr[wayIdx];
							int nc = c + sdc[wayIdx];
							
							int moveSand = 0;
							// 상, 하
							if(wayIdx == 0 || wayIdx == 4) {
								moveSand = (int) Math.floor(nowSand * (double)0.07);
							}
							// 상상, 하하
							else if(wayIdx == 1 || wayIdx == 5) {
								moveSand = (int) Math.floor(nowSand * (double) 0.02);
							}
							// 우상, 우하
							else if(wayIdx == 2 || wayIdx == 3) {
								moveSand = (int) Math.floor(nowSand * (double) 0.01);
							}
							// 좌하, 좌상
							else if(wayIdx == 6 || wayIdx == 9) {
								moveSand = (int) Math.floor(nowSand * (double) 0.1);
							}
							// 좌좌
							else if(wayIdx == 8) {
								moveSand = (int) Math.floor(nowSand * (double) 0.05);
							}
							else { // wayIdx == 7
								moveSand = nowSand - (int) Math.floor(nowSand *(double)  0.45);
							}
							System.out.println("moveSand : "+ moveSand);
							// 범위 벗어나면 값만큼 더하기
							if(!isIn(nr,nc)) {		
								System.out.println("지금 더해진다");
								System.out.println(moveSand);
								ans += moveSand;
								continue;
							}
							
							// 그게 아니면
							map[nr][nc] += moveSand;
						}
					}
					else if (d == 1) {
						//							0    1    2     3     4    5     6    7     8     9   10   11
						//							상, 상상, 우상, 우하, 하, 하하, 좌하, 좌, 좌좌, 좌상, 우, 우우
						for(int wayIdx = 2; wayIdx < 12; wayIdx++) {
							
							int nr = r + sdr[wayIdx];
							int nc = c + sdc[wayIdx];
							
							int moveSand = 0;
							// 좌, 우
							if(wayIdx == 7 || wayIdx == 10) {
								moveSand = (int) Math.floor(nowSand * (double) 0.07);
							}
							// 좌좌, 우우
							else if(wayIdx == 8 || wayIdx == 11) {
								moveSand = (int) Math.floor(nowSand * (double) 0.02);
							}
							// 좌상, 우상
							else if(wayIdx == 2 || wayIdx == 9) {
								moveSand = (int) Math.floor(nowSand * (double) 0.01);
							}
							// 좌하, 우하
							else if(wayIdx == 6 || wayIdx == 3) {
								moveSand = (int) Math.floor(nowSand * (double) 0.1);
							}
							// 하하
							else if(wayIdx == 5) {
								moveSand = (int) Math.floor(nowSand * (double) 0.05);
							}
							else { // wayIdx == 4 하
								moveSand = nowSand - (int) Math.floor(nowSand * (double) 0.45);
							}
							System.out.println("moveSand : "+ moveSand);
							// 범위 벗어나면 값만큼 더하기
							if(!isIn(nr,nc)) {			
								System.out.println("지금 더해진다");
								System.out.println(moveSand);
								ans += moveSand;
								continue;
							}
							
							// 그게 아니면
							map[nr][nc] += moveSand;
						}
					}
					else if (d == 2) {
						//							0    1    2     3     4    5     6    7     8     9   10   11
						//							상, 상상, 우상, 우하, 하, 하하, 좌하, 좌, 좌좌, 좌상, 우, 우우
						for(int wayIdx = 0; wayIdx < 12; wayIdx++) {
							if(wayIdx == 7 || wayIdx == 8) continue;
							int nr = r + sdr[wayIdx];
							int nc = c + sdc[wayIdx];
							
							int moveSand = 0;
							// 상, 하
							if(wayIdx == 0 || wayIdx == 4) {
								moveSand = (int) Math.floor(nowSand * (double) 0.07);
							}
							// 상상, 하하
							else if(wayIdx == 1 || wayIdx == 5) {
								moveSand = (int) Math.floor(nowSand * (double) 0.02);
							}
							// 좌상, 좌하
							else if(wayIdx == 6 || wayIdx == 9) {
								moveSand = (int) Math.floor(nowSand * (double) 0.01);
							}
							// 우상, 우하
							else if(wayIdx == 2 || wayIdx == 3) {
								moveSand = (int) Math.floor(nowSand * (double) 0.1);
							}
							// 우우
							else if(wayIdx == 11) {
								moveSand = (int) Math.floor(nowSand * (double) 0.05);
							}
							else { // wayIdx == 10 우
								moveSand = nowSand - (int)Math.floor(nowSand * (double) 0.45);
							}
							System.out.println("moveSand : "+ moveSand);
							// 범위 벗어나면 값만큼 더하기
							if(!isIn(nr,nc)) {			
								System.out.println("지금 더해진다");
								System.out.println(moveSand);
								ans += moveSand;
								continue;
							}
							
							// 그게 아니면
							map[nr][nc] += moveSand;
						}
					}
					else if (d == 3) {
						//							0    1    2     3     4    5     6    7     8     9   10   11
						//							상, 상상, 우상, 우하, 하, 하하, 좌하, 좌, 좌좌, 좌상, 우, 우우
						for(int wayIdx = 0; wayIdx < 12; wayIdx++) {
							if(wayIdx == 4 || wayIdx == 5) continue;
							int nr = r + sdr[wayIdx];
							int nc = c + sdc[wayIdx];
							
							int moveSand = 0;
							// 좌, 우
							if(wayIdx == 7 || wayIdx == 10) {
								moveSand = (int) Math.floor(nowSand * (double) 0.07);
							}
							// 좌좌, 우우
							else if(wayIdx == 8 || wayIdx == 11) {
								moveSand = (int) Math.floor(nowSand * (double) 0.02);
							}
							// 좌상, 우상
							else if(wayIdx == 2 || wayIdx == 9) {
								moveSand = (int) Math.floor(nowSand * (double) 0.1);
							}
							// 좌하, 우하
							else if(wayIdx == 6 || wayIdx == 3) {
								moveSand = (int) Math.floor(nowSand * (double) 0.01);
							}
							// 상상
							else if(wayIdx == 1) {
								moveSand = (int) Math.floor(nowSand * (double) 0.05);
							}
							else { // wayIdx == 0 상
								moveSand = nowSand - (int)Math.floor(nowSand * (double) 0.45);
							}
							System.out.println("moveSand : "+ moveSand);
							// 범위 벗어나면 값만큼 더하기
							if(!isIn(nr,nc)) {			
								System.out.println("지금 더해진다");
								System.out.println(moveSand);
								ans += moveSand;
								continue;
							}
							
							// 그게 아니면
							map[nr][nc] += moveSand;
						}
					}
					
					System.out.println("이동후");
					for(int[] q : map) {
						System.out.println(Arrays.toString(q));
					}
				}
				d = (d + 1) % 4;
			}
			size++;
			
			if(startNum >= N * N) break;
		}
		
//		for(int[] q : map) {
//			System.out.println(Arrays.toString(q));
//		}
		
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
