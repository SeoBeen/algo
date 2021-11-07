package study.programmers;

import java.util.Arrays;

/*
 * 2중 for문 효율성 3,4번 시간초과
 * sort로 for문 1개 없앤후 통과
 */
public class Solution_Lev2_전화번호목록 {
	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
        boolean answer = true;
        for(int i = 0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                return answer;
            }
            
        }
        return answer;
    }
	
	public static void main(String args[]) {
		String[] str = {"123","456","789"};
		System.out.println(solution(str));
	}
}
