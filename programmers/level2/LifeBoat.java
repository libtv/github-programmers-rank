package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885
// 구명 보트
import java.util.*;
public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> dq = new LinkedList<>();
        for(int target : people) dq.addLast(target);
        while(!dq.isEmpty()){
            if(dq.size() >= 2 && dq.peekFirst() + dq.peekLast() <= limit){
                answer++;
                dq.pollFirst();
                dq.pollLast();
            }
            else if(dq.size() >= 2 && dq.peekFirst() + dq.peekLast() > limit){
                answer++;
                dq.pollLast();
            }
            else{
                answer++;
                dq.poll();
            }
        }
        return answer;
    }
}
