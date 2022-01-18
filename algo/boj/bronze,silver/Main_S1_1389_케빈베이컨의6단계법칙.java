package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = Integer.MAX_VALUE>>2;
		int[][] map = new int[N][N];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		// 연결 안된 지점 최댓값으로 변환
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(i!=j && map[i][j] == 0) {
					map[i][j] = max;
				}
			}
		}
		
		//경 출 도
		for(int k = 0; k<N; k++) {
			for(int i = 0; i<N; i++) {
				if(i == k) continue;
				for(int j= 0; j<N; j++) {
					if(k == j && i == j) continue;					
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE>>2;
		int idx = -1;
		for(int i = 0; i<N; i++) {
			int num = 0;
			for(int j = 0; j<N; j++) {
				num += map[i][j];
			}
			if(num< ans) {
				ans = num;
				idx = i;
			}
			
		}
		System.out.println(idx+1);
	}

}
