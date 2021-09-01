package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S4_3986_좋은단어 {
	private static int N;	// 단어 수
	private static int goodword; // 좋은 단어 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i <N; i++) {
			Stack<Character> stack = new Stack<Character>();
			String str = br.readLine(); 
			for(int j = 0; j < str.length(); j++) {
				char chr = str.charAt(j);
//				스택이 비어있을 경우 값 푸쉬
				if(stack.isEmpty()) {
					stack.push(chr);
				}
//				스택이 비어있지 않으면 값 비교
				else {
					if(stack.peek() == chr) {
						stack.pop();
					}
//					값이 다르면 스택에 저장
					else {
						stack.push(chr);						
					}
				}
			}
//			스택이 비어있다 ==> 좋은 단어이다
			if(stack.isEmpty()) goodword++;
		}
		System.out.println(goodword);
	}// main
} // end class

