package study.boj.prepareExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  1. 문제를 보고 생각난 아이디어
 *   - 포스트 오더의 맨 뒤는 루트 노드이고, 이 루트노드에 해당하는 값을 기준으로 인오더를 보면
 *     왼쪽 자식과 오른쪽 자식으로 구분이 가능하다.
 *     
	2. 문제를 풀면서 바뀐 아이디어
	  - postOrder의 시작 위치와 끝 위치를 지정하는데 어려움을 겪음
	  
	3. 최종적으로 사용된 아이디어
	
 *
 * @author Seobeen
 * 
 */

public class Main_G3_2263_트리의순회 {
	private static int N,idx = 0;
	private static StringBuilder sb;
	private static int[] inO,postO,preO;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		inO = new int[N];
		postO = new int[N];
		preO = new int[N];
		sb = new StringBuilder();
//		중위 순회
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			inO[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(inO));
//		후위 순회
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			postO[i] = Integer.parseInt(st.nextToken());
		}
		
		PreOrder(0, N-1, 0, N-1);
		
		for(int i = 0; i<N; i++) {
			sb.append(preO[i]+" ");
		}
		System.out.println(sb);
	}

	private static void PreOrder(int inOrderS, int inOrderE, int postOrderS, int postOrderE) {
//									인오더 시작,         끝, 포스트오더 시작,    끝
//		기저 조건
		if(inOrderS <= inOrderE && postOrderS <= postOrderE) {
//			포스트 오더의 맨 마지막은 루트이다.
			preO[idx++] = postO[postOrderE];
			
			int inOrderRootIdx = inOrderS;
			for(int idx = inOrderS; idx<=inOrderE; idx++) {
//				인오더에서 루트에 해당하는 값 찾기
				if(inO[idx] == postO[postOrderE]) {
					inOrderRootIdx = idx;
					break;
				}
			}
			
//			왼쪽 자식 트리
			PreOrder(inOrderS, inOrderRootIdx - 1, postOrderS, postOrderS + (inOrderRootIdx - inOrderS) - 1);
//			오른쪽 자식 트리
			PreOrder(inOrderRootIdx + 1, inOrderE, postOrderS + (inOrderRootIdx - inOrderS), postOrderE - 1);
		}
	}

}
