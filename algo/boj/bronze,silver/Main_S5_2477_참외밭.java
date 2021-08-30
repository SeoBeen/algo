package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2477_참외밭 {
	private static int K;	// 참외 개수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		int[] nums = new int[6];	//둘레 길이 저장
		
		int maxW = 0;	// 최대 가로길이
		int maxH = 0;	// 최대 세로길이
		int cutW = 0; 	// 잘라낼 가로길이
		int cutH = 0; 	// 잘래놀 세로길이
		
		for(int i = 0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			st.nextToken();
			nums[i] = Integer.parseInt(st.nextToken());	// 길이정보 저장
		}
		
		for(int i = 0; i<6; i++) {
			if(i %2 == 0) {
				if(maxW < nums[i]) {
					maxW = nums[i];		// 최대 가로길이 구하기					
				}
			}
			else {
				if(maxH<nums[i]) {
					maxH = nums[i];	// 최대 세로길이 구하기				
				}
			}
		}
		
		for(int i = 0; i<6; i++) {
			if(i%2 == 0) {
				if(maxH == nums[(i +5)%6] + nums[(i+1)%6]) {
					cutW = nums[i];
				}
			}
			else {
				if(maxW == nums[(i +5)%6] + nums[(i+1)%6]) {
					cutH = nums[i];
				}
			}		
		}
		System.out.println((maxW*maxH - cutW * cutH) * K);
	}//main
}// end class
