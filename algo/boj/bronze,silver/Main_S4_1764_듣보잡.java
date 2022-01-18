package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_1764_듣보잡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			hmap.put(str, 1);
		}
		//StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			if(hmap.containsKey(str)) {
				list.add(str);
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(String str2 : list) {
			System.out.println(str2);
		}
	}
}
