package study.programmers;

public class Solution_Lev2_조이스틱 {
	public static void main(String args[]) {
		int x = solution("JAN");
		System.out.println(x);
	}
	
	public static int solution(String name) {
        int answer = 0;
        char[] chr = name.toCharArray();
        int sideMove = chr.length-1; // 좌우 최대이동값
        for(int i = 0; i<chr.length; i++) {
        	if(chr[i] - 'A' < 14) {
        		answer+= chr[i]-'A';
        	}
//        	14 이상이면
        	else {
        		answer += 'Z'+1 - chr[i];
        	}
        	
//        	다음꺼 탐색
        	int idx = i+1;
//        						다음알파벳이 A이면  증가
        	while(idx<chr.length && chr[idx] == 'A' ) idx++;
//        	여기로 떨어짐 => A가 아닌 다음 알파벳의 위치가 나옴
//        	좌우 이동의 최적화 => 현재 온 거리(i) + 다음꺼 알파벳 까지의 거리가 
//        						  i만큼 되돌아가서 뒤에서가는게 이득이냐
//        						  아니면 그냥 그대로 가는게 이득이냐 구해보기.
        	sideMove = Math.min(sideMove, i+chr.length-idx+Math.min(i, chr.length-idx));
//        																BBBAAAA 일 경우 좌우이동은 2칸만
//        																AAABBBBBBBAA 일 경우 9칸
        }
        answer += sideMove;
        return answer;
    }
}
