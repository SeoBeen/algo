package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B2_2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i<num; i++) {
			list.add(list.size()-arr[i],i+1);
		}
		for(int i = 0; i<num; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}