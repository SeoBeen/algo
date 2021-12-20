package study.programmers;

public class Solution_Lev4_도둑질 {

	public static void main(String[] args) {
		
	}
	
	public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[] getFirstHouse = new int[len];
        int[] nGetFirstHouse = new int[len];
        // 문제는 원형이다 => 처음과 맨 끝이 연결되어 있음
        
        // 첫집꺼 훔치고
        getFirstHouse[0] = money[0];
        // 첫집 바로 옆은 안훔쳐서 첫집 그대로
        getFirstHouse[1] = money[0];
        
        // 첫집꺼 안훔치고
        nGetFirstHouse[0] = 0;
        // 두번째 집부터 훔침
        nGetFirstHouse[1] = money[1];
        
        
        for(int i =2; i<len-1; i++) {
            getFirstHouse[i] = Math.max(getFirstHouse[i-2]+money[i],getFirstHouse[i-1]);
        }
        for(int i = 2; i<len; i++) {
            nGetFirstHouse[i] = Math.max(nGetFirstHouse[i-2]+money[i],nGetFirstHouse[i-1]);
        }
        
        answer = Math.max(getFirstHouse[len-2],nGetFirstHouse[len-1]);
        return answer;
    }

}
