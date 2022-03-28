package leetcode;

import java.util.Arrays;

public class Solution_1337 {

	public static void main(String[] args) {
		int[][] mat = {{1,1,0,0,0},
			 {1,1,1,1,0},
			 {1,0,0,0,0},
			 {1,1,0,0,0},
			 {1,1,1,1,1}};
		int k = 3;
		
		int[] cntOne = new int[mat.length];
		for(int i = 0; i< mat.length; i++) {
			int cnt = 0;
			for(int j = 0; j < mat[i].length; j++) {
				if(mat[i][j] == 1) cnt++;
			}
			cntOne[i] = cnt;
		}
		
		int[] answer = new int[k];
		
		for(int i = 0; i < k; i++) {
			// 1이 최대 100개
			int min = 101;
			int idx = 0;
			for(int j = 0; j < cntOne.length; j++){
                if(cntOne[j] < min){
                    min = cntOne[j];
                    idx = j;
                }
            }
			answer[i] = idx;
			// 사용한거 표시
			cntOne[idx] = 102;
		}
		System.out.println(Arrays.toString(answer));
	}

}
