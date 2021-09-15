package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 *  1. 문제를 보고 생각난 아이디어
 *    - recursion 사용.
 *    - 기저조건 => 이미 나온 수가 또 나을경우 -> boolean 배열 생성후, 해당 인덱스가 true이면 멈추는걸로.
 *    - recursion 실행시마다 cnt++
	2. 문제를 풀면서 바뀐 아이디어
	  - 첫 N일경우에도 cnt가 증가하기 때문에 1을 빼준다.
	  - N이 항상 P보다 크지는 않기때문에 boolean 배열 생성시 크기를 둘중에 큰 값으로 한다.
	3. 최종적으로 사용된 아이디어
	  - true 체크를 할때 다시 첫 입력값 N으로 돌아와서 기저조건을 만족할 경우 cnt를 감소시키지 않는다.
 *
 */
public class Main_2567_싸이클 {
	private static int N,P,cnt;
	private static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		int max = Math.max(N,P);
//		체크용 배열
		chk = new boolean[max+1];
//		true 선언
		recursion(N);
	}
	private static int recursion(int num) {
		System.out.println(num);
		if(chk[num] == true) {
//			제일 처음 N일때 들어간 cnt 빼주기 하지만 멈추는지점이 N일경우는 빼주지 않는다.
			if(num != N) cnt--;
			System.out.println(cnt);
			return 0;
		}
		chk[num] = true;
		cnt++;
		return recursion((num * N) % P);
	}

}
