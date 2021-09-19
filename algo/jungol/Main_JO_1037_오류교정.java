package com.ssafy.afterclass.answer;

import java.util.Scanner;

/*
1. 패키지없는 클래스 만들기
2. main()메서드 추가
3. 입력객체생성 - Scanner
4. 문제에서 주어지는 입력데이터를 어디에 저장할 지 type 선택
   (기본자료형, 배열(1차,2차), Collection(List,Set) )
5. 입력확인
6. 영역괄호 끝에 어떤 영역의 끝괄호인지 표시

*/
public class Main_JO_1037_오류교정 {
  public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int N=sc.nextInt();
	 
	 //[주의] - 각각의 행과 열은 1부터 시작한다.
//	 int [][]map = new int[N][N];//입력받을 데이터를 저장
	 int [][]map = new int[N+1][N+1];//입력받을 데이터를 저장
	 
	 //데이터 입력(저장)  ==> 될수 있는데로 이안에는 알고리즘 구현을 하지 말자!!
	 //[주의] - 각각의 행과 열은 1부터 시작한다.
	 for(int i=1; i<=N; i++) {//행인덱스
		for(int j=1; j<=N; j++) {//열인덱스
			map[i][j]=sc.nextInt();
		}
	 }
	 
	 //입력된 데이터 확인
//	 for(int i=1; i<=N; i++) {//행인덱스
//		 for(int j=1; j<=N; j++) {//열인덱스
//			System.out.print(map[i][j]+" ");
//		 }
//		 System.out.println();
//	 }
	 
	 //알고리즘 구현
	 //패리티 성질 확인 ( 각 행의 1의 합이 짝수, 각 열의 1의 합이 짝수)
	 int corrupt=0; //오염된 행 또는 열의 개수
	 
	 //행의 패리티 검사!!
	 int corruptRow=-1;
	 for(int i=1; i<=N; i++) {//바깥for문 : 기준 ==> 행인덱스
		 
		 int sum=0;
		 for(int j=1; j<=N; j++) {//검사할 데이터 ==> 열인덱스 
			 sum += map[i][j];
		 }
		 
		 //짝수 검사~!!
//		 sum%2==0 sum%2!=1//짝수
//		 sum%2==1 sum%2!=0//홀수
		 
//		 if(sum%2==0) {//짝수
//			 continue;
//		 }else {
//			 corrupt++;
//		 }		 
		 if(sum%2==1) { //오염된 데이터를 갖는 다면	
			 corruptRow=i;//오염된 행인덱스 저장
			 corrupt++;
		 }
	 }//for (행 패리티 검사)
	 
	 
	 
	 
	 //===> 행만 검사 ==> corrupt카운트 2이상이면 복구 불가
	 if(corrupt > 1) {
		 System.out.println("Corrupt");
	 }else {//각행의 데이터가 정상데이터 또는 복구 가능데이터
		 corrupt=0;
		 int corruptCol=-1;
		 
		 //열의 패리티 검사!!
		 for(int i=1; i<=N; i++) {//바깥for문 : 기준 ==> 열인덱스		 
			 int sum=0;
			 for(int j=1; j<=N; j++) {//검사할 데이터 ==> 행인덱스 
				 sum += map[j][i];
			 }
			 if(sum%2==1) {//오염 데이터 라면
				 corruptCol=i;//오염된 열인덱스 저장
				 corrupt++;
			 }
		 }//for
		 
		 //데이터에 대한 출력 ==> 3가지 (올바른 데이터, 1비트 변경가능 데이터, 오염데이터)
		 if(corrupt>1) {//오염데이터
			 System.out.println("Corrupt");
		 }else if(corrupt==1) {//변경가능 데이터
			 System.out.println("Change bit ("+corruptRow+","+corruptCol+")");
		 }else {//바른 데이터
			 System.out.println("OK");
		 }
	 }
	 sc.close();
  }//main
}//end class










