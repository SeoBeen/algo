package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S4_12927_배수스위치 {	
	
	private static boolean[] list; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();		// 스위치 정보
		list = new boolean[str.length()+1];	// 스위치 온오프 정보 Y : true, N : false;
		int ans = 0;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == 'Y') list[i+1] = true;
			else list[i+1] = false;
		}
		
		for(int i = 1; i< list.length; i++) {
			if(check()) {
//				여기로 떨어진다 => 모든 스위치가 꺼져있음. 종료
				break;
			}
//			여기로 떨어짐 => check에서 false가 나옴, 안꺼진 스위치가 있음
			if(list[i]) {				
				for(int j = i; j<list.length; j+=i) {
//					스위치 반대로 전환
					list[j] = !list[j];
				}
				ans++;
			}			
		}
//		처음부터 끝까지 다 반전 시킨후 한번더 확인 => -1 케이스 잡아내기
		if(check()) {
			System.out.println(ans);
		} else {
			System.out.println(-1);			
		}
	}
	
	private static boolean check() {
		for(int i = 1; i<list.length; i++) {
			if(list[i]) return false;	// i가 true이다 => 불이 켜져있다.
		}
//		여기로 떨어진다 => 모두다 false => 모든 스위치가 꺼져있다.
		return true;
	}	
}
