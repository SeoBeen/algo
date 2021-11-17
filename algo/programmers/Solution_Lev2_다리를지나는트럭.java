package study.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lev2_다리를지나는트럭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
//         큐는 다리 역할
        Queue<Integer> queue = new LinkedList<Integer>();
        int sum = 0; // 무게 합계
        for(int i = 0; i<truck_weights.length; i++) {
            while(true) {
//                 다리가 비어있다.
                if(queue.isEmpty()) {
                    queue.offer(truck_weights[i]);
//                     무게 추가
                    sum += truck_weights[i];
//                     시간 추가
                    ++answer;
                    break;
                }
//                 몇대만 올라가있음
                else if(bridge_length > queue.size()) {
//                     무게 한도 초과 안함
                    if(sum + truck_weights[i] <= weight) {
//                         다리에 추가
                        queue.offer(truck_weights[i]);
                        sum +=truck_weights[i];
                        ++answer;
                        break;
                    }
//                     무게 한도 초과
                    else {
                        queue.offer(0);
                        ++answer;
                    }
                }
//                 다리가 꽉참
                else if(bridge_length == queue.size()) {
//                     다리 내려감
                    sum -= queue.poll();
                }
                    
            }
        }
        return answer;
    }

}
