package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_5014_스타트링크 {

	private static int F,S,G,U,D;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		// 현ㄴ재 위치
		S = Integer.parseInt(st.nextToken());
		// 목표 위치
		G = Integer.parseInt(st.nextToken());
		// 업
		U = Integer.parseInt(st.nextToken());
		// 다운
		D = Integer.parseInt(st.nextToken());
		
		// 건물은 1 ~ F층까지
		
		bfs(S,G);
	}

	private static void bfs(int s, int g) {
		// 최대 층수만큼 방문 배열 생성
		boolean[] visited = new boolean[F+1];
		Queue<Integer> queue = new LinkedList<>();
		// 현재위치 저장
		queue.offer(s);
		visited[s] = true;
		int[] move = new int[2];
		move[0] = U;
		move[1] = -D;
		
		int cnt = 0;
		while(!queue.isEmpty()) {			
			int size = queue.size();
			
			while(size-- > 0) {
				
				int current = queue.poll();
				
				// 목표층 도달하면 끝
				if(current == g) {
					System.out.println(cnt);
					return;
				}
				
				for(int i = 0; i < 2; i++) {
					int next = current+move[i];
					// 방문 전이면 추가
					if(next > 0 && next <= F && !visited[next]) {
						// 방문 처리하고
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
