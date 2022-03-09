package programmers;

public class Main_2개이하로다른비트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bNum = Long.toBinaryString(8);
		System.out.println( (2<<1) + 1);	
		System.out.println(bNum);
		System.out.println(bNum.substring(0,1));
		System.out.println(bNum.substring(2,bNum.length()));
		bNum = bNum.substring(0,1) + "0" + bNum.substring(2,bNum.length());
		System.out.println(bNum);
		
		System.out.println(bNum.lastIndexOf("0"));
		System.out.println(bNum.indexOf("1", 3));
	}
	
	// 1000000000000000 => Long
	class Solution {
	    public long[] solution(long[] numbers) {
	        long[] answer = new long[numbers.length];
	        for(int i = 0; i < numbers.length; i++) {
	            long num = numbers[i];
	            String bNum = Long.toBinaryString(num);
	            // 짝수이면
	            if(num %2 == 0) {
	                // 더하기 1
	                answer[i] = numbers[i] + 1;
	            }
	            // 홀수 이면
	            else {
	                // 0이 있는경우
	                if(bNum.contains("0")) {
	                    String temp;
	                    // 제일 뒤에있는 0을 1로 바꾸고, 그 다음 1을 0으로 바꾼다.
	                    // 여기서 제일 뒤에 있는 0이 맨 마지막 0일 수는 없다 => 홀수이기 때문.
	                    int lastZero = bNum.lastIndexOf("0");
	                    int zOne = bNum.indexOf("1",lastZero);
	                    temp = bNum.substring(0,lastZero) + "10" + bNum.substring(zOne+1);
	                    // 10011 10111
	                    answer[i] = Long.parseLong(temp, 2);
	                }                
	                // 0이 없는 경우 -> 올 1
	                else {
	                    // 왼쪽으로 1비트 씩 밀고 +1 해서 올 1로 만든뒤                    
	                    num = (num << 1) + 1;
	                    // 앞에서 두번째 숫자 0으로 바꾸기                    
	                    bNum = Long.toBinaryString(num);
	                    bNum = bNum.substring(0,1) + "0" + bNum.substring(2,bNum.length());
	                    answer[i] = Long.parseLong(bNum, 2);
	                }
	            }
	        }
	        return answer;
	    }
	}

}
