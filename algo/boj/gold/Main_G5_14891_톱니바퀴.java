package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_14891_톱니바퀴 {
	private static String[] sawTooth;
	private static int[][] move;
	private static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sawTooth = new String[4];
		for(int i = 0; i < 4; i++) {
			sawTooth[i] = br.readLine();
		}
		K = Integer.parseInt(br.readLine());
		move = new int[K][2];
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 2; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			int current = move[i][0]-1;
			int dir = move[i][1];
			move(current,dir);
		}
	}
	private static void move(int current, int dir) {
		// 2, 6번째 값들 비교후 이동		
		if(current == 0) {
			if(dir == 1) {
				
			}
			else if(dir == -1) {
				
			}
		}
		else if(current == 1) {
			
		}
		else if(current == 2) {
			
		}
		else if(current == 3) {
			
		}
		
	}
}
