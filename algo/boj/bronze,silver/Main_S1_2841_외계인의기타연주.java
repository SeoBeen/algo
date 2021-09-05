package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * 1. 문제를 보고 생각난 아이디어
 *   - 줄을 저장할 배열과 프렛을 저장할 2차원 배열같은것이 필요하다
 * 2. 문제를 풀면서 바뀐 아이디어
 *   - 입력으로 주어진 음의 프렛값과 해당줄의 현재 프렛값을 비교해야함   
 * 3. 최종적으로 사용된 아이디어
 *   - 프렛값이 들어오는 순서는 작은 수에서 큰수로 들어올것이기 때문에 이를 비교하기 위해서는
 *     스택을 이용하면 쉽게 해결이 가능하다.
 */


public class Main_S1_2841_외계인의기타연주 {
	private static int N,P;	// N : 음의 수, P : 프렛의 수
	private static Stack<Integer>[] line = new Stack[7]; 	// 각각의 줄마다 스택을 이용할 배열 1~6번줄
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 음의 수
		P = Integer.parseInt(st.nextToken());	// 프렛의 수
		int cnt = 0 ;	// 손가락 움직임
		for(int i = 1; i<=6; i++) {			
			line[i] = new Stack<Integer>();
		}
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
//			음
			int tone = Integer.parseInt(st.nextToken());
//			프렛
			int fret = Integer.parseInt(st.nextToken());
			
//			누르는 경우
//				해당 음이 비어있거나, 들어온 프렛이 이전의 프렛보다 높을때
			if(line[tone].isEmpty() || line[tone].peek() < fret) {
//				같은 프렛일 경우 제외, 스택이 비어있을경우 peek 은 에러 발생
				if(!line[tone].isEmpty() && line[tone].peek() == fret) continue;
				line[tone].add(fret);
				cnt++;
				continue;				
			}
			
//			떼는 경우
//				현재 누르고있는 음이 치려는 프렛보다 높다.
			while(!line[tone].isEmpty() && line[tone].peek() > fret) {
				line[tone].pop();
				cnt++;
			}
			
//			떼고나서, 값이 같아졌을때
			if(!line[tone].isEmpty() && line[tone].peek() == fret) continue;
			
//			다 떼어내도 fret에 해당하는 값이 없을때
			line[tone].add(fret);
			cnt++;
			
		} // N for문
		System.out.println(cnt);
	}//main
}// end class
