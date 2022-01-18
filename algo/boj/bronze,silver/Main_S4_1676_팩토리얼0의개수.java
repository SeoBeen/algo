package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S4_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(N >= 5) {
			cnt += N / 5;
			N /= 5;
		}
		System.out.println(cnt);
	}

}
