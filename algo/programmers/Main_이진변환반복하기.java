package programmers;

import java.util.Arrays;

public class Main_이진변환반복하기 {

	public static void main(String[] args) {
		String s = "110010101001";
		int[] answer = new int[2];
		while(!s.equals("1")) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') {				
					answer[1]++;
				}
			}
			s = s.replaceAll("0", "");
			int length = s.length();
			s = Integer.toBinaryString(length);
			answer[0]++;
		}
		
		String c = s.replaceAll("0", "");
		System.out.println(c);
		System.out.println(Arrays.toString(answer));
	}

}
