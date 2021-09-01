package study.boj;

import java.util.Scanner;

public class Main_B3_10872_팩토리얼 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ans = recursion(num);
		System.out.println(ans);
		sc.close();
	}

	private static int recursion(int num) {
		if(num == 0) {
			return 1; 
		}
		return num * recursion(num-1);
	}

}
