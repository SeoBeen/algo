package solved;

import java.util.*;
import java.io.*;
public class Main_S1_1927_최소힙 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int x;
		PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			if(x == 0 ) {
				if(pq.size() == 0) {
					System.out.println(0);					
				}
				else {
					System.out.println(pq.poll());
				}
			}
			else {
				pq.offer(x);
			}
		}
	}

}
