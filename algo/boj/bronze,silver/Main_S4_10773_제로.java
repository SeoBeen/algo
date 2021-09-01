package study.boj;

import java.util.Scanner;
import java.util.Stack;

public class Main_S4_10773_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i<K; i++) {
			int num = sc.nextInt();
			if(num != 0) {
				stack.add(num);
			}
			else {
				stack.pop();
			}
		}
		int ans = 0;
		int size = stack.size(); 
		for(int i =0; i<size; i++) {
			ans += stack.pop();
		}
		System.out.println(ans);
		
		sc.close();
	}// main
}// end class
