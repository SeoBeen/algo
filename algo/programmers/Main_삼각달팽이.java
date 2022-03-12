package programmers;

public class Main_삼각달팽이 {

	public static void main(String[] args) {

	}
	class Solution {
	    public int[] solution(int n) {
	        int max = n * (n + 1) / 2;
	        int[][] map = new int[n][n];
	        int[] answer = new int[max];

	        // 시작 지점 초기화
	        int r = 0, c = 0;
	        int value = 1;
	        map[0][0] = 1;

	        while (value < max) {
	            // 맨 왼쪽 -> 위에서 아래로
	            while (r + 1 < n && map[r + 1][c] == 0) {
	                map[++r][c] = ++value;
	            }

	            // 맨 아래 -> 왼쪽에서 오른쪽으로
	            while (c + 1 < n && map[r][c + 1] == 0) {
	                map[r][++c] = ++value;
	            }

	            // 오른쪽 아래에서 좌상
	            while (c - 1 > 0 && r - 1 > 0 && map[r - 1][c - 1] == 0) {
	                map[--r][--c] = ++value;
	            }
	        }
	        int idx = 0;
	        for(int i = 0; i < map.length; i++) {
	            for (int j = 0; j <= i; j++) {
	                answer[idx] = map[i][j];
	                idx++;
	            }
	        }
	        return answer;
	    }
	}

}
