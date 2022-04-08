package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_16435_스네이크버드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for(int i = 0; i < N; i++) {
			int nextNum = Integer.parseInt(st.nextToken());
			num[i] = nextNum;
		}
		Arrays.sort(num);
		for(int i = 0; i < N; i++) {
			if(num[i] <= L) L++;
		}
//		System.out.println(Arrays.toString(num));
		System.out.println(L);
	}
}
