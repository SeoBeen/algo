package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_DFS와BFS {

	private static int N, M, V;
	private static ArrayList<Integer>[] list;
	private static boolean[] isVisited;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		for(int i = 1; i<=N; i++) {
			Collections.sort(list[i]);
		}		
		dfs(V);
		sb.append("\n");
		Arrays.fill(isVisited, false);
		bfs(V);
		System.out.println(sb);
	}

	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		isVisited[cur] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+" ");
			
			int size = list[now].size();
			for(int i = 0; i < size; i++) {
				int num = list[now].get(i);
				// 방문 전이면
				if(!isVisited[num]) {
					queue.offer(num);
					isVisited[num] = true;
				}
			}
		}
		
	}

	private static void dfs(int cur) {
		isVisited[cur] = true;
		sb.append(cur+" ");
		
		for(int i = 0; i < list[cur].size(); i++) {
			int num = list[cur].get(i);
			if(!isVisited[num])
				dfs(num);
		}
	}

}
