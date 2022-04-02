package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_14889_스타트와링크 {
	
	private static int N, ans;
	private static int[][] map;
	private static boolean[] people;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		people = new boolean[N];		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findTeam(0,0);
	}

	private static void findTeam(int idx, int cnt) {
		// 기저 조건
		if(cnt == N/2) {
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
//			해당 사람이 안뽑혔으면
			if(!people[i]) {
				people[i] = true;
				findTeam(idx+1,cnt+1);
				people[i] = false;
			}
		}
	}
	
	

}
