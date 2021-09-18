package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Boj_2493_탑 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 탑의 수
		N = Integer.parseInt(br.readLine());
		Stack<Integer> tower = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		// 각 탑들의 높이
		int tHeight;
		StringTokenizer st = new StringTokenizer(br.readLine());
//		System.out.println(st.countTokens()); for문의 i 조건으로 줄경우 nextToken을 진행함에 따라 값이 작아짐
		for(int i = 1; i<= N; i++) {
			// 탑 높이 입력
			tHeight = Integer.parseInt(st.nextToken());
			while(!tower.empty()) {
				if(tower.peek() >= tHeight) {
					System.out.print(idx.peek()+" ");
					break;
				}
				tower.pop();
				idx.pop();
			}
			// 스택이 비었을 경우 0 출력
			if(tower.empty()) System.out.print("0 ");
			tower.push(tHeight);
			idx.push(i);
		}
	}
}
