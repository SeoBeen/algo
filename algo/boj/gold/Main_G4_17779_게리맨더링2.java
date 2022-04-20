package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17779_게리맨더링2 {

	private static int N,totalPopulation,min = Integer.MAX_VALUE;
	private static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				totalPopulation += map[i][j];
			}
		}
		
		// 기준점
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				
				// 경계선
				for(int d1 = 1; d1 <= N; d1++) {
					for(int d2 = 1; d2 <= N; d2++) {
						// d1,d2 >= 1
						// 1 <= x < x+d1+d2 <= N
						// 1 <= y-d1 && y+d2 <= N
						if(x+d1+d2 <= N && 1 <= y-d1 && y+d2 <= N) {
							// 5번 선거구 설정
							setArea(x,y,d1,d2);
						}
					}
				}
			}
		}
		System.out.println(min);
	}
	
	private static void setArea(int x, int y, int d1, int d2) {
		boolean[][] area5 = new boolean[N+1][N+1];
		int[] areaSum = new int[6];
		for(int i = 0; i <= d1; i++) {
			// 1. (x, y), (x+1, y-1), ..., (x+d1, y-d1)
			area5[x+i][y-i] = true;
			// 4. (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
			area5[x+d2+i][y+d2-i] = true;
		}
		
		for(int i = 0; i <= d2; i++) {
			// 2. (x, y), (x+1, y+1), ..., (x+d2, y+d2)
			area5[x+i][y+i] = true;
			// 3. (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
			area5[x+d1+i][y-d1+i] = true;			
		}
		
		// 1번 선거구
		for(int r = 1; r < x+d1; r++) {
			for(int c = 1; c <= y; c++) {
				// 경계 만나면 멈추기
				if(area5[r][c]) break;
				areaSum[1] += map[r][c];
			}
		}
		
		// 2번 선거구
		for(int r = 1; r <= x+d2; r++) {
			for(int c = N; c > y; c--) {
				// 경계 만나면 멈추기
				if(area5[r][c]) break;
				areaSum[2] += map[r][c];				
			}
		}

		// 3번 선거구
		for(int r = x+d1; r <= N; r++) {
			for(int c = 1; c < y-d1+d2; c++) {
				// 경계 만나면 멈추기
				if(area5[r][c]) break;
				areaSum[3] += map[r][c];				
			}
		}
		
		// 4번 선거구
		for(int r = x+d2+1; r <= N; r++) {
			for(int c = N ; c >= y-d1+d2; c--) {
				// 경계 만나면 멈추기
				if(area5[r][c]) break;
				areaSum[4] += map[r][c];				
			}
		}
		
		areaSum[5] = totalPopulation;
		for(int i = 1; i <= 4; i++) {
			areaSum[5] -= areaSum[i];
		}
//		System.out.println(Arrays.toString(areaSum));
		
		Arrays.sort(areaSum);
		min = Math.min(min, (areaSum[5]-areaSum[1]));
	}

}
