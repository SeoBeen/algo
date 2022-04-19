package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_15684_사다리조작 {

	private static int N,M,H, ans;
	private static int[][] map;
	private static boolean isFinish;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			// 0부터 시작
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1;
			map[r][c+1] = 2;				
		}
		for(int i = 0; i < 4; i++) {
			ans = i;
			drawLine(0,0);
			if(isFinish) break;
		}
		
		System.out.println(isFinish ? ans : -1);
	}
	private static void drawLine(int start, int count) {
		// 끝나면 종료
		if(isFinish) return;
		// 기저조건
		// 추가한 선의 개수가 되면
		if(ans == count) {
			if(check()) isFinish = true;
			return;
		}
		
		for(int i = start; i < H; i++) {
			for(int j = 0; j < N-1; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					drawLine(i,count+1);
					// 복구
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
	}
	private static boolean check() {
		for(int startC = 0; startC < N; startC++) {
			int c = startC;
			int r = 0;
			for(int moveCnt = 0; moveCnt < H; moveCnt++) {
				// 오른쪽 이동
				if(map[r][c] == 1) c++;
				// 왼쪽으로 이동
				else if(map[r][c] == 2) c--;
				r++;
			}
			// 돌아온 곳의 열값이 출발지와 같은지 확인
			if(c != startC) return false;
		}
		return true;
	}
}
