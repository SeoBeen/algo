package programmers;

public class Solution_문자열압축 {

	public static void main(String[] args) {
		String s = "aabbaccc";
		
		int answer = Integer.MAX_VALUE;
//		if(s.length() == 1) return 1;
		
		// 자르는 길이
		for(int len = 1; len <= s.length()/2; len++) {
			
			String current = "";
			String temp = "";
			int cnt = 1;
			for(int i = 0; i < s.length()/i; i++) {
				if(temp.equals(s.substring(i*len, (i*len)+len))) {
					cnt++;
					continue;					
				}
				
				if(cnt > 1) {
					current+= cnt+temp;
					// 다시 반복 횟수 초기화
					cnt = 1;
				} 
				else {
					current+=temp;
				}
				temp = s.substring(i*len, (i*len)+len);
			}
			if(cnt > 1) {
				current += cnt+temp;
				cnt = 1;
			}
			else {
				current += temp;
			}
			// 자른게 나누어 떨어지지 않는경우
			if(s.length() % len != 0) {
				current += s.substring(s.length()-s.length()%len, s.length());
			}
			answer = Math.max(answer,current.length());
		}
	}

}
