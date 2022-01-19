package solved;

import java.io.*;
import java.util.*;
public class Main_S2_1931_회의실배정 {	
	public static class meeting implements Comparable<meeting> {
		int start;
		int end;
		
		public meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(meeting o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			else {
				return this.end - o.end;				
			}
		}		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<meeting> pq = new PriorityQueue<meeting>();
		int[][] map = new int[N][2];
		StringTokenizer st;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			//pq.offer(new meeting(s,e));
			map[i][0] = s;
			map[i][1] = e;
		}
		int previousEnd = 0;
		int ans = 0;
		Arrays.sort(map, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				else return o1[1] - o2[1];
			}
			
		});
		
		for(int i = 0; i<N; i++) {
			if(previousEnd <= map[i][0]) {
				ans++;
				previousEnd = map[i][1];
			}
		}
//		System.out.println(pq.toString());
//		for(meeting met : pq) {
//			if(met.start >= previousEnd) {
//				ans++;
//				previousEnd = met.end;
//			}
//		}
		System.out.println(ans);
	}
}

