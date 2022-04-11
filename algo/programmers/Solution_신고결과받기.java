package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int[] answer = new int[id_list.length];
		Map<String, HashSet<String>> map = new HashMap<>(report.length);
		Map<String, Integer> idxMap = new HashMap<>(id_list.length);
		
		for(int i = 0; i < id_list.length; i++) {
			String name = id_list[i];
			map.put(name,new HashSet<String>());
			idxMap.put(name, i);
		}
		
		StringTokenizer st;
		for(int i = 0; i < report.length; i++) {
			st = new StringTokenizer(report[i]);
			// 신고한 사람
			String reporter = st.nextToken();
			// 신고 받은사람
			String reported = st.nextToken();
			map.get(reported).add(reporter);
		}
		
		for(int i = 0; i < id_list.length; i++) {
			HashSet<String> reporters = map.get(id_list[i]);
			if(reporters.size() >= k) {
				for(String name : reporters) {
					answer[idxMap.get(name)]++;
				}
			}			
		}
	}
}
