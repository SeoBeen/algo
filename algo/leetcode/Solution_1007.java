package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1007 {

	public static void main(String[] args) {
		int[] top = {1,3,4,1,2,1,3,4};
		int[] bottoms = {1,3,1,2,2,1,4,4};
		
		Map<Integer, Integer> topMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> bottomMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < top.length; i++) {
			topMap.put(top[i],topMap.getOrDefault(top[i],0)+1);
			bottomMap.put(bottoms[i],bottomMap.getOrDefault(bottoms[i],0)+1);
		}
		int maxTop = 0;
		int maxTopKey = 0;
		int maxBottom = 0;
		int maxBottomKey = 0;
		for(int key : topMap.keySet()) {
			if(maxTop < topMap.get(key)) {
				maxTop = topMap.get(key);
				maxTopKey = key;
			}
		}
		for(int key : bottomMap.keySet()) {
			if(maxBottom < bottomMap.get(key)) {
				maxBottom = bottomMap.get(key);
				maxBottomKey = key;
			}
		}
		System.out.println("maxTopCnt : " + maxTop + " maxTopKey : " + maxTopKey);
		System.out.println("maxBottomCnt : " + maxBottom + " maxBottomKey : " + maxBottomKey);
		boolean hasTopKey = true;
		boolean hasBottomKey = true;
		
		if(maxTop >= maxBottom) {
			for(int i = 0; i < top.length; i++) {
				if(top[i] != maxTopKey && bottoms[i] != maxTopKey) {
					hasTopKey = false;
					break;
				}
			}
			if(!hasTopKey)System.out.println(-1);
		}
		else if(maxTop <= maxBottom) {			
			for(int i = 0; i < top.length; i++) {
				if(top[i] != maxBottomKey && bottoms[i] != maxBottomKey) {
					hasBottomKey = false;
					break;
				}
			}
			if(!hasBottomKey)System.out.println(-1);
		}
		
		int answer = maxTop > maxBottom ? top.length - maxTop : top.length - maxBottom;
		System.out.println(answer);
	}

}
