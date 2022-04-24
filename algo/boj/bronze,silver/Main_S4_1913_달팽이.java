package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_1913_달팽이 {
	//						  하,우, 상, 좌
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int r = 0, c = 0, d = 0, v = N * N;
		while(v > 0) {
			map[r][c] = v--;
			if(v == 0) break;
			while(true) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if((nr < 0 || nr >= N || nc < 0 || nc >= N) || map[nr][nc] != 0) {
					d = (d + 1) % 4;
					continue;
				}
				r = nr;
				c = nc;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		String s = "";
		for(r = 0; r < N; r++) {
			for(c = 0; c < N; c++) {
				sb.append(map[r][c]).append(" ");
				if(map[r][c] == M) {
					s = s+(r+1)+" "+(c+1);
				}
			}
			sb.append("\n");
		}
		sb.append(s);
		System.out.println(sb);
	}

}
