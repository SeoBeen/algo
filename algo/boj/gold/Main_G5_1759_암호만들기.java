package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1759_암호만들기 {
	private static char[] alph, answer;	
	private static int L,C;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 뽑을 자리수
		L = Integer.parseInt(st.nextToken());
		// 총 알파벳 개수
		C = Integer.parseInt(st.nextToken());
		alph = new char[C];
		answer = new char[L];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < C; i++) {
			alph[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alph);
		password(0,0,0,0);
		System.out.println(sb);
	}

	private static void password(int idx, int cnt, int mCnt, int jCnt) {
		// 기저조건
		if(cnt == L) {
			// 최소 모음 1개 자음 2개
			if(mCnt >= 1 && jCnt >= 2) {
				for(int i = 0; i < L; i++) {
					sb.append(answer[i]);
				}
				sb.append("\n");
			}			
			return;
		}
		
		for(int i = idx; i < C; i++) {
			answer[cnt] = alph[i];
			// 모음인지 체크
			if(alph[i] == 'a' || alph[i] == 'e' || alph[i] == 'i' || alph[i] == 'o' || alph[i] == 'u') {
				password(i+1, cnt+1, mCnt+1, jCnt);
			}
			else {
				password(i+1, cnt+1, mCnt, jCnt+1);
			}
		}
	}

}
