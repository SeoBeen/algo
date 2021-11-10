package study.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution_Lev3_베스트앨범 {
	public static void main(String[] args) {
		String [] genres = {"classic","pop","classic","classic","pop"};
		int [] plays = {500,600,150,800,2500};
		solution(genres, plays);
	}
	
	
	public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0 ; i<genres.length; i++) {
//        			key       value 장르별 플레이수
        	map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        //key값만 가져와서 넣어준다
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) {
//        	System.out.println(key);
            genre.add(key);
        }
        
        // 장르를 map에 있는 재생횟수 기준으로 정렬
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1)); 
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < genre.size(); i++) {
            String tmpgen = genre.get(i);
            
            //해당 장르의 음악 중에서 play횟수가 가장 큰 인덱스를 찾는다
            int max = 0;
            int first = -1;
            for(int j = 0; j < genres.length; j++) {
                if(tmpgen.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    first = j;
                }
            }
            //해당 장르의 음악 중에서 play횟수가 두번째로 큰 인덱스를 찾는다.
            max = 0;
            int second = -1;
            for(int j = 0; j < genres.length; j++) {
                if(tmpgen.equals(genres[j]) && max < plays[j] && j != first) { 
                    max = plays[j];
                    second = j;
                }
            }
            list.add(first);
            //장르에 속한곡이 1개일수도 있음
            if(second >= 0) list.add(second); 
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
