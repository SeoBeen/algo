package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_1003_피보나치함수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Tcase = Integer.parseInt(br.readLine());
		int[] zero = new int[41];
		int[] one = new int[41];
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		for(int i = 2; i<41; i++) {
			zero[i] = zero[i-1] + zero[i-2];
			one[i] = one[i-1] + one[i-2];
		}
		for(int i = 0; i<Tcase; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(zero[num]+ " "+one[num]+"\n");
		}
		System.out.println(sb);
	}
}
