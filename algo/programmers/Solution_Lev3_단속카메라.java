package study.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_Lev3_단속카메라 {
	public int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
//        통과 시점을 기준으로 오름차순 정렬하기
        Arrays.sort(routes,new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
        		return o1[1] - o2[1];
        	}
		});
        
        for(int i = 0; i<routes.length; i++) {
//        	이전 거의 통과 시간보다 내꺼의 시작시간이 크면
        	if(min < routes[i][0]) {
//        		겹치는 구간이 없으니까 카메라 추가
        		answer++;
//        		통과시간을 내꺼의 통과시간으로 변경
        		min = routes[i][1];
        	}
        }
        return answer;
    }
}
