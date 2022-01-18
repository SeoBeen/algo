package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1697_숨바꼭질 {
	private static int ans = 0;
	private static int[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		// 0 ~ 100000
		map = new int[100001];
		if(N==X) System.out.println(0);
		else {
			bfs(N,X);
			System.out.println(map[X]-1);
		}
	}
	
	public static void bfs(int n, int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		map[n] = 1;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			// 동생 찾음
			if(map[x] != 0) break;
			// 범위 안이고			방문 전이면
			if(cur * 2 <= 100000 && map[cur*2] ==0) {
				queue.offer(cur*2);
				map[cur*2] = map[cur]+1;
			}
			if(cur + 1 <= 100000 && map[cur+1] == 0) {
				queue.offer(cur+1);
				map[cur+1] = map[cur]+1;
			}
			if(cur-1 >= 0 && map[cur-1] == 0) {
				queue.offer(cur-1);
				map[cur-1] = map[cur]+1;
			}			
		}
	}

}
