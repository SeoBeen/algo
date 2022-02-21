package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_S3_9375_패션왕신해빈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int tcase = 0 ; tcase< testCase; tcase ++) {
			int clothes = Integer.parseInt(br.readLine());
			Map<String, Integer> cloth = new HashMap<>();
			for(int i = 0; i<clothes; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String clothName = st.nextToken();
				String key = st.nextToken();
				cloth.put(key, cloth.getOrDefault(key, 0) +1);
			}
			int ans = 1;			
			for(String s : cloth.keySet()) {					
				ans *= (cloth.get(s)+1);
				
			}
			System.out.println(ans-1);
		
		}
	}

}
