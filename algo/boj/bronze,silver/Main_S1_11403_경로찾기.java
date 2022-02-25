package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_11403_경로찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 경 출 도
		for(int k = 0; k<N; k++) {			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;						
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		// 검사
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
					sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
