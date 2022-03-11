package programmers;

public class Main_3진법뒤집기 {

	public static void main(String[] args) {
		int n = 45;
		String str = transfer(n);
		int s = Integer.parseInt(str, 3);
		
		System.out.println(s);
	}

	private static String transfer(int n) {
		String s = "";
		while(n > 0) {
			s += (n % 3);
			n /= 3;
		}
		return s;
	}

}
