package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_13458 {
	private static int N, B,C;
	private static int[] people;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		시험장 개수 100만 * 응시자수 100만 => int범위 넘음.
		long ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i =0; i<N; i++) {
			int num = people[i]-B;
//			총감독관
			ans++;
			if(num >0) {
//				부감독관수
				int cnt = num%C == 0 ? num/C : num/C+1;
				ans += cnt;
			}
		}
		System.out.println(ans);
	}
}
