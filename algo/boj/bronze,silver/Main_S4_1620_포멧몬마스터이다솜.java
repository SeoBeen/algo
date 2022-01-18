package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_1620_포멧몬마스터이다솜 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> map1 = new HashMap<String,Integer>(N);
		HashMap<Integer,String> map2 = new HashMap<Integer,String>(N);
		for(int i = 1; i<=N; i++) {
			String str = br.readLine();
			map1.put(str, i);
			map2.put(i, str);
		}
		for(int i = 0; i<M; i++) {
			String str = br.readLine();
			if(map1.containsKey(str)) {
				System.out.println(map1.get(str));
			}
			else {
				int num = Integer.parseInt(str);
				System.out.println(map2.get(num));
			}
		}
	}

}
