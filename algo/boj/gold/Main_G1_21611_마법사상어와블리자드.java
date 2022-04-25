package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G1_21611_마법사상어와블리자드 {

	private static int[][] originalMap, num;
	private static int[] a, b, cnt, dir, spd;
	private static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		originalMap = new int[N+1][N+1];
		num = new int[N+1][N+1];
		a = new int[N * N];
		b = new int[N * N];
		cnt = new int[4];
		dir = new int[M+1];
		spd = new int[M+1];
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1 ; j <= N; j++) {
				originalMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = M; i > 0; i--) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			spd[i] = Integer.parseInt(st.nextToken());
		}
		
		process();
		int ans = 0;
		for(int i = 1; i < 4; i++) {
			ans += (cnt[i] * i);
		}
		System.out.println(ans);
	}
	private static void process(){
		// 달팽이 번호 부여
		snailNum();
		while(M > 0) {
			// 블리자드
			blizard();
			// 구슬 이동
			move();
			// 폭발
			while(boomb());
			// 연속된 숫자 변환
			convert();
			M--;
		}
	}
	private static void snailNum() {
		// 			우, 하, 좌, 상
		int[] dr = {0,  1,  0,  -1};
		int[] dc = {1,  0,  -1,  0};
		int r  = 1, c = 1, d = 0, v = N*N-1;
		while(v > 0) {
			a[v] = originalMap[r][c];
			num[r][c] = v--;
			if(v == 0) break;
			while(true) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if((nr < 1 || nc < 1 || nr > N  || nc > N) || num[nr][nc] != 0) {
					d = (d + 1) % 4;
					continue;
				}

				r = nr;
				c = nc;
				break;
			}
		}
	}
	
	private static void blizard() {

		// 		      상, 하, 좌, 우
		int[] dr = {0, -1,  1,  0, 0};
		int[] dc = {0, 0,  0,  -1, 1};
		int r = (N+1)/2, c = (N+1)/2;
		int d = dir[M];
		int s = spd[M];
		for(int cnt = 0; cnt < s; cnt++) {
			// 조건에서 넘어가지 않는다고 했기 때문에 범위체크는 필요 X
			r += dr[d];
			c += dc[d];
			
			a[num[r][c]] = 0;
		}
		// 빈칸 이동
		move();
	}
	
	private static void move() { // 빈칸 압축 함수
		int last = 0;
		// i가 0인것은 상어위치 이기 때문에 패스
		for(int i = 1; i < N*N; i++) {
			if(a[i] !=0) {
				last++;
				a[last] = a[i];
			}
		}
		for(int i = last+1; i < N *N; i++) {
			a[i] = 0;
		}
	}
	private static boolean boomb() {
		boolean flag = false;
		for(int i = 1; i < N*N && a[i] != 0; i++) {
			int j = i;
			// 범위를 벗어나지 않고
			while(j + 1 < N * N && a[i] == a[j+1]) {
				j++;
			}
			if( j - i + 1 >= 4) {
				cnt[a[i]] += j - i + 1;
				for(int idx = i; idx <= j; idx++) {
					a[idx] = 0;
				}
				flag = true;
			}
			i = j;
		}
		// 빈칸 처리
		move();
		return flag;
	}
	private static void convert() {
		
		for(int i = 1; i < N*N; i++) b[i] = 0;
		
		int last = 0;
		for(int i = 1; i < N*N && a[i] != 0; i++) {
			int j = i;
			// 범위를 벗어나지 않고
			while(j + 1 < N * N && a[i] == a[j+1]) {
				j++;
			}
			int count = j - i +1; int number = a[i];
			if(last < N * N -1) b[++last] = count;
			if(last < N * N -1) b[++last] = number;
			i = j;
		}
		for(int i = 1; i < N * N; i++) a[i] = b[i];
	}

}
