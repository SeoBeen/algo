package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_2606_바이러스 {
	private static int comCnt;	// 컴퓨터 수
	private static int edgeCnt;	// 연결되어 있는 컴퓨터 쌍의 수
	private static int[][] map;	// 연결 정보 저장 배열
	private static boolean[] visited;	// 연결여부 저장 배열
	private static int cnt;		// 방문 횟수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comCnt = Integer.parseInt(br.readLine());
		edgeCnt = Integer.parseInt(br.readLine());
//		노드 번호가 1번부터 시작하기 때문에 1씩 더해준다.
		map = new int[comCnt+1][comCnt+1];
		visited = new boolean[comCnt+1];
		for(int i = 0; i <edgeCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
//		1번에서 시작.
		bfs(1);
		System.out.println(cnt);
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();	// 탐색할 노드를 담을 queue
		
//		1. 첫 방문한 node를 queue에 담고 시작
		queue.offer(start);
//		2. queue에 담은 node를 방문 처리
		visited[start] = true;
		
//		3. 탐색 시작
//		queue 가 empty => 모두 방문완료
		while(!queue.isEmpty()) {
//			방문할 노드 꺼내오기
			start = queue.poll();
//			comCnt ==> 컴퓨터 수 즉, 노드 수
			for(int adj = 1; adj<=comCnt; adj++) {
//				아직 방문 전이고, 인접하면
				if(!visited[adj] && map[start][adj] == 1) {
//					다음순서로 방문하기 위해 queue에 입력
					queue.offer(adj);
//					다음에 바로 방문할 것이기 때문에 바로 방문 처리.
					visited[adj] = true;
					cnt++;
				}				
			}
		}
	}
}
