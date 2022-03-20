package programmers;

import java.util.Arrays;

public class Solution_비밀지도 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] answer = new String[n];
		String format = "%0"+n+"d";
		
		for(int i = 0; i<n; i++) {			
			String bNum1 = String.format(format,Long.parseLong(Integer.toBinaryString(arr1[i])));
			String bNum2 = String.format(format,Long.parseLong(Integer.toBinaryString(arr2[i])));
			answer[i] = "";
			for(int j = 0; j<n; j++) {
				if(bNum1.charAt(j) == '0' && bNum2.charAt(j) == '0') {
					answer[i] += " ";
				}
				else {
					answer[i] +="#";
				}
			}
			
		}
		System.out.println(Arrays.toString(answer));
	}

}
