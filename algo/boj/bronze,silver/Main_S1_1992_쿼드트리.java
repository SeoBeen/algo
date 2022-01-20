package solved;

import java.io.*;
import java.util.*;

public class Main_S1_1992_쿼드트리 {
	private static StringBuilder sb = new StringBuilder();
	private static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		find(0,0,N);
		System.out.println(sb);
	}
	
	public static boolean isEqual(int r, int c, int len) {
		char cur = map[r][c];
		for(int i = r; i<r+len; i++) {
			for(int j = c; j<c+len; j++) {
				if(map[i][j] != cur) return false;
			}
		}
		return true;
	}
	
	public static void find(int r, int c, int len) {
		// 구분을 위한 여는것과 닫는것 만들어주기
		if(isEqual(r,c,len)) {
			sb.append(map[r][c]);
		}		
		else {
			// 4등분 해야함으로 2로 나눠줌
			sb.append("(");
			len /= 2;
			find(r,c,len);
			find(r,c+len,len);
			find(r+len,c,len);
			find(r+len,c+len,len);			
			sb.append(")");
		}
	}

}
