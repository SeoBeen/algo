package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_17219_비밀번호찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> hash = new HashMap<String,String>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			hash.put(st.nextToken(), st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			sb.append(hash.get(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}

}
