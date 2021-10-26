package study.programmers;

public class Solution_단어변환 {

	private static boolean[] visited;
	private static int cnt;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		cnt = 0;
		dfs(begin, target, words, 0);
		int answer = cnt;
		return answer;
	}

	private static void dfs(String begin, String target, String[] words, int idx) {
//	         기저조건 타겟과 같아지면.
		if (target.equals(begin)) {
			cnt = idx;
			return;
		}

		for (int i = 0; i < words.length; i++) {
//	             방문 했다면 패스
			if (visited[i])
				continue;
//	             그전이라면 탐색

			int same = 0;
			for (int j = 0; j < begin.length(); j++) {
//	                 같은 글자가 몇개인지 체크
				if (begin.charAt(j) == words[i].charAt(j)) {
					same++;
				}
			}
//	             1글자빼고 다 같다면 탐색 시작
			if (same == begin.length() - 1) {
//	                 방문체크
				visited[i] = true;
				dfs(words[i], target, words, idx + 1);
//	                 원상복구
				visited[i] = false;

			}
		}
	}
}
