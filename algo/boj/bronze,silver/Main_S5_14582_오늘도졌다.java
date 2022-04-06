package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_14582_오늘도졌다 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 제미니스
		int[] team1 = new int[9];
		// 걸리버스
		int[] team2 = new int[9];
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < 9; j++) {
				if(i == 0) team1[j] = Integer.parseInt(st.nextToken());
				else team2[j] = Integer.parseInt(st.nextToken());
			}
		}

		int sTeam1 = 0;
		int sTeam2 = 0;
		boolean isReversed = false;
		for(int i = 0; i < 9; i++) {
			sTeam1 +=team1[i];
			if(sTeam1 > sTeam2) isReversed = true;
			sTeam2 +=team2[i];
		}
		if(isReversed) System.out.println("Yes");
		else System.out.println("No");
	}

}
