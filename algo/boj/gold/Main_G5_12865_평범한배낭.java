package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_12865_평범한배낭 {
	private static int N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] weights = new int[N+1];
		int[] values = new int[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		int[][] D = new int[N+1][K+1];
		for(int i = 1; i<=N; i++) {
//			버틸 수 있는 무게
			for(int j = 1; j<=K; j++) {
				if(weights[i] <= j) {	// 해당 물건을 넣을수 있다.
//										안넣은것	현재무게 뺀 값과	현재 물건의 가치
					D[i][j] = Math.max(D[i-1][j], D[i-1][j-weights[i]]+ values[i]);
				}
//				물건 못 넣음
				else {
					D[i][j] = D[i-1][j];
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
