package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_11724_연결요소의개수 {
	
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		visited = new boolean[N];
		list = new ArrayList[N];
		
		for(int i = 0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int vertex1 = Integer.parseInt(st.nextToken())-1;
			int vertex2 = Integer.parseInt(st.nextToken())-1;
			list[vertex1].add(vertex2);
			list[vertex2].add(vertex1);
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int i) {
		// 기저조건
		if(visited[i]) {
			return;
		}
		// 방문 처리
		visited[i] = true;
		
		// 해당 정점(i)에서 연결된 정점(v)
		for(int v : list[i]) {
			// 연결된 곳이 방문 전이면
			if(!visited[v])
				dfs(v);
		}
	}

}
