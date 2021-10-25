package study.programmers;

public class Solution_타겟넘버 {

	private static int ans;

	public int solution(int[] numbers, int target) {

		ans = 0;
		per(numbers, target, 0, 0);

		int answer = ans;

		return answer;
	}

	private static void per(int[] numbers, int target, int cnt, int sum) {
//	         기저조건
		if (cnt == numbers.length) {
			if (sum == target)
				ans++;
			return;
		}
//	         더해주고
		sum += numbers[cnt];
		per(numbers, target, cnt + 1, sum);
//	         다시 원상복구 시켜주고
		sum -= numbers[cnt];
//	         이번엔 빼주는거
		sum -= numbers[cnt];
		per(numbers, target, cnt + 1, sum);

	}

}
