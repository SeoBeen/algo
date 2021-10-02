package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G2_17143_낚시왕 {
	private static int R,C,M,ans;
	private static Shark[][] map;
	private static ArrayList<Shark> list;
//								  상, 하, 우, 좌
	private static int[] dr = { 0, -1, 1,  0,  0};
	private static int[] dc = { 0, 0,  0,  1, -1};
	
	private static class Shark implements Comparable<Shark> {
		int r,c,s,d,z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
//			열 기준 -> 행기준 -> 크기기준 순으로 정렬
			if(this.c == o.c) {
				if(this.r == o.r) {
					return this.z - o.z;
				}
				else return this.r - o.r;
			}
			else return this.c - o.c;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Shark [r=").append(r).append(", c=").append(c).append(", s=").append(s).append(", d=")
					.append(d).append(", z=").append(z).append("]");
			return builder.toString();
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<Shark>();
		ans = 0;

		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
//			상어 저장
			list.add(new Shark(r,c,s,d,z));
		}
		
//		낚시꾼 움직이고
		for(int fisher = 1; fisher<=C; fisher++) {
//			낚시하고
			fishing(fisher);
//			상어 움직이고
//			System.out.println("fisher : "+fisher);
			moving();
		}
		
		System.out.println(ans);
	}//main
	
	private static void moving() {
//		이동하는 행 또는 열 -1 * 2 => 1바퀴 기준
//		상어 저장할 맵
		map = new Shark[R+1][C+1];
		
		for(int i = 0; i<list.size(); i++) {
			int curR = list.get(i).r;
			int curC = list.get(i).c;
			int sharkSpeed = list.get(i).s;
			int dir = list.get(i).d;
			int sharkSize = list.get(i).z;
			
//			방향 조건 탐색
//			상,하 일경우
			int moveRotation = 0;
			if(dir == 1 || dir == 2) {
				moveRotation = (R-1)*2;
			}
//			좌,우 일경우
			else if(dir == 3 || dir == 4) {
				moveRotation = (C-1)*2;
			}			
			
			int move = sharkSpeed % moveRotation;
			
			for(int moveCnt = 0; moveCnt<move; moveCnt++){
				curR = curR + dr[dir];
				curC = curC + dc[dir];
				if(isIn(curR,curC)) {
					continue;
				}
//				벽을 만날 경우
				else {
//					다시 돌아가고
					curR -= dr[dir];
					curC -= dc[dir];
//							상,하,좌,우
//							1,  2, 3, 4
					dir = dir %2 == 0 ? dir-1 : dir +1;
//					방향 바꿔서
					curR += dr[dir];
					curC += dc[dir];
					
				}
			} // moveCnt for

			
//			이동이 끝남 
//			비어있을 경우 바로 저장
//			System.out.println("curR : "+ curR + " curC : "+curC);
//			System.out.println("size : "+sharkSize);
			if(map[curR][curC] == null ) {
				map[curR][curC] = new Shark(curR,curC,sharkSpeed,dir,sharkSize);
			}
//			아닐 경우
			else if(map[curR][curC].z < sharkSize ) {
//				큰거에 잡아먹힘
				map[curR][curC] = new Shark(curR,curC,sharkSpeed,dir,sharkSize);
			}
			
		} // list
		list.clear();
//		for(Shark[] c : map) {
//			System.out.println(Arrays.toString(c));
//		}
		for(int r = 1; r <= R; r++) {
			for(int c = 1; c<=C; c++) {
				if(map[r][c] != null) {
					list.add(map[r][c]);
//					System.out.println(map[r][c]);
				}
			}
		}
	} // moving
	
	private static void fishing(int fisher) {
//		열 -> 행 -> 크기 순으로 상어 정렬
		Collections.sort(list);
		int size = list.size();
		for(int i = 0; i<size; i++) {
//			낚시꾼 열에 상어가 있다.
			if(list.get(i).c == fisher) {
//				상어 크기 저장
				ans += list.get(i).z;
//				잡은 상어 없애기
				list.remove(i);
//				낚시 끝
				return;				
			}
		}		
	}// fishing
	
	private static boolean isIn(int r, int c) {
		return r > 0 && r <= R && c > 0 && c <=C;
	}

}//end class
