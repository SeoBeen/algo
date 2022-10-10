package algo_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_2606_바이러스 {

	private static int N, nodeCnt;
	private static ArrayList<Integer>[] list;
	private static boolean[] isVisited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		nodeCnt = Integer.parseInt(br.readLine());
		isVisited = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < nodeCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		bfs(1);
	}
	
	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		isVisited[num] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0; i < list[cur].size(); i++) {
				int curNum = list[cur].get(i);
				// 방문 전이면
				if(!isVisited[curNum]) {
					// 방문 처리
					isVisited[curNum] = true;
					cnt++;
					queue.offer(curNum);
				}
			}
		}
		System.out.println(cnt);
	}

}
