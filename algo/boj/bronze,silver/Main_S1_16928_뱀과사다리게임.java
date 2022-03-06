package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_16928_뱀과사다리게임 {
	
	private static int[] map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[101];
		int start = 0 , end = 0;
		for(int i = 0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start] = end;
		}

		bfs();
		
	}

	private static void bfs() {
		
		int[] cnt = new int[101];
		boolean[] visited = new boolean[101];
		Queue<Integer> queue = new LinkedList<>();
		
		cnt[1] = 0;
		visited[1] = true;
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			
			int cur = queue.poll();
			
			// 도착
			if(cur == 100) {
				System.out.println(cnt[cur]);
				return;
			}
			
			for(int i = 1; i< 7; i++) {
				int next  = cur + i;
				
				if(next > 100 || visited[next]) continue;
				
				// 사다리 or 뱀 일경우
				if(map[next] != 0) {
					if(!visited[map[next]]) {
						queue.offer(map[next]);
						visited[map[next]] = true;
						cnt[map[next]] = cnt[cur] + 1;
					}
				}
				// 아닐경우
				else {
					visited[next] = true;
					queue.offer(next);
					cnt[next] = cnt[cur] + 1;
				}
			}
		}
	}
}
