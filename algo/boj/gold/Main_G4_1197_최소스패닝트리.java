package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1197_최소스패닝트리 {
	private static int V,E,ans;
	private static ArrayList<Node> [] adj;
	
	private static class Node implements Comparable<Node>{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}				
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());	// 정점 개수
		E = Integer.parseInt(st.nextToken());	// 간선 개수
		
		adj = new ArrayList[V+1];
		for(int i = 1; i<=V; i++) {
			adj[i]  = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj[from].add(new Node(to,weight));			// 간선 정보 저장
			adj[to].add(new Node(from,weight));
		}
		
		prim_PQ();
		
		System.out.println(ans);
		
	} // main

	private static void prim_PQ() {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
//		시작점 1로 세팅
		pq.add(new Node(1,0));
		
//		연결된 간선 수
		int cnt = 0;
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
//			이미 확인한 정점이면 통과
			if(visited[cur.to]) continue;
			
			ans += cur.weight;
//			방문 처리
			visited[cur.to] = true;
			
//			간선의 수가 정점 -1 개일때 정지.
			if(cnt == V-1) return;
			
			for(int i = 0; i< adj[cur.to].size(); i++) {
//				연결된 노드들 중 방문하지 않은 노드 찾기
				Node next = adj[cur.to].get(i);
				if(visited[next.to]) continue;
				
				pq.add(next);
			}			
		}
	}
} // end class
