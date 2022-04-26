package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_20057_마법사상어와토네이도 {
	
	//						   좌, 하, 우, 상
	private static int[] dr = { 0,  1,  0, -1};
	private static int[] dc = {-1,  0,  1,  0};
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
		
		move();
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
					
					if(!isIn(r,c)) break;
					temp[r][c] = startNum++;
				}
				
				d = (d + 1) % 4;
			}
			size++;
			
			if(startNum >= N * N) break;
		}
		
		for(int[] q : temp) {
			System.out.println(Arrays.toString(q));
		}
		
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
