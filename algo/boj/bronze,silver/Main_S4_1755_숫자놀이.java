package study.boj.prepareExam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S4_1755_숫자놀이 {
	private static int M,N;
	private static class Nums implements Comparable<Nums>{
		int num;
		String engNum;
		public Nums(int num, String engNum) {
			super();
			this.num = num;
			this.engNum = engNum;
		}	
		@Override
		public int compareTo(Nums o) {			
			return this.engNum.compareTo(o.engNum);
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
//		0~9까지의 숫자 영문명이 적힌 배열.
		String[] engName = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		LinkedList<Nums> list = new LinkedList<>();
		int[] nums = new int[N+1];
		for(int i = M; i<=N; i++) {
			String ename = "";
			if(i < 10) {
				ename = engName[i];				
			} else {
//				최댓값은 99까지 이기때문에 100이상은 신경 X
//							10의자리수			일의자리수
				ename = engName[i/10] + " " + engName[i%10];
			}
			list.add(new Nums(i,ename));
		}
//		영문이름 기준 정렬
		Collections.sort(list);
		
//		출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<list.size(); i++) {
			if(i!= 0 && i % 10 == 0) sb.append("\n");
			sb.append(list.get(i).num+" ");
		}
		System.out.println(sb);
	}
}
