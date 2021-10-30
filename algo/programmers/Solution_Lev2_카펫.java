package study.programmers;

public class Solution_Lev2_카펫 {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i = 2; i<=sum; i++) {
//             약수 일때
            if(sum % i == 0) {
                int col = sum / i; // 가로
                int row = sum / col;  // 세로
                
                int yc = col - 2;   // 노랭이 가로                
                int yr = row - 2;   // 노랭이 세로                
//                 가로*세로가 총 개수와 같고  가로가 세로와 크거나 같을때
                if(yr * yc == yellow &&     col >= row) {
                    answer[0] = col;
                    answer[1] = row;
                }
            }            
        }
        return answer;
    }
}
