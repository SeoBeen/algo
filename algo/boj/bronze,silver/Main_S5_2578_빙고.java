package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2578_빙고 {
	private static int[][] map = new int[5][5];
	private static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j<5; j++) {
				if(lineCheck(Integer.parseInt(st.nextToken())) >=3) {
					System.out.println((5*i) + (j+1));
					return;
				}				
			}
		}
	}
	private static int lineCheck(int n) {
		int ans = 0;
		for(int i = 0 ; i<5; i++) {
			for(int j = 0; j<5; j++) {
//				사회자가 부른 번호 0으로 변환.
				if(map[i][j] == n) {
					map[i][j] = 0;
				}
			}
		}
		
//		가로 확인
		for(int i = 0; i<5; i++) {
			boolean flag = true;
			for(int j = 0; j<5; j++) {
				if(map[i][j] > 0) {
//					안불린 값이 있으면 false로 처리
					flag = false; 
				}
			}
//			전부다 0 => 빙고
			if(flag) ans++;
		}
//		세로 확인
		for(int i = 0; i<5; i++) {
			boolean flag = true;
			for(int j = 0; j<5; j++) {
				if(map[j][i] > 0) {
//					안불린 값이 있으면 false로 처리
					flag = false; 
				}
			}
//			전부다 0 => 빙고
			if(flag) ans++;
		}
		
//		우하 대각선
		boolean flag = true;
		for(int j = 0; j<5; j++) {
			if(map[j][j] > 0) {
//					안불린 값이 있으면 false로 처리
				flag = false; 
			}
		}
//			전부다 0 => 빙고
		if(flag) ans++;
		
//		우상 대각선
		flag = true;
		for(int j = 0; j<5; j++) {
			if(map[4-j][j] > 0) {
//				안불린 값이 있으면 false로 처리
				flag = false; 
			}
		}
//			전부다 0 => 빙고
		if(flag) ans++;		
		return ans;
	}

}
