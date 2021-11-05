package study.programmers;

import java.util.Arrays;
import java.util.Comparator;

// 크루스칼 사용
public class Solution_Lev3_섬연결하기 {
	private static int[] parents;
	public static void main(String[] args) {
		
	}
	
	public int solution(int n, int[][] costs) {
//		가중치 기준으로 오름차순 정렬
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
			
		});
		
//		모든 정점을 각각의 집합으로 만들기
		make(n);
		
//		간선 하나씩 시도하며 트리 만들기
		int answer = 0;
		for(int i = 0; i<costs.length; i++) {
//			싸이클이 발생하지 않으면
			if(union(costs[i][0],costs[i][1])) {
				answer += costs[i][2];
			}
		}
        return answer;
    }

	private static void make(int n) {
		parents = new int[n];
//		모든 원소의 대표자를 자기자신으로 만듬
		for(int i = 0; i<n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a; // 자신이 대표자
		return parents[a] = find(parents[a]);	// 자신이 속한 집합의 대표자를 자신의 부모로
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
//		같은 집합이면 합치지 않는다.
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
