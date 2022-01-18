package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		int first = Integer.MAX_VALUE;
		int cnt = st.countTokens();
		// -로 분리
		for(int i = 0; i<cnt; i++) {
			// +로 분리해서 다 더하기
			int num = 0;
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
			
			int cnt2 = st2.countTokens();
			for(int j = 0; j<cnt2; j++) {
				num += Integer.parseInt(st2.nextToken());
			}
			
			if(first == Integer.MAX_VALUE) {
				first = num;
			} else {
				first -= num;
			}
		}
		System.out.println(first);
		
	}

}
