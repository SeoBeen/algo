package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_Boj_1244_스위치_켜고_끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	// 입력 받기
		//BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T, N;
		
		// 스위치 갯수 입력받기
//		T = Integer.parseInt(input.readLine());
		T = sc.nextInt();
		
		int[] swch = new int[T+1];
		for(int i = 1; i<= T; i++) {
			swch[i] = sc.nextInt();
		}
//		for(int i = 1; i<= T; i++) {
//			System.out.print(swch[i]);
//		}
		// 스위치 상태 입력받기
		
//		String str = input.readLine();
//		swch = str.toCharArray();
//		StringTokenizer st = new StringTokenizer(input.readLine()," ");
//		// 스위치 상태 입력받기		
//		swch = st.nextToken().toCharArray();	
		//System.out.println(swch);
		
		// 학생 수
//		N = Integer.parseInt(input.readLine());
		N = sc.nextInt();
		// 학생 성별과 스위치 번호
		int gender, sNum;
		for(int i = 1; i <= N; i++) {
			// 학생 성별과 스위치 번호 입력받기
			gender = sc.nextInt();
			sNum = sc.nextInt();
//			StringTokenizer st = new StringTokenizer(input.readLine()," ");
//			gender = Integer.parseInt(st.nextToken());
//			num = Integer.parseInt(st.nextToken());
			//System.out.println(gender);
			//System.out.println(sNum);
				// 남학생일 경우
				if(gender == 1) {
					// 인덱스는 스위치번호
					// 스위치 번호(idx)가 받은 수(sNum)의 배수이면
					for(int idx = sNum, size = T; idx<=size; idx+= sNum) {
						//System.out.println(swch);
						swch[idx] =  swch[idx] == 0 ? 1 : 0;
						//isZero(swch[idx]) ? swch[idx] = 1 : swch[idx] = 0;											
					}
				}
			// 여학생일 경우
			else {
				// 스위치번호를 양 끝쪽을 받거나 양옆이 다를경우 대칭 불가능 => 본인만 반대로
					if(((sNum == 1 || sNum == T) || swch[sNum-1] != swch[sNum+1])) {
						swch[sNum] = swch[sNum] == 0 ? 1 : 0;
					}
					// 구간찾고 구간에 속한 스위치 모두 바꾸기
					else {
						//본인 먼저 바꿔주기
						swch[sNum] = swch[sNum] == 0 ? 1 : 0;
						int left = sNum - 1;
						int right = sNum + 1;
						// 경계 설정
						while(left > 0 && right <= T) {
							// 양 옆이 같을경우 값 변경, 그 옆도 탐색
							if(swch[left] == swch[right]) {
								swch[left] = swch[left] == 0 ? 1 : 0;
								swch[right] = swch[right] == 0 ? 1 : 0;
								left --;
								right ++;
							} else break;
						}
					}
				}
			}
		
		// 출력처리
		for(int i = 1; i <= T; i++) {
			System.out.print(swch[i]+ " ");
			if(i % 20 == 0) {
				System.out.println("");
			}
		}		
}
//	static boolean isZero(int n) {
//		if(n == 0)	return true;
//		return false; 
//	}
	
//	private static String src = "8\r\n" + 
//			"0 1 0 1 0 0 0 1\r\n" + 
//			"2\r\n" + 
//			"1 3\r\n" + 
//			"2 3";
}

