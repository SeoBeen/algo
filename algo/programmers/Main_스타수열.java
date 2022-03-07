package programmers;

import java.util.HashMap;

public class Main_스타수열 {

	class Solution {
	    // 부분 수열중에서 길이가 가장 긴 스타 수열의 길이 리턴
	    // 1. 부분수열 구하기
	    // 2. 그중 길이가 가장 긴 스타 수열의 길이 구하기.
	    // 2-1. 길이가 2이상의 짝수 %2 == 0
	    // 2-2. 2의 배수 단위로 나눈 집합들의 교집합의 원소 개수가 1개 이상
	    // if 스타수열이 없으면 0 return;
	    
	    // a의 모든 수는 a의 길이 미만이다.
	    
	    public int solution(int[] a) {
	        HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();		
			int[] nums = new int[a.length];
	        
	        // 각각 입력 받기
			for(int i = 0; i< a.length; i++) {
			    nums[a[i]]++;
			}
			
			int max = 0;
			
	        
	        for(int i =0; i< a.length; i++) {
	            
	            // 해당 숫자를 가지고, 현재 최대 나온것보다 크면
	            if(nums[i] != 0 && nums[i] >= max) {
	                
	                int len = 0;
	                
	                //                   +1 indexoutofB
	                for(int j = 0; j< a.length-1; j++) {
	                    // 둘중에 한개의 수가 중복되고,       두 숫자가 다르면
	                    if((a[j] == i || a[j+1] == i) && (a[j] != a[j+1])) {
	                        len++;
	                        // 바로 다음숫자 건너뛰기
	                        j++;
	                    }
	                }
	                max = Math.max(len,max);
	            }
	        }
	        
			//max *= 2;
			//System.out.println(max);
	        
	        return max*2;
	    }
	}
}
