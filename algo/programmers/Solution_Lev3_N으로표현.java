package study.programmers;

public class Solution_Lev3_N으로표현 {

	public static void main(String[] args) {
		
	}
	private static int answer = -1;
    public int solution(int N, int number) {
        
        cal(N,number,0,0);
        return answer;
    }
    
    public void cal(int n, int number, int count, int sum) {
        int nn = n;
        
        // 기저조건
        if(count > 8) {
            return;            
        }
        if(sum == number) {
            // 8보다 큰 경우는 위에서 걸러짐
            if(answer == -1 || answer > count) {
                answer = count;
            }
            return;
        }
        
        for(int i = 1; i<9-count; i++){
            cal(n,number,count+i,sum+nn);
            cal(n,number,count+i,sum-nn);
            cal(n,number,count+i,sum*nn);
            cal(n,number,count+i,sum/nn);
            nn = nn*10 + n;
        }
    }

}
