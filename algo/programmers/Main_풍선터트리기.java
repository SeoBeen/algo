package programmers;

import java.util.HashMap;

public class Main_풍선터트리기 {

	public static void main(String[] args) {

	}
	
	class Solution {
	    // 100만 * 100만-1?
	    // 완탐 불가.
	    public int solution(int[] a) {
	        int length = a.length;
	        int[] left = new int[length];
	        int[] right = new int[length];
	        int leftMin = a[0];
	        int rightMin = a[length-1];
	        
	        // i번째 수의 왼쪽의 최솟값 구하기
	        for(int i = 1; i< length-1; i++) {
	            if(leftMin > a[i]) {
	                leftMin = a[i];
	            }
	            left[i] = leftMin;
	        }
	        //System.out.println(Arrays.toString(left));
	        // i번째 수의 오른쪽 최솟값 구하기
	        for(int i = length-2; i>0; i--) {
	            if(rightMin > a[i]) {
	                rightMin = a[i];
	            }
	            right[i] = rightMin;
	        }
	        //System.out.println(Arrays.toString(right));
	        if(a.length == 1) return 1;        
	        // 여기서 맨왼쪽 과 맨오른쪽 즉, i = 0, i = length 는 무조건 포함한다.
	        int answer = 2;
	        for(int i = 1; i<= length-2; i++) {
	            // 양쪽의 최솟값 숫자보다 i번째 숫자가 크면 살아남지 못한다.
	            if(left[i] < a[i] && a[i] > right[i]) continue;
	            // 둘중에 하나라도 i번째 숫자가 작으면 살아남을수 있다.
	            answer++;
	        }
	        
	        return answer;
	    }
	}

}

/*
[1, 2, 3, 1, 1, 4, 5, 1] 8
[2, 1, 1, 3, 4, 1, 1, 5] 8
[1, 2, 1, 3, 1, 4, 1, 5] 8
[2, 1, 3, 1, 4, 1, 5, 1] 8
[1, 2, 1, 3, 1, 4, 1, 5, 1] 8
[1, 2, 1, 3, 1, 1, 4, 1, 5, 1] 8
[2, 3, 4, 1, 1, 1, 1, 5, 6, 7] 4
*/
