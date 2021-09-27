package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_1535_안녕 {
	private static int N;
	private static int[] hp,happy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hp = new int[N+1];
		happy = new int[N+1];
		int[][] D = new int[N+1][100];
		for(int i = 0; i<2; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				if(i == 0)hp[j] = Integer.parseInt(st.nextToken());
				else happy[j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i<=N; i++) {
//			체력이 0이되거나 음수가 되면 죽는다. 고로 최대 99까지만 써야함.
			for(int p = 1; p<100; p++) {
//				감사인사 가능
				if(hp[i] <= p) {
					D[i][p] = Math.max(D[i-1][p], happy[i] + D[i-1][p-hp[i]]);
				}
//				불가능
				else {
					D[i][p] = D[i-1][p];
				}
			}
		}		
		System.out.println(D[N][99]);
	}
}
