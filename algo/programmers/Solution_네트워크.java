package study.programmers;

public class Solution_네트워크 {
	private static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        /*
        [1,1,0]
        [1,1,0]
        [0,0,1]
        
        [1,1,0]
        [1,1,1]
        [0,1,1]
        */
        
        visited = new boolean[computers.length];
        for(int i = 0 ; i<computers.length; i++) {
//             방문 안했으면
            if(!visited[i]) {
                //  끝까지 타고 가고
                dfs(i, computers);
//                 네트워크수 증가
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int idx, int[][] computers) {
//         방문 처리
        visited[idx] = true;
        
        for(int i = 0; i<computers.length; i++) {
//             방문 전이고,      연결 되어있을때
            if(!visited[i] && computers[idx][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
