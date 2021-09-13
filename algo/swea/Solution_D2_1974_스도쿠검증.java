package com.ssafy.afterclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_스도쿠검증 {
	private static int T;
	
	static int[][] arr = new int[9][9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 수
		T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase <= T; tcase++) {
			// 숫자가 안겹치면 1 겹치면 0
			int ans = 1;
			for(int i = 0; i <9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j < 9; j++) {
					// 데이터 입력
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 행체크
			for(int i = 0 ; i<9; i++) {
				boolean[] check = new boolean[9]; 
				for(int j = 0; j<9; j++) {
					// 해당 값의 인덱스를 true 처리
					check[arr[i][j]-1] = true;
				}
				for(int k = 0; k<9; k++) {
					if(!check[k]) {
						ans = 0;
						break;
					}
				}
			}
			// 열체크
			for(int i = 0 ; i<9; i++) {
				boolean[] check = new boolean[9]; 
				for(int j = 0; j<9; j++) {
					// 해당 값의 인덱스를 true 처리
					check[arr[j][i]-1] = true;
				}
				for(int k = 0; k<9; k++) {
					if(!check[k]) {
						ans = 0;
						break;
					}
				}
			}
			// 3 x 3 체크
			for(int i = 0 ; i<=6; i+=3) {
				for(int j = 0; j<=6; j+=3) {
					boolean[] check = new boolean[9];
					int r = i + 3;
					int c = j + 3;
					
					for(int a = i; a<r; a++) {
						for(int b = j; b<c; b++) {
							// 해당 값의 인덱스를 true 처리
							check[arr[a][b]-1] = true;
						}
					}
					for(int k = 0; k<9; k++) {
						if(!check[k]) {
							ans = 0;
							break;
						}
					}
				}
			}
			System.out.println("#"+tcase+" "+ans);
		}
	}
	
	private static boolean checkSquareBitmasking() {
		for(int r = 0; r<9; r+= 3) {
			for(int c = 0; c<9; c+=3) {
				int status = 0; // 상태값을 가지고 있을 변수 하나면 충분 = 32개의 bit 뿐이다.
				for(int r2 = r; r2 < r+3; r2++) {
					for(int c2 = c; c2<c+3; c2++) {
						if((status & 1 << arr[r2][c2]) > 0) { // status에서도 동일 bit에 1을 발견
							return false;
						} else {
							status |= 1 << arr[r2][c2]; // 비트에 arr[r2][c2]의 상태 추가해주기.
						}
					}
				}
			}
		}
		return true;
	}
	// 재귀 형태로 구현해보기.
	// 1. 도대체 뭐하는 메서드 입니까? 출발점을 입력 받아서 가로로 3, 세로로 3의 영역을 확인한다.
	private static boolean checkSquareBitmasking(int r, int c) {
		// 3. 기저조건 처리
		if(c > 6) {
			return checkSquareBitmasking(r+3,0);
		}
		// 마지막까지 모두 성공함.
		if(r > 6) {
			return true;
		}
		
		// 2. 할일을 처리하고 재귀로 자신을 호출한다.
		int status = 0;
		for(int i = r; i<r+3; i++) {
			for(int j = c; j<c+3; j++) {
				if( (status & 1<< arr[i][j]) > 0) {
					return false;
				} else {
					status |= 1<<arr[i][j];
				}
			}
		}
		return checkSquareBitmasking(r, c+3);
	}
}
