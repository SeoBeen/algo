package study.boj.prepareIM.submit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {
	private static int N; 	// 파리개수 배열의 크기
	private static int M;	// 파리채 크기
	private static int T; 	// 테스트 케이스 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase <= T; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 파리 배열크기
			M = Integer.parseInt(st.nextToken());	// 파리채 크기
			
			int[][] map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = Integer.MIN_VALUE; 	// 죽은 파리수의 최댓값
			
			for(int i =0; i<=N-M; i++) {
				for(int j = 0; j<=N-M; j++ ) {
					int sum = 0;			// 죽은 파리수의 합
//					파리채 크기만큼 반복
					for(int r = i; r<i+M; r++) {
						for(int c = j; c< j+M; c++) {
							sum += map[r][c];
						}
					}
					ans = Math.max(sum,ans);
				}
			}
		System.out.println("#"+tcase+" "+ans);
		}
	}
}