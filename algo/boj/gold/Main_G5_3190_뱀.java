package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.DelayQueue;

public class Main_G5_3190_뱀 {
//							  우,하, 좌,상
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static int N,dir,time;
	private static int[][] map;
	private static Queue<String> queue = new LinkedList<>();
	
	private static class Snake {
		// 머리 좌표, 길이, 현재 방향
		int r, c;

		public Snake(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1;			
		}
		int L = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < L; i++) {
			// 방향전환 저장
			queue.offer(br.readLine());
		}
		
		move();
		System.out.println(time);
	}
	
	private static void move() {
		// 뱀 표시
		map[0][0] = 2;
		
		Deque<Snake> snake = new LinkedList<Snake>();
		//					r,c
		snake.offer(new Snake(0,0));
		String[] turn = queue.poll().split(" ");
		int changeTime = Integer.parseInt(turn[0]);
		char changeDir = turn[1].charAt(0);
		
		while(true) {
			// 시간 증가
			time++;
			// 머리
			Snake current = snake.peekLast();
			// first 는 꼬리
			
			// 이동하기
			int nr = current.r + dr[dir];
			int nc = current.c + dc[dir];
			// 범위 밖이거나  내 몸이면 종료				
			if(!isIn(nr,nc) || map[nr][nc] == 2) break;
			
			// 사과가 있다면 꼬리는 움직이지 않고 사과는 없어짐.
			if(map[nr][nc] == 1) {
				map[nr][nc] = 2;
				// 머리 이동
				snake.offerLast(new Snake(nr,nc));
			}
			// 사과가 없다면
			else if(map[nr][nc] == 0) {
				map[nr][nc] = 2;
				// 머리 이동
				snake.offerLast(new Snake(nr,nc));
				// 꼬리 비워주기
				Snake tail = snake.pollFirst();
				map[tail.r][tail.c] = 0;
			}
			// 회전할 시간이면 멈춰서 회전하기.
			if(time == changeTime) {
				// 회전하기
				if(changeDir == 'L') {
					dir = (dir + 3)%4;
				}
				else if(changeDir == 'D') {
					dir = (dir + 1) %4;
				}
				if(!queue.isEmpty()) {
					turn = queue.poll().split(" ");
					changeTime = Integer.parseInt(turn[0]);
					changeDir = turn[1].charAt(0);					
				}
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >=0 && c < N;
	}
}
