package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194_달이차오른다가자 {
	private static int N,M;
	private static char[][] map;
	private static boolean[][][] visited;
	private static int[] dr = {1,-1,0,0};
	private static int[] dc = {0,0,1,-1};
	
	private static class Position {
		int r, c,key, cnt;

		public Position(int r, int c, int key, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	// 세로 크기
		M = Integer.parseInt(st.nextToken());	// 가로 크기		
		map = new char[N][M];
		visited = new boolean[N][M][64]; 		//ABCDEF 2^6 까지
		Position pos = null;
		
		for(int i =0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == '0') {
					pos = new Position(i,j,0, 0);
				}
			}
		}
		
		System.out.println(bfs(pos));
	}// main
	private static int bfs(Position pos) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(pos);
//		시작점 방문 처리
		visited[pos.r][pos.c][0] = true;
		
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			int key = cur.key;
			int cnt = cur.cnt;
			
			if(map[r][c] == '1') {
				return cnt;
			}
			
			for(int d = 0; d<dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
//					경계 안이고		벽이 아니면서			방문 전이면
				if(isIn(nr,nc) && map[nr][nc] != '#' && !visited[nr][nc][key]) {
//					이때 값이 키일경우
					if(map[nr][nc] >='a' && map[nr][nc] <= 'f') {
//						현재 좌표에 있는 키
						int haskey = 1 << (map[nr][nc] - 'a');
//						비트 연산
						haskey |= key;
//							현재 키에 방문 전이었다면
						if(!visited[nr][nc][haskey]) {
							visited[nr][nc][haskey] = true;
							queue.offer(new Position(nr, nc, haskey, cnt + 1));							
						}
					}
//					문일 경우
					else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						int door = 1 << (map[nr][nc]-'A');
//						해당 문에 맞는 키가 있다면
						if((key & door) != 0) {
							visited[nr][nc][key] = true;
							queue.offer(new Position(nr,nc, key, cnt+1));
						}
					}
//					그 외
					else {
						visited[nr][nc][key] = true;
						queue.offer(new Position(nr,nc,key,cnt+1));
					}
				}
				
			}
		}
//		끝날때까지 못 만남
		return -1;
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && r<N && c >= 0 && c <M;
	}

}// end class
