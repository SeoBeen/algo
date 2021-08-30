package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_2628_종이자르기 {
	private static int W,H,cutCnt;		// 종이의 W : 가로길이, H : 세로길이, cutCnt : 자르는 횟수
	private static int[] rCut;			// 가로로 자르는 점선 저장배열
	private static int[] cCut;			// 세로로 자르는 점선 저장배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
//		가로 길이 = 열, 세로길이 = 행 ==> 입력받은 값, 행과 열 위치 바꿔주기
		cutCnt = Integer.parseInt(br.readLine());
		rCut = new int[cutCnt+1];
		cCut = new int[cutCnt+1];
		int rCutIdx = 0, cCutIdx = 0, rMax = Integer.MIN_VALUE, cMax = Integer.MIN_VALUE;
		for(int i =0; i< cutCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int way =Integer.parseInt(st.nextToken()); 
//			0 : 가로로 자르는 점선
			if(way == 0 ) {
				rCut[rCutIdx] = Integer.parseInt(st.nextToken());
				rCutIdx++;
			}
//			1 : 세로로 자르는 점선
			else if(way == 1){
				cCut[cCutIdx] = Integer.parseInt(st.nextToken());
				cCutIdx++;
			}
		}
		rCut[rCutIdx] = H;
		cCut[cCutIdx] = W;
		Arrays.sort(rCut);
		Arrays.sort(cCut);
		rMax = maxChk(rCut);
		cMax = maxChk(cCut);
		System.out.println(rMax * cMax);		
	}
	
	private static int maxChk(int[] arr) {
		// 첫번째 값을 우선 최댓값으로 지정
		int max = arr[0];
		for(int i = 1; i<=cutCnt; i++) {
			max = Math.max(max, arr[i]-arr[i-1]);
		}
		return max;	
	}
}
