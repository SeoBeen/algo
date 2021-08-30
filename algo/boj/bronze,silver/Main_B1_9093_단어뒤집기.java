package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_9093_단어뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		for(int tcase = 1; tcase<=T; tcase++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			StringBuilder ans = new StringBuilder();
			for(int i = 0; i<arr.length; i++) {
				StringBuilder sb = new StringBuilder(arr[i]);
				ans.append(sb.reverse()).append(" ");
			}
			System.out.println(ans);
		}
	}
}
//----------------------------------------------------------------------------
//			String str = br.readLine();
//			arr = str.split(" ");
//			for(int i = 0; i<arr.length; i++) {
//				for(int j =arr[i].length()-1; j>=0; j--) {
//					System.out.print(arr[i].charAt(j));
//				}
//				System.out.print(" ");
//			}
//			System.out.println();
//------------------------------------------------------------------------------
//			String str = "";
//			StringTokenizer st = new StringTokenizer(br.readLine()," ");
//			while(st.hasMoreTokens()) {
//				StringBuffer sb = new StringBuffer(st.nextToken());
//				str += sb.reverse().toString();
//				str += " ";
//			}

// ---------------------------------------------------------------------------------
//			String str = br.readLine()+" ";
//			
//			for(int i = 0; i<str.length(); i++) {
////				공백 이면 출력
//				if(str.charAt(i) == ' ') {
//					while(!stack.empty()) {
//						System.out.print(stack.pop());
//					}
////					문자 출력뒤 공백 출력					
//					System.out.print(" ");
//				}
//				else {
//					stack.push(str.charAt(i));
//				}
//			}
//			System.out.println();