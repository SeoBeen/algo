package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 1. 문제를 보고 생각난 아이디어
 *   - 괄호는 구역 나누는 용도이고 우선순위 별로 *,/ 먼저 처리, +,-나중에 처리
 *   - 만약 스택 TOP에 저장되어있는 부호가 현재 부호와 같으면 계산식으로 만들어주기.
   2. 문제를 풀면서 바뀐 아이디어
     - +,-일때 스택에 (값은 꺼내면 안된다. ==> 구역나누는 역할이기 때문 오직 )을 만났을때만 처리해준다. 
   3. 최종적으로 사용된 아이디어
 * 
 */

public class Main_G3_1918_후위표기식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		후위 표기식 저장 할 문자열			
		StringBuilder sb = new StringBuilder();
//		연산자 저장할 스택
		Stack<Character> op = new Stack<>();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char input = str.charAt(i);
//			알파벳은 바로 저장
			if(input  >='A' && input <= 'Z') {
				sb.append(input);
			}
//			알파벳이 아닐경우 기호 또는 괄호
//			우선 가장 우선순위가 높은 괄호부터 처리
			else if(input == '(') {
//				여는괄호 이면 스택에 저장.			
				op.push(input);
			} 
			else if(input ==')') {
//				닫는 괄호가 나오면 괄호안의 내용을 식에 다 추가해준다.
				while(op.peek() != '(') {
					sb.append(op.pop());
				}
//				여기로 떨어졌다 ==> 여는괄호가 나왔다
//				여는 괄호는 출력문에 안들어가기 때문에 날려줌.
				op.pop();			
			}
//			다음 우선순위 곱하기, 나누기 처리
			else if(input =='*' || input =='/') {
//				스택에 꼭대기 값이 같은 부호이면서 스택안에 내용이 있으면 식에다 추가해준다.
//				A*B*C ==> AB*C* 생각 A+B*C+D는 고려 필요 X ABC*+D+
				while(!op.isEmpty() && (op.peek() == '*' || op.peek()=='/')) {
					sb.append(op.pop());
				}
				op.push(input);
			}
//			나머지 +, - 처리
			else {
//				
//				스택이 비어있지 않고 여는 괄호가 아닐경우(*,/는 우선순위가 높기때문에) 식에 추가
				while(!op.isEmpty() && op.peek()!= '(') {
					sb.append(op.pop());
				}
				op.push(input);				
			}
		}
//		문자열 다 입력 받은 뒤 stack에 남은 연산자 처리
		while(!op.isEmpty()) {
			sb.append(op.pop());
		}
//		중위 -> 후위 변경 종료

		System.out.println(sb);
	}//main
}// end class