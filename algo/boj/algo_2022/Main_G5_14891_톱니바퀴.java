package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14891_톱니바퀴 {
	
	private static int K;
	private static int[][] gear;	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4][8];
		StringTokenizer st;
		for(int i = 0 ; i < 4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String cur = st.nextToken();
			for(int j = 0; j < 8; j++) {				
				gear[i][j] = Integer.parseInt(cur.charAt(j)+"");
			}			
		}
		st = new StringTokenizer(br.readLine()," ");
		K = Integer.parseInt(st.nextToken());
		
		// K번 진행
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			int rotateGear = Integer.parseInt(st.nextToken())-1; // 회전할 톱니
			int rotateDir = Integer.parseInt(st.nextToken()); // 회전할 방향
			int[] gearDir = new int[4];
			
			// region 방향 설정
			// 오른쪽 2 왼쪽 6
			gearDir[rotateGear] = rotateDir;
			for(int leftGear = rotateGear; leftGear >0 ; leftGear--) {
				int rightGear = leftGear - 1;
				if(gear[leftGear][6] == gear[rightGear][2]) break; // 같아서 정지
				gearDir[rightGear] = gearDir[leftGear] * -1; 
			}
			
			for(int rightGear = rotateGear; rightGear < 3; rightGear++) {
				int leftGear = rightGear + 1;
				if(gear[rightGear][2] == gear[leftGear][6]) break;
				gearDir[leftGear] = gearDir[rightGear] * -1;
			}			
			for(int idx = 0 ; idx < 4; idx++) {
				int curGearDir = gearDir[idx];
				
				// 시계방향 회전
				if(curGearDir == 1) {
					// 시계방향은 0번 백업
					int backup = gear[idx][7];
					for(int i = 7; i > 0; i--) {
						gear[idx][i] = gear[idx][i-1];
					}
					gear[idx][0] = backup;
				}
				// 반시계방향 회전
				else if(curGearDir == -1) {
					int backup = gear[idx][0];
					for(int i = 0 ; i < 7; i++) {
						gear[idx][i] = gear[idx][i+1];
					}
					gear[idx][7] = backup;
				}
			}
		} // while 회전 끝
		
		int ans = 0;
		for(int i = 0 ; i < 4; i ++) {
			ans += gear[i][0] << i;
		}
		System.out.println(ans);
		
	}
}
