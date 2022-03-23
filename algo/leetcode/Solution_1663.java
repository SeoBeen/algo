package leetcode;

public class Solution_1663 {

	public static void main(String[] args) {
		int n = 3;
		int k = 27;
		StringBuilder sb = new StringBuilder();
		
		System.out.println(122-96);
		String s = "abc";
		
		int cnt = n;
		for(int i = 1; i <= cnt; i++) {
			// 뒤에서부터 올 수 있는 최대 숫자.
			int num = k-n+1;
			// z가 가능
			if(num > 26) {
				sb.insert(0, "z");				
				k -= 26;
			}
			// z 불가능
			else {
				char c = (char)(num+96);
				sb.insert(0,c);
				k -= num;
			}			
			n--;
			
		}
		System.out.println(sb);
		
	}

}
