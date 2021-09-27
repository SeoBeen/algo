package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1707_이분그래프 {
	private static int red = 1;
	private static int blue = -1;
	private static int[] colors;
	private static boolean checkBipartite;
	private static int K,V,E;
	private static ArrayList<ArrayList<Integer>> list;	// 그래프
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<= K; tcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());	// 정점의 개수 V
			E = Integer.parseInt(st.nextToken());	// 간선의 개수 E
			
			list = new ArrayList<>();
			colors = new int[V+1]; // 각 정점의 색 구분, 1부터 시작하기 때문에 +1
			checkBipartite = true;	// 초기는 이분그래프임.
			
			for(int i = 0; i<= V; i++) {
				list.add(new ArrayList<Integer>()); // 그래프 생성
				colors[i] = 0;						// 정점의 색 초기화
			}
			
			for(int i = 0; i<E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
//				간선 연결
				list.get(start).add(end);
				list.get(end).add(start);
			}
			
//			이분 그래프 : 같은 레벨의 꼭짓점 끼리는 무조건 같은 색, 인접한 정점 사이는 다른 색
//			주의! 연결 그래프와 비연결 그래프(모든 정점을 돌면서 확인) 모두 고려!!
			for(int i = 1; i<=V; i++) {
//				이분 그래프가 아니면 바로 탈출
				if(!checkBipartite)
					break;
				
//				방문하지 않은 정점에 대해서 탐색
				if(colors[i] == 0) {
//					dfs(i,red);		// 깊이 우선 탐색
					bfs(i,red);		// 너비 우선 탐색
				}
			}			
			System.out.println(checkBipartite ? "YES" : "NO");
		}
	}// main end

	private static void bfs(int startV, int color) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(startV);	// 시작 정점을 큐에 삽임
		colors[startV] = color;	// 시작 정점 방문 표시, 색 표시
		
//		큐가 비어있지 않고 이분 그래프 이면 반복
		while(!queue.isEmpty() && checkBipartite ) {
			int cur = queue.poll();	// 정점 추출
			
//			해당 정점과 연결된 모든 인접 정점을 방문
			for(int adjV : list.get(cur)) {
//				방문하지 않은 정점이면
				if(colors[adjV] == 0) {
					queue.offer(adjV);	// 인접 정점을 큐에 삽입
					colors[adjV] = colors[cur] * -1;	// 인접한 정점을 다른 색으로 표시
				}
//				이미 방문한 정점중 같은 색이면 이분 그래프가 아니다.
				else if(colors[cur] + colors[adjV] != 0) {
					checkBipartite = false;
					return;					
				}
			}
		}
		
	} // bfs end

	private static void dfs(int startV, int color) {
//		시작 정점의 색 설정
		colors[startV] = color;
		
//		adjV : startV에서 인접한 정점
		for(int adjV : list.get(startV)) {
//			시작 정점의 색과 인접한 정점의 색이 같으면 이분 그래프가 아니다.
			if(colors[adjV] == color) {
				checkBipartite = false;
				return;
			}
			
//			시작 정점과 인접한 정점이 방문하지 않은 정점이면 dfs 실행
			if(colors[adjV] == 0) {
//				인접한 정점을 다른 색으로 지정
				dfs(adjV, -color);
			}
		}
		
	} // dfs end

}// end class
