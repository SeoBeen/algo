package study.boj.maybeeasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_2644_촌수계산 {
	private static int N;
	private static boolean[][] people;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		int cnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int parent = Integer.parseInt(st.nextToken())-1;
			int child = Integer.parseInt(st.nextToken())-1;
			people[parent][child] = people[child][parent] = true;			
		}
		bfs(start,end);
	}

	private static void bfs(int start, int end) {
		// 방문배열 생성
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				int current = queue.poll();
				if(current == end) {
					System.out.println(cnt);
					return;
				}
				
				for(int i = 0; i < N; i++) {
					// 이동 가능하고	      방문 전이면
					if(people[current][i] && !visited[i]) {
						visited[i] = true;
						queue.offer(i);
					}
				}
			}
			cnt++;
		}
		System.out.println(-1);
		
	}

}
