package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_DFS와BFS {
	private static ArrayList<Integer>[] list;
	private static boolean[] isVisited;
	private static int N,M,V;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		for(int i = 1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		Arrays.fill(isVisited, false);
		System.out.println();
		bfs(V);
		
	}
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		isVisited[cur] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.printf("%d ",now);
			
			for(int i = 0, end = list[now].size(); i < end; i++) {
				int num = list[now].get(i);
				
				if(!isVisited[num]) {
					isVisited[num] = true;
					queue.offer(num);
				}
			}
		}
		
	}
	private static void dfs(int cur) {
		isVisited[cur] = true;
		System.out.printf("%d ", cur);
		
		for(int i = 0, end = list[cur].size(); i< end; i++) {
			int num = list[cur].get(i);
			// 방문 전이고			
			if(!isVisited[num])
				dfs(num);
		}
	}
}
