package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_PQ {
	static class Vertex implements Comparable<Vertex> {
		int no;
		long weight;
		public Vertex(int no, long weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.weight, o.weight);
		}
		
	}
	private static int T,V,E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tcase = 1; tcase <=T; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());	// 정점의 개수
			E = Integer.parseInt(st.nextToken());	// 간선의 개수
//			1-base
			long[][] input = new long[V+1][V+1];
			boolean[] visited = new boolean[V+1];
			long[] minEdge = new long[V+1];
			
			for(int i = 1; i<=E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long weight = Long.parseLong(st.nextToken());
				input[r][c] = weight;
				minEdge[i] = Long.MAX_VALUE;
			}
			int start = 1;
			long result = 0;
			int nodeCount = 0;
			PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
			queue.offer(new Vertex(start,0));	// 시작정점을 큐에 담고, 자기 자신은 비용이 없음.
			minEdge[start] = 0;
			
			while(!queue.isEmpty()) {
				Vertex min = queue.poll();
//				방문체크
				if(visited[min.no]) continue;
				
				result += min.weight;	// 비용 처리
				visited[min.no] = true; // 방문처리
				
				if(++nodeCount == V) break; // 모든 정점이 다 연결 됐다면 중단.
//				1-base
				for(int i = 1; i<=V; i++) {
//						방문하지 않음   인접 되어 있고,         최소 비용이다.
					if(!visited[i] && input[min.no][i] != 0 && minEdge[i] > input[min.no][i]) {
						minEdge[i] = input[min.no][i];
						queue.offer(new Vertex(i, input[min.no][i]));
					}
				}
//				System.out.println(Arrays.toString(minEdge));
			}
			
			System.out.println("#"+tcase+" "+result);
		}// tcase
	}
}
