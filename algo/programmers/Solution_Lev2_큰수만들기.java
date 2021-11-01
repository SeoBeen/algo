package study.programmers;

public class Solution_Lev2_큰수만들기 {
	private static int max,len;
    
    public static String solution(String number, int k) {
        String answer = "";
//        뽑을 길이
        len = number.length()-k;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int tmp = 0;
//        시작위치
       for(int i = 0; i<len; i++) {
    	   max = 0;
//    	   					i가 len-1일때 끝까지 가는경우 => i+k가 number의 길이 마지막.
    	   for(int j = idx; j<=i+k; j++) {
    		   int thisNum = number.charAt(j)-'0';
//    		   숫자가 더크면 추가해버리기
    		   if(max < thisNum) {
    			   tmp = j;
    			   max = thisNum;
    		   }
    	   }
    	   sb.append(max);
//    	   다음자리로 이동
    	   idx = tmp+1;
       }
       answer = sb.toString();
        return answer;
    }
     
    public static void main(String args[]) {
    	String ans = "";
    	ans = solution("1231234",3);
    	System.out.println(ans);
    }
}
