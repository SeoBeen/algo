package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_14889_스타트와링크 {
	
	private static int N, ans = Integer.MAX_VALUE;
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
		System.out.println(ans);
	}

	private static void findTeam(int idx, int cnt) {
		if(idx == N) return;
		// 기저 조건
		if(cnt == N/2) {
			int sTeam=0, lTeam=0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j< N; j++) {
					if(people[i] && people[j]) sTeam += map[i][j];
					if(!people[i] && !people[j]) lTeam += map[i][j];
				}
			}
			ans = Math.min(ans, Math.abs(sTeam-lTeam));			
			return;
		}
	
		
//		해당 사람 뽑기
		people[idx] = true;
		findTeam(idx+1, cnt+1);
//		해당 사람 안뽑기
		people[idx] = false;
		findTeam(idx+1,cnt);
	}
	
	

}
