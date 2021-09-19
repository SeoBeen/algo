package com.ssafy.afterclass.answer;

import java.util.Arrays;
import java.util.Scanner;

public class Main_JO_1205_조커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//전체 카드수

		int[] data = new int[N]; //카드정보가 저장될 배열
		
		//카드 (숫자) 데이터 입력
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		
		sc.close();

		// 데이터를 순서대로 정렬한다.
		Arrays.sort(data); //0 6 5 10 3 0 11  ==> 0 0 3 5 6 10 11

		// joker(0)인 개수 파악..
		int jokerCnt = 0;//찬스를 사용할 수 있는 횟수
		
		for (int i = 0; i < N; i++) {
			if (data[i] != 0)
				break;

			jokerCnt++;
		}

		// 모든 수가 0인 경우 체크를 위해
		// ex> 000000
		int ans = jokerCnt == N ? jokerCnt : 0;   

		// 스트레이트 체크 위치를 0이 아닌 위치부터 시작                                                                                                                                                                                                                                                                                                                                                                                        
		for (int i = jokerCnt; i < N; i++) { //0 0 3 5 6 10 11
			                       //인덱스 :    0 1 2 3 4  5  6
			// 조커 카운트를 변경하면서 사용해야 하므로 임시 변수에 조커 카운트를 담는다.
			int joker = jokerCnt;
			// 첫번째 데이터는 무조건 스트레이트에 들어가므로
			int cnt = 1; //스트레이트 길이
			int preNum = data[i];

			// 현재 체크 위치 다음부터 스트레이트 확인 시작하자
			for (int s = i + 1; s < N; s++) {

				// 이전과 같은 숫자일 경우 skip
				// ex> 00777 의 경우 777은 스트레이트 카운트를 세지 않고 스킵한다.
				if (data[s] == preNum)
					continue;

				// 현재 수가 이전 수와 1 차일 경우 카운트 증가시키고 이전 수를 변경
				if (data[s] == preNum + 1) {
					cnt++; //스트레이트 길이를 1증가
					preNum++;
					continue;
				}

				// 현재수와 이전수가 2이상 차이일 경우 조커(0)을 사용하여 이전수를 1 증가시켜야 한다.
				// 만약, 조커가 없다면 더이상 진행할 수 없다.
				if (joker == 0)
					break;

				preNum++; //조커사용^^
				joker--;  //조커사용했다는 표시
				
				cnt++;    //스트레이트 길이를 1증가

				s--;      //비교 수를 그 다음으로 이동
			}
			// 가장 최대인 스트레이트 숫자를 기억
			ans = Math.max(ans, cnt + joker);
		}
		System.out.println(ans);
	}
}
