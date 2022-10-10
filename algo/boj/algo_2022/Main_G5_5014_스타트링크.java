package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_5014_스타트링크 {
	private static int F,S,G,U,D;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		F = Integer.parseInt(st.nextToken()); // 총 높이
		S = Integer.parseInt(st.nextToken()); // 현재위치
		G = Integer.parseInt(st.nextToken()); // 목표 위치
		U = Integer.parseInt(st.nextToken()); // 상승값
		D = Integer.parseInt(st.nextToken()); // 하강값
		
		bfs();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		boolean[] visited = new boolean[F+1];
		visited[S] = true;
		int cnt = 0;
		int[] move = new int[2];
		move[0] = U;
		move[1] = -D;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				
				int cur = queue.poll();
				if(cur == G) {
					System.out.println(cnt);
					return;
				}
				for(int d = 0 ; d < 2; d++) {
					int next = cur + move[d];
					if(next > 0 && next <= F && !visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
				
			}
			cnt++;
		}
		System.out.println("use the stairs");
	}
}
