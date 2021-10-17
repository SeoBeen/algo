package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	private static int N,max,min,totalCnt, map[][]; // max : 연결한 최대 코어수, min : 최소전선길이의 합
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,1,-1};
	private static ArrayList<int[]> list;		// 가장자리가 아닌 코어들의 위치를 저장한 리스트
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=tc; tcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리 코어는 저장하지 않는다.
					if(i ==0 || i == N-1 || j ==0 || j == N-1) continue;
					if(map[i][j] == 1) {
						list.add(new int[] {i,j});
						totalCnt++;	// 가장자리가 아닌 코어 개수
					}
				}
			}
						
			go(0,0);
			
			System.out.println("#"+tcase+" "+min);
		}// tcase
	}// main
	
	private static void go(int index, int cCnt) {	// cCnt : 현재까지 연결된 코어수
//		가지치기
		if(totalCnt-index+cCnt<max) return; // totalCnt-index: 남은 코어수
//		기저조건
		if(index == totalCnt) {
			int res = getLength();
			// 선택된 코어 개수로 max 갱신
			if(max < cCnt) {
				max = cCnt;
				min = res;
			} else if(max == cCnt) {	// 코어개수가 같으면 최소전선길이의 합
				if(min > res) min = res;
			}
			return;
		}
		
		int[] cur = list.get(index);
		int r  = cur[0];
		int c  = cur[1];
		
		// index 코어 선택 : 4방향 시도
		for(int d = 0; d<dc.length; d++) {
			if(isAvailable(r,c,d)) {
				// 전선 놓기
				setStatus(r,c,d,2);
				// 다음 코어로
				go(index+1, cCnt+1);
				// 놓았던 전선 지우기
				setStatus(r,c,d,0);
			}
		}
		
		// index 코어 미선택
		go(index+1,cCnt);
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			map[nr][nc] = s;
		}
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if(map[nr][nc] >= 1) return false;	// 코어나 전선이 있는 경우
		}
		return true;
	}

	private static int getLength() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]> 1) res++;
			}			
		}
		return res;
	}
}

