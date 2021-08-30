package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder ans = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		boolean flag = false;					// 괄호의 시작과 끝 체크
		for(int i = 0; i<str.length(); i++) {
			
//			여는 괄호를 만나면 스택에 쌓아둔것들 출력
			if(str.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					ans.append(stack.pop());
				}
//				괄호가 시작하면 괄호 넣어주고, flag true처리
				ans.append(str.charAt(i));
				flag = true;
			}
			
//			괄호가 끝나면 괄호넣어주고, flag false
			else if(str.charAt(i) == '>') {
				ans.append(str.charAt(i));
				flag = false;
			}
			
//			괄호가 아닌 글자일때 
			else {
//				flag = true ==> 괄호 안임
				if(flag) {
					ans.append(str.charAt(i));
				}
//				flag = false ==> 괄호 바깥, 역순으로
				else {
//					현재 글자가 공백이 아니면 스택에 푸쉬
					if(str.charAt(i) != ' ') {
						stack.push(str.charAt(i));
					}
//					괄호 밖은 공백기준으로 나뉘기 때문에 공백을 만나면 이전글자 역순 출력 
					else {
						while(!stack.isEmpty()) {
							ans.append(stack.pop());
						}
//					여기로 떨어짐 => str.charAt(i) == ' '추가
						ans.append(" ");
					}
				}
				
			}
		}
//		마지막 >괄호 뒤의 글자들은 스택에 쌓여있음.
		while(!stack.isEmpty()) ans.append(stack.pop());
//		한꺼번에 출력
		System.out.println(ans);		
	}
}

/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
String str = br.readLine();
StringBuilder sb = new StringBuilder();
for (int i = 0, len = str.length(); i < len; i++) {
	if (str.charAt(i) == '<') {			// <를 만나는 경우 >까지 그대로 복사
		while (str.charAt(i) != '>') {
			sb.append(str.charAt(i++));
		}
		sb.append('>');
	} else if (str.charAt(i) == ' ') {	// 공백을 만나는 경우 공백을 복사
		sb.append(' ');
	} else {							// 나머지 경우는 뒤집어서 복사 
		StringBuilder tmp = new StringBuilder();
		while (i < len && str.charAt(i) != '<' && str.charAt(i) != ' ')
			tmp.append(str.charAt(i++));
		sb.append(tmp.reverse());
		i--;
	}
}
System.out.println(sb);
//bw.append(sb);
//bw.flush();
//bw.close();
br.close();
*/