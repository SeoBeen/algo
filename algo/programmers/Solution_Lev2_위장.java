package study.programmers;

import java.util.HashMap;

public class Solution_Lev2_위장 {

	public static void main(String[] args) {
		
	}
	
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i<clothes.length; i++) {
//        			키				value
//        			옷 종류			개수
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
//        조합 구하기
        for(String key : map.keySet()) {
//        	한개도 안뽑은 경우 즉 옷이 2가지라면 안뽑는 경우를 더해서 3가지로 구해야 한다.
        	answer *= map.get(key)+1;        	
        }
//        마지막으로 아무것도 안입은 경우 빼주기.
        return answer - 1;
    }

}
