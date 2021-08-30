package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_10158_개미 {
	private static int W,H, p,q,t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());	// 가로길이, c
		H = Integer.parseInt(st.nextToken());	// 세로길이, r
		st = new StringTokenizer(br.readLine(), " ");
		p = Integer.parseInt(st.nextToken());	// 좌표 c
		q = Integer.parseInt(st.nextToken());	// 좌표 r
		t = Integer.parseInt(br.readLine());	// 시간 t
		
		p += t;
		q += t;
		p %=(2*W);
		q %=(2*H);
		if(p > W) p = 2* W - p;
		if(q > H) q = 2* H - q;
		System.out.println(p+" "+q);
	}
}