package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_20055_컨베이어벨트위의로봇 {

	private static int N,K,answer,cnt;
	private static int[] map;
	private static boolean[] robots;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 벨트 길이
		N = Integer.parseInt(st.nextToken());
		// 내구도 0인 칸의 개수
		K = Integer.parseInt(st.nextToken());
		map = new int[2*N];
		// 로봇 존재 유무 파악
		robots = new boolean[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < 2*N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		while(true) {
			answer++;
			// 회전
			turn();
			// 한칸 이동이 가능하다면 이동
			move();
			// 올리는 위치에 내구도가 0이 아니라면 로봇 올리기
			uploadRobot();
			if(cnt >= K) break;
		}
		System.out.println(answer);
	}

	private static void uploadRobot() {
		// 올리는 위치에 로봇이 없고 0보다 크면
		if(!robots[0] && map[0] > 0) {
			robots[0] = true;
			if(--map[0] == 0) cnt++;
		}
	}

	private static void move() {
		// 내리는 위치에 있으면 없애준다.
		if(robots[N-1]) robots[N-1] = false;
		
		for(int i = N-2; i >= 0; i--) {
			// 로봇이 없으면 패스
			if(!robots[i]) continue;
			
			// 다음 위치가 0보다 크고 로봇이 없으면
			if(map[i+1] > 0 && !robots[i+1]) {
				robots[i] = false;
				robots[i+1] = true;
				// 1을 빼서 0이 되면 갯수 증가
				if(--map[i+1] == 0) cnt++;
			}
		}
		if(robots[N-1]) robots[N-1] = false;		
	}
	private static void turn() {
		// 컨베이어 벨트 회전
		int temp = map[map.length-1];
		for(int i = map.length-1; i > 0; i--) {
			map[i] = map[i-1];
		}
		map[0] = temp;
		// 로봇 회전
		for(int i = N-1; i > 0; i--) {
			robots[i] = robots[i-1];
		}
		// 시작위치와 내리는 위치는 로봇이 없다.
		robots[0] = false;
	}
}
