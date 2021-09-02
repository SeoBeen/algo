package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_5397_키로거 {
	private static int T;	//테케 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine());	// 테케 수
		for(int tcase = 1; tcase <= T; tcase++) {
			Stack<Character> stack = new Stack<Character>();
			Stack<Character> tmpStack = new Stack<Character>();
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			for(int i = 0; i<str.length(); i++) {
				char chr = str.charAt(i);
//				우선 스택이 비었는지 체크
				if(!stack.isEmpty()) {
//					백스페이스이면 지운다.
					if(chr == '-') {
						stack.pop();
					}
//					부호 '<' 처리
					else if(chr == '<') {
//						< 왼쪽으로 이동이면 템프 큐에 잠시 저장.
//						다시 나올때 들어간 순서대로 나와야 하기때문에 큐를 씀.
						tmpStack.add(stack.pop());						
					}
//					부호 '>' 처리
					else if(chr == '>') {
//						> 오른쪽으로 이동일때 큐가 비어있지 않으면 큐에있는것을 꺼내준다.
						if(!tmpStack.isEmpty()) {
//							꺼내서 스택에 넣기
							stack.add(tmpStack.pop());
						}
					}
//					그 이외 ==> 숫자 또는 문자 는 스택에 넣기
					else {
						stack.add(chr);
					}
				}
//				비어 있다면
				else {
					if(chr != '<' && chr != '>' && chr != '-') {
//						부호가 아니면 스택에 푸쉬
						stack.add(chr);
					}					
//					★스택은 비어있지만 > 부호 이고, tmp가 비어있지 않으면
//					꺼내서 stack에 넣어준다.★
					else if(chr == '>' && !tmpStack.isEmpty()) {
						stack.add(tmpStack.pop());
					}
				}
			}
//			끝나고 큐에들어있는 나머지들 다시 스택에 넣기.
			while(!tmpStack.isEmpty()) {
				stack.add(tmpStack.pop());
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb.reverse());
		}// tcase for
	}// main
} // end class
