package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_11047_동전0 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] priceCoin = new int[N];
		for(int i = 0; i<N; i++) {
			priceCoin[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		for(int idx = priceCoin.length-1; idx>=0; idx--) {
			int division = K/priceCoin[idx];
			answer += division;
			K -= division * priceCoin[idx];
		}
		System.out.println(answer);
	}

}
