package programmers;

import java.util.HashMap;
import java.util.Stack;

public class Main_괄호회전하기 {

	public static void main(String[] args) {
		String s = "}]()[{";
		HashMap<Character, Integer> map = new HashMap<>(s.length());
		char c= 's';
		
		map.put(c,map.getOrDefault(c,map.get(c))+1);
		String bracket = s.substring(5,s.length()) + s.substring(0,5);
		System.out.println(s.startsWith("}"));
		System.out.println(s.length());
		System.out.println(bracket);
//		for(int i = 0; i<s.length(); i++) {
//            String bracket = s.substring(i,s.length()) + s.substring(0,i);
//        }
	}
	class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        
	        // 무조건 길이는 짝수(열고, 닫고)
	        if(s.length() % 2 != 0) {
	            return 0;
	        }
	        Stack<Character> stack = new Stack<>();
	        
	        for(int i = 0; i<s.length(); i++) {
	            String bracket = s.substring(i,s.length()) + s.substring(0,i);
	            // 닫는걸로 시작하면 무조건 올바르지 않은 괄호 문자열
	            if(bracket.startsWith("}") || bracket.startsWith("]") || bracket.startsWith(")"))
	                continue;
	            
	            for(int j = 0; j < bracket.length(); j++) {
	                char c = bracket.charAt(j);
	                
	                if(stack.isEmpty()) {
	                    stack.push(c);
	                }
	                else {
	                    if(c == ']'){
	                        if(stack.peek() == '['){
	                            stack.pop();
	                        }
	                        else {
	                        stack.push(c);
	                        }
	                    }
	                    else if(c == ')'){
	                        if(stack.peek() == '('){
	                            stack.pop();
	                        }
	                        else {
	                            stack.push(c);
	                        }
	                    }
	                    else if(c == '}'){
	                        if(stack.peek() == '{'){
	                            stack.pop();
	                        }
	                        else {
	                            stack.push(c);
	                        }
	                    }
	                    else {
	                        stack.push(c);
	                    }
	                }
	            }
	            if(stack.isEmpty()) answer++;
	            stack.clear();     
	        }                
	        
	        return answer;
	    }
	}

}
