package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_14891_톱니바퀴 {
	private static String[] sawTooth;
	private static int[][] move;
	private static int K,score;
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
		
		
		if(sawTooth[0].charAt(0) != '0') score+=1;
		if(sawTooth[1].charAt(0) != '0') score+=2;
		if(sawTooth[2].charAt(0) != '0') score+=4;
		if(sawTooth[3].charAt(0) != '0') score+=8;
		System.out.println(score);
	}
	private static void move(int current, int dir) {
		// 0 : 12시 값
		// 2, 6번째 값들 비교후 이동
		// 같으면 회전 X 다르면 해당 방향과 반대로 회전
		String gear1 = sawTooth[0];
		String gear2 = sawTooth[1];
		String gear3 = sawTooth[2];
		String gear4 = sawTooth[3];
		boolean flag1 = gear1.charAt(2) == gear2.charAt(6);
		boolean flag2 = gear2.charAt(2) == gear3.charAt(6);
		boolean flag3 = gear3.charAt(2) == gear4.charAt(6);
		// 회전 방향, 기본값은 회전하지 않음.
		int[] dirs = new int[] {0,0,0,0};

		if(current == 0) {
			dirs[0] = dir;
			// 값이 다르면
			if(!flag1) {
				dirs[1] = dirs[0] == 1 ? -1 : 1;
				if(!flag2) {
					dirs[2] = dirs[1] == 1 ? -1 : 1;
					if(!flag3) {
						dirs[3] = dirs[2] == 1 ? -1 : 1;
					}
				}
			}
		}
		else if(current == 1) {
			dirs[1] = dir;
			// 값이 다르면
			if(!flag1) {
				dirs[0] = dirs[1] == 1 ? -1 : 1;
			}
			if(!flag2) {
				dirs[2] = dirs[1] == 1 ? -1 : 1;
				if(!flag3) {
					dirs[3] = dirs[2] == 1 ? -1 : 1;
				}
			}
		}
		else if(current == 2) {
			dirs[2] = dir;
			// 값이 다르면
			if(!flag2) {
				dirs[1] = dirs[2] == 1 ? -1 : 1;
				if(!flag1) {
					dirs[0] = dirs[1] == 1 ? -1 : 1;
				}
			}
			if(!flag3) {
				dirs[3] = dirs[2] == 1 ? -1 : 1;
			}
		}
		else if(current == 3) {
			dirs[3] = dir;
			// 값이 다르면
			if(!flag3) {
				dirs[2] = dirs[3] == 1 ? -1 : 1;
				if(!flag2) {
					dirs[1] = dirs[2] == 1 ? -1 : 1;
					if(!flag1) {
						dirs[0] = dirs[1] == 1 ? -1 : 1;
					}
				}
			}
		}
		
		// 회전 방향 구하기 끝
		for(int i = 0 ; i < 4; i++) {
			String temp = "";
			// 회전 안함
			if(dirs[i] == 0) continue;
			
			// 시계방향 회전
			if(dirs[i] == 1) {
				temp = sawTooth[i].charAt(7)+sawTooth[i].substring(0, 7);
			}
			// 반시계방향 회전
			else if(dirs[i] == -1) {
				temp = sawTooth[i].substring(1, 8)+sawTooth[i].charAt(0);				
			}
			sawTooth[i] = temp;
		}
	} // move
}
