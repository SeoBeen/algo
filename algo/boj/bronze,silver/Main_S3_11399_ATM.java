package study.boj.prepareIM.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_11399_ATM {
	public static int N;
	public static int[] times;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times = new int[N];
		int minTime = 0;
		int waitTime = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i<N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(times);
		for(int idx = 0; idx<times.length; idx++) {
			minTime += waitTime + times[idx];
			waitTime += times[idx];
		}
		System.out.println(minTime);
	}

}
