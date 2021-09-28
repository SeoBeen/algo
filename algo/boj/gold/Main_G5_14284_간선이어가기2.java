package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 *  1. 문제를 보고 생각난 아이디어
 *    - 가중치 합의 최솟값 => 다익스트라 사용
	2. 문제를 풀면서 바뀐 아이디어
	  - 해당 문제는 무방향 그래프가 주어지기 때문에 간선 추가시 양방향으로 추가를 해주어야함.
	3. 최종적으로 사용된 아이디어
 */
public class Main_G5_14284_간선이어가기2 {
	private static int V,m,start,end;
	
	private static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(weight);
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());	// 정점 개수
		m = Integer.parseInt(st.nextToken());	// 간선 수
//		정점 번호 1부터 시작
		List<Edge>[] adj = new ArrayList[V+1];
		for(int i = 0; i<= V; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Edge(end,weight));
			adj[end].add(new Edge(start,weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		Edge[] D = new Edge[V+1];
//		0번 부터 출발
		for(int i = 0; i<= V; i++) {
//			출발지
			if(i == start) {
				D[i] = new Edge(i,0);
			} else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			for(Edge next : adj[cur.v]) {
//				방문 전이고				직행이				경유보다 가중치가 크면
				if(!check[next.v] && D[next.v].weight > D[cur.v].weight + next.weight) {
//					직행값 갱신
					D[next.v].weight = D[cur.v].weight + next.weight;
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
//			방문 처리
			check[cur.v] = true;
		}
		System.out.println(D[end]);		
	}
}
/*
5 8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
*/