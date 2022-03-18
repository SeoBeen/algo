package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_뉴스클러스터링 {

	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String sb1 = "";
        String sb2 = "";
        for(int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if(c >= 'a' && c <='z') {
                sb1+=c;
            }
        }
        for(int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if(c >= 'a' && c <='z') {
                sb2+=c;
            }
        }
        System.out.println(sb1);
        System.out.println(sb2);
        int intersectionCnt = 0;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for(int i = 0; i< sb1.length()-1; i++) {
           String current = sb1.charAt(i)+""+ sb1.charAt(i+1);
            set1.add(current);
        }
        
        for(int i = 0; i< sb2.length()-1; i++) {
            String current2 = sb2.charAt(i)+""+sb2.charAt(i+1);
            set2.add(current2);
        }
        for(String a : set1) {
        	// 포함한다 => 교집합
        	if(set2.contains(a)) {
        		intersectionCnt++;
        	}
        }
        System.out.println(set1.toString());
        System.out.println(set2.toString());
        int sum = set1.size() + set2.size() - intersectionCnt;
        System.out.println("inter : "+intersectionCnt);
        answer = (int) ((intersectionCnt) / (sum*1.0) * 65536);
        
        System.out.println(answer);
        
	}
	class Solution {
	    public int solution(String str1, String str2) {
	                int answer = 0;

	        ArrayList<String> arr1 = new ArrayList<>();
	        ArrayList<String> arr2 = new ArrayList<>();
	        ArrayList<String> gong = new ArrayList<>();
	        ArrayList<String> hab = new ArrayList<>();

	        str1 = str1.toLowerCase();
	        str2 = str2.toLowerCase();

	        for(int i = 0; i<str1.length()-1;i++){
	            char first = str1.charAt(i);
	            char second = str1.charAt(i+1);
	            if(first >='a' && first <='z' && second >='a' && second <='z'){
	                arr1.add(first +""+second);
	            }
	        }

	        for(int i = 0; i<str2.length()-1;i++){
	            char first = str2.charAt(i);
	            char second = str2.charAt(i+1);
	            if(first >='a' && first <='z' && second >='a' && second <='z'){
	                arr2.add(first +""+second);
	            }
	        }

	        for(String s : arr1){
	            if(arr2.remove(s)){
	                gong.add(s);
	            }
	            hab.add(s);
	        }

	        hab.addAll(arr2);

	        double gong_len = gong.size();
	        double hab_len = hab.size();
	        if(hab_len == 0){
	            return 65536;
	        }
	        answer = (int)(gong_len/hab_len* 65536) ;

	        return answer;
	    }
	}

}
