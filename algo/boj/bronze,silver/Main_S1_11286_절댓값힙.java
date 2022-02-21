package solved;

import java.util.*;
import java.io.*;

public class Main_S1_11286_절댓값힙 {
	private static class number implements Comparable<number> {
		int number;
		int absNumber;
		
		private number(int number, int absNumber) {
			this.number = number;
			this.absNumber = absNumber;
		}
		
		@Override
		public int compareTo(number o) {
			if(o.absNumber != this.absNumber) {
				return this.absNumber - o.absNumber;
			}
			else {
				return this.number - o.number;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		PriorityQueue<number> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					int n = pq.poll().number;
					sb.append(n).append("\n");
				}
			}
			else {
				pq.offer(new number(num, Math.abs(num)));
			}
		}
		System.out.println(sb);
	}

}
