package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 *  1. 문제를 보고 생각난 아이디어
 *    - 1. 모두 꺼진 상태와 입력받은 상태를 각각 배열로 생성한다.
 *    - 2. 두 배열이 같은 인덱스일때 값이 다르면 모두 꺼진배열의 버튼을 누른다. (해당 idx,idx+1,idx+2 까지 반전)
 *    
	2. 문제를 풀면서 바뀐 아이디어
	
	3. 최종적으로 사용된 아이디어
 *
 */

public class Main_S1_15729_방탈출 {
	private static int N,cnt,first;
	private static int[] arr;
	private static int[] ansArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ansArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			ansArr[i] = Integer.parseInt(st.nextToken());
		}		

		for(int i = 0; i<N; i++) {
//			값이 다르면 버튼 눌러버리기
			if(ansArr[i] != arr[i]) {
//				N-3
				if(i < N-2) {
					arr[i] = ansArr[i];
					arr[i+1] = arr[i+1] == 1 ? 0 : 1;
					arr[i+2] = arr[i+2] == 1 ? 0 : 1;				
				}
				else if(i == N-2) {
					arr[i] = ansArr[i];
					arr[i+1] = arr[i+1] == 1 ? 0 : 1;
				} else {
					arr[i] = ansArr[i];
				}
				cnt++;
			}
		}
		System.out.println(cnt);		
	}
}
