package study.programmers;
/*
 * i와 젤처음 합 < limit => 탈출 - 반례 : 70,20,80,30 이렇게 되면 2번이면 될께 3번이 됨.
 * i와 i+1~ length까지 비교해서 합이 가장 큰 조합 탈출
 * => 시간초과
 * 오름차순 정렬해서 제일 큰값과 제일 작은값 합 < limit 이면 탈출 안되면 큰녀석만 혼자 탈출.
 */

import java.util.*;
public class Solution_Lev2_구명보트 {

	public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int lastidx = people.length-1;
        int idx = 0;
        while(idx <= lastidx) {
//             2인승 성공
            if(people[idx] + people[lastidx] <= limit) {
                idx++;
                lastidx--;
                answer++;
            }
//             1인승
            else {
                answer++;
                lastidx--;
            }
        }
       
        return answer;
    }

}
