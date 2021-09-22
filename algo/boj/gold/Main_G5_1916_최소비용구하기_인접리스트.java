package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 1. 문제를 보고 생각난 아이디어
 *  - 다익스트라 사용. 끝.
 *  
	2. 문제를 풀면서 바뀐 아이디어
	- 같은 출발점과 도착점을 가지지만 비용이 다른 버스가 입력으로 들어올 수 있다.
	- 인접행렬 사용 ==> 틀림 이유는 모르겠음.
	- -> 인접 리스트 사용.
	3. 최종적으로 사용된 아이디어
	- 위와 같은 경우를 위해 조건문을 추가한다.

 *
 */
public class Main_G5_1916_최소비용구하기_인접리스트 {
	private static int N,M;
	private static ArrayList<Node>[] list;
	
	private static class Node implements Comparable<Node> {
		int end;
		int dist;
		public Node(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
//		1부터 시작
		list = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];	// 방문 처리 배열
		int[] distance = new int[N+1];			// 최소 비용 저장 배열
		
		for(int i =0; i<= N; i++) {
			list[i] = (new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, dist));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
//		최소 비용을 갱신하기 위해 초기 값을 max로 설정한다.
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
//		출발점 가중치 0
		pq.add(new Node(start, 0));
		
//		시작 정점의 비용을 0으로 설정
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
//			도착지
			int cur = curNode.end;
//			방문 전이면
			if(!visited[cur]) {
//				방문 처리
				visited[cur] = true;
				
				for(Node node : list[cur]) {
//						방문 전이고				현재 비용보다		경유해서 가는 비용
					if(!visited[node.end] && distance[node.end] > distance[cur] + node.dist) {
						distance[node.end] = distance[cur] + node.dist;
//						최저비용 pq에 추가.
						pq.add(new Node(node.end, distance[node.end]));
					}
				}
			}// visited if
		}
		System.out.println(distance[end]);
		
	}// main
}//end class
