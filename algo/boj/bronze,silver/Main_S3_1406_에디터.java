package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 *  1. 문제를 보고 생각난 아이디어
 *      - 문자열의 인덱스를 신경써야한다 ==> ListIterator 사용해야함
 *      - ArrayList 사용
	2. 문제를 풀면서 바뀐 아이디어
	  - ListIterator는 list에 초기 문자열을 다 넣고 생성을 하자, 초기 위치는 list의 맨 앞이다.
	  - StringTokenizer는 if문을 건너면 값이 안받아진다 ?_?
	3. 최종적으로 사용된 아이디어
	  - ArrayList사용시 시간 초과 무조건 시간 초과
	  - ListIterator, LinkedList 사용
	
 */

public class Main_S3_1406_에디터 {
	private static int M;	// 명령어의 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine(); // 초기 문자열
		M = Integer.parseInt(br.readLine());	// 명령어의 개수
		
		LinkedList<Character> list = new LinkedList<Character>();
		for(int i =0; i<str.length(); i++) {
			list.add(str.charAt(i));		// 초기 문자열 저장
		}
//		iter 선언은 선언 기준 리스트 값을 가지고 옴.
		ListIterator<Character> iter = list.listIterator();	// 커서 위치
		while(iter.hasNext()) {
			iter.next();			// 커서 맨뒤로 이동.
		}
		
//		if(iter.hasNext()) iter.next();
//		System.out.println(iter.nextIndex());
		for(int i = 0; i<M; i++) {
			String commandLine = br.readLine();
			char chr = commandLine.charAt(0); // 명령어
			switch(chr) {
			
			case 'P':  // 입력 문자열일 경우 한번 더 받아야함.				
//				 StringTokenizer로 if문 위에서 받은게 여기로 안떨어짐 이유 ??
				char addChr = commandLine.charAt(2);
					iter.add(addChr);
				break;
			case 'L' :
				if(iter.hasPrevious()) {
					iter.previous();					
				}
				break;
			case 'D' :
				if(iter.hasNext()) {
					iter.next();					
				}
				break;
			case'B' : 	// B : 커서 왼쪽 삭제
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();					
				}
				break;
			default :
				break;
			}// switch
		}// for
//		System.out.println(list);
		for(char c : list) {
			bw.write(c);
		}
		bw.flush();
		bw.close();
	} // main
}// end class
