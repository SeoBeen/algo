package programmers;

import java.util.Arrays;

public class Main_쿼드압축후개수세기 {

	private static int[] answer = new int[2];
	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0},
						{1,0,0,0},
						{1,0,0,1},
						{1,1,1,1}};
		// 가로,세로 길이
		int N = arr.length;
		
		for(int r = 0; r<N; r+= N/2) {
			for(int c = 0; c < N; c+= N/2) {
				quadTree(arr,r,c, N/2);
			}
		}
		System.out.println(Arrays.toString(answer));
	}

	private static void quadTree(int[][] arr, int r, int c, int length) {
		// 기저조건
		// 끝까지 다 반복했으면
		if(length == 1) {
			answer[arr[r][c]]++;
			return;
		}
		
		boolean flag = false;
		
		// 첫 시작 좌표 값
		int start = arr[r][c];
		
		for(int i = r; i< r+length; i++) {
			for(int j = c; j < c+length; j++) {
				// 값이 다르면
				if(arr[i][j] != start) {					
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		
		// 다 같으면 그냥 저장
		if(!flag) {			
			answer[start] ++;
		}
		else {
			quadTree(arr, r, c, length/2);
			quadTree(arr, r+length/2, c, length/2);
			quadTree(arr, r, c+length/2, length/2);
			quadTree(arr, r+length/2, c+length/2, length/2);
		}

	}

}
