package study.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_Lev3_여행경로 {
//  방문 확인
	private static boolean[] visited;
	private static ArrayList<String> useTicket;

	public String[] solution(String[][] tickets) {
//                       티켓의 갯수만큼 나라 수가 정해짐.
		visited = new boolean[tickets.length];
		useTicket = new ArrayList<String>();
//      출발지,  도착한곳,방문횟수, 티켓
		dfs("ICN", "ICN", 0, tickets);
//      알파벳 순서이기 때문에 정렬해줌.
		Collections.sort(useTicket);

		String[] ans = useTicket.get(0).split(" ");
		return ans;
	}

	private static void dfs(String start, String end, int cnt, String[][] tickets) {
//      기저조건 다뽑으면
		if (cnt == tickets.length) {
			useTicket.add(end);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
//          방문 전이고,      티켓의 출발지가 지금꺼면
			if (!visited[i] && start.equals(tickets[i][0])) {
//              방문처리
				visited[i] = true;
//              방문
				dfs(tickets[i][1], end + " " + tickets[i][1], cnt + 1, tickets);
//              복귀
				visited[i] = false;
			}
		}
	}
}
