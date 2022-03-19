package programmers;

public class Solution_다트게임 {

	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		String tempScore = "";
        int[] score = new int[3];
        int idx = 0;
            
        for(int i = 0 ; i < dartResult.length(); i++) {
            switch(dartResult.charAt(i)) {
            case '*':
            	if(idx>1) score[idx-2] *=2;
            	score[idx-1] *=2;
            	break;
            case '#':
            	score[idx-1] *= -1;
            	break;
            case 'S':
            	score[idx] = (int) Math.pow(Integer.parseInt(tempScore),1);
            	tempScore="";
            	idx++;
            	break;
            case 'D':
            	score[idx] = (int) Math.pow(Integer.parseInt(tempScore),2);
            	tempScore="";
            	idx++;
            	break;
            case 'T':
            	score[idx] = (int) Math.pow(Integer.parseInt(tempScore),3);
            	idx++;
            	tempScore="";
            	break;
            default: 
            	tempScore += dartResult.charAt(i);
            	break;
            }
        }
        int answer = 0;
        for(int i = 0; i<3; i++) {
        	answer += score[i];
        }
        System.out.println(answer);
	}

}
