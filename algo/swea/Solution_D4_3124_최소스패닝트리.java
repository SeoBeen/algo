package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int start, end;
		long weight;
		public Edge(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight,o.weight);
		}
		
	}
	private static int T,V,E;
	private static int[] parents; // 부모 원소 관ㄴ리
	
	private static void make() {
		parents = new int[V+1];	// 정점의 개수만큼 생성
//		모든 원소를 자신을 대표자로 만듬
		for(int i = 1; i<=V; i++) {
			parents[i]= i;
		}
	}
	
//	a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a == parents[a]) return a; // 자신이 대표자
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 바꾸기
	}
	
//	두 원소를 하나의 집합으로 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 이미 같은 집합임
		
		parents[bRoot] = aRoot;	// b의 부모를 a의 부모로 바꿈.( a,b 바뀌어도 상관X)
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tcase = 1; tcase <=T; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");			
			V = Integer.parseInt(st.nextToken());	// 정점의 개수
			E = Integer.parseInt(st.nextToken());	// 간선의 개수
//			간선 리스트
			Edge[] edgeList = new Edge[E+1];
			
			for(int i = 1; i<=E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long weight = Long.parseLong(st.nextToken());
				edgeList[i] = new Edge(start,end,weight);
			}
			edgeList[0] = new Edge(Integer.MAX_VALUE,Integer.MAX_VALUE, Long.MAX_VALUE);
			Arrays.sort(edgeList); // 가중치 기준으로 오름차순 정렬
			
			make(); // 모든 정점을 각각의 집합으로 만들기
			
//			간선 하나씩 시도하며 트리 만들어감.
			int cnt = 0;
			long result = 0;
			for(Edge edge : edgeList) {
				if(union(edge.start,edge.end)) { // 싸이클이 발생하지 않으면 즉, start와 end의 부모가 다르면
					result += edge.weight;
					if(++cnt == V-1) break;
				}
			}
			
			System.out.println("#"+tcase+" "+result);
		}// tcase
	}
}
