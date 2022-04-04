package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_11404_플로이드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j)continue;
				map[i][j] = Integer.MAX_VALUE>>2;
			}
		}
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sCity = Integer.parseInt(st.nextToken())-1;
			int eCity = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			map[sCity][eCity] = Math.min(map[sCity][eCity],weight);
		}
		//경 출 도
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				if(k == i) continue;
				for(int j = 0; j < n; j++) {
					if(k == j || i == j) continue;					
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j< n; j++) {
				if(map[i][j] == Integer.MAX_VALUE>>2) map[i][j] = 0;
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
