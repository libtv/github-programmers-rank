package programmers.level2;

// 코딩테스트 연습 스택/큐 다리를 지나는 트럭
import java.util.*;
public class TruckPassingOverTheBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        for(int target : truck_weights){
            trucks.add(target);
        }

        int cur_weight = 0;
        int time = 0;
        while(!trucks.isEmpty() || !bridge.isEmpty()){
            if(!bridge.isEmpty() && bridge.peek()[0] <= time){
                int [] temp = bridge.poll();
                cur_weight -= temp[1];
            }

            if(!trucks.isEmpty() && bridge.size() + 1 <= bridge_length && cur_weight + trucks.peek() <= weight){
                int temp = trucks.poll();
                cur_weight += temp;
                bridge.add(new int [] {time + bridge_length,temp});
            }
            time++;
        }
        return time;
    }
}
