package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_거리두기확인하기 {
	//						   상, 우, 하, 좌
	private static int[] dr = {-1, 0,  1,  0};
	private static int[] dc = { 0, 1,  0,  -1};
	
	private static String[][] places= {
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
	
	public static void main(String[] args) {
		int[] answer = new int[5];
		for(int i = 0; i< places.length; i++) {
			String[] strArr = places[i];
			
			boolean isClose = true;
			for(int r = 0 ; r < 5 && isClose; r++) {
				for(int c = 0; c < 5 && isClose; c++) {
					if(strArr[r].charAt(c) == 'P') {
						isClose = bfs(r,c, strArr);
					}
				}
			}
			answer[i] = isClose ? 1 : 0;
		}
		System.out.println(Arrays.toString(answer));
	}
	
	private static boolean bfs(int i, int j, String[] strArr) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 범위 밖이면 통과
				if(!isIn(nr,nc) || (nr == i && nc == j)) continue;
				
				int dist = Math.abs(nr - i) + Math.abs(nc - j);
				
				// 거리 2 안인데 사람이면 
				if(dist <= 2 && strArr[nr].charAt(nc) == 'P' ) {
					return false;
				}
				// 빈 테이블이면 한칸 더 볼수있음
				else if(strArr[nr].charAt(nc) == 'O' && dist < 2) {
					queue.offer(new int[] {nr,nc});
				}
				
			}
			
		}
		return true;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < 5 && c >= 0 && c < 5;
	}

}
