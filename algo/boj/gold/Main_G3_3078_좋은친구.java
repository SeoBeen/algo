package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  1. 문제를 보고 생각난 아이디어
 *    - 문자열 입력 받음 => string 배열
 *    - 등수 차이 => K -> 기준값 하나 정하고 거기서 +K만큼 탐색, 길이 비교, 같으면 cnt++; 
	2. 문제를 풀면서 바뀐 아이디어
	  - 쉽게 배열쓰면 시간초과 ==> 단일 for문으로 문제를 해결하는 방향으로 해야함
	  - queue 사용.
	3. 최종적으로 사용된 아이디어
 */
public class Main_G3_3078_좋은친구 {
	private static int N, K;
	private static long cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		30만 * 30만 => 900만
//		1초 제한 ==> 입력받으면서 해결해야함.
		N = Integer.parseInt(st.nextToken()); // 이름 수
		K = Integer.parseInt(st.nextToken()); // 등수 차이
		Queue<int[]> queue = new LinkedList<>();	// 등수와 이름 길이 저장.
		int[] nameL = new int[N];
		for(int i = 0; i<N; i++) {
		}
//		문자열의 최대길이 => 20
		int bf[] = new int[21];
		for(int i = 0; i<N; i++) {
//			각 문자열의 길이 저장 
//			배열의 idx => 등수
			nameL[i] = br.readLine().length();
//								 등수, 이름 길이
			queue.offer(new int[] {i, nameL[i]});
//			좋은친구에 해당하는 문자길이에 개수 증가
			bf[nameL[i]]++;
//			등수가 K보다 차이나게 되면
			if(i - queue.peek()[0] > K) {
//				좋은친구에서 현재 범위에서 맨 처음에 들어온 이름길이의 개수를 감소시킨다.
				bf[queue.poll()[1]]--;
			}
//			인원수 -1 하면 쌍의 개수가 나옴 ex) 3명 => 2쌍, 4명 => 3쌍
			cnt += bf[nameL[i]] - 1;
		}
		
		System.out.println(cnt);
	}
}
