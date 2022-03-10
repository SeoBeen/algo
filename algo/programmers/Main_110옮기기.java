package programmers;

import java.util.Stack;

public class Main_110옮기기 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("abcd");
		sb.insert(0, "와우");
		System.out.println(sb);
	}
	
	// String으로 하면 시간초과

	class Solution {
	    public String[] solution(String[] s) {
	        String[] answer = new String[s.length];
	        StringBuilder sb;
	        
	        for(int i = 0; i < s.length; i++) {
	            String str = s[i];
	            Stack<Character> stack = new Stack<>();
	            int cnt = 0;
	            
	            for(int j = 0; j < str.length(); j++) {
	                char c = str.charAt(j);
	                
	                // 앞에 쌓인 글자의 수가 2개이다.                
	                if(stack.size() > 1) {
	                    char b = stack.pop();
	                    char a = stack.pop();
	                    
	                    // 즉 z가 0일때
	                    // 110의 갯수 카운트
	                    if(a == '1' && b == '1' && c == '0') cnt++;
	                    // 아니면 다시 저장
	                    else {
	                        stack.push(a);
	                        stack.push(b);
	                        stack.push(c);
	                    }
	                }
	                else {
	                    stack.push(c);
	                }
	            }
	            
	            int size = stack.size();
	            boolean flag = false;
	            sb = new StringBuilder();
	            
	            
	            // 0의 마지막 위치 찾기
	            while(!stack.isEmpty()) {
	                if(!flag) {
	                    // 1이면 다음으로 이동
	                    if(stack.peek() == '1') size--;
	                    // 0을 찾음.
	                    else flag = true;
	                }
	                // 그리고 stack 에서 뺀값은 sb의 맨앞에 저장.
	                sb.insert(0, stack.pop());
	            }
	            
	            // 현재 size = 0의 마지막 위치
	            
	            //110을 찾은 갯수만큼 반복
	            if(cnt > 0) {
	                while(cnt-- > 0) {
	                    sb.insert(size,"110");
	                    size+=3;
	                }
	                answer[i] = sb.toString();
	            }
	            else {
	                // 110이 없음
	                answer[i] = s[i];
	            }            
	        }
	        return answer;
	    }
	}

}
