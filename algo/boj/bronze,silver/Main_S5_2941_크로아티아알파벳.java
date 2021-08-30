package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S5_2941_크로아티아알파벳 {
	private static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		크로아티아 알파벳
		str = new String[] { "c=", "c-", "dz=","d-","lj","nj","s=","z="};
		String sentence = br.readLine();
		
		
//		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< str.length; i++) {
			sentence = sentence.replaceAll(str[i],"a");			
		}
		System.out.println(sentence.length());
		
		
//		for(int i = 0; i<str.length; i++) {
//			ans = sentence.replace("^[c=]","a");			
//		}
//		System.out.println(ans.length());
	}// main
}
