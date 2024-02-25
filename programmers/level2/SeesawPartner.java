package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996#
// 프로그래머스 LEVEL 2 시소 짝꿍
import java.util.*;
public class SeesawPartner {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0; i < weights.length; i++){
            long target = weights[i];
            map.put(target, (long)map.getOrDefault(target, (long)0)+ 1);
        }
        // System.out.println(map);
        // (2, 3), (2, 4), (3, 4) or same
        Iterator<Map.Entry<Long, Long>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Long, Long> entry = it.next();
            long target = entry.getKey();
            long num    = entry.getValue();
            // 먼저 같은게 있는지?
            if(num >= 2){
                long temp = num;
                temp--;
                while(temp != 0){
                    answer += temp;
                    temp--;
                }
            }
            if((target * 2) % 3 == 0){
                answer += num * map.getOrDefault(target * 2 / 3, (long)0);
            }
            if((target * 2) % 4 == 0){
                answer += num * map.getOrDefault(target * 2 / 4, (long)0);
            }
            if((target * 3) % 4 == 0){
                answer += num * map.getOrDefault(target * 3 / 4, (long)0);
            }
        }
        return answer;

    }
}
