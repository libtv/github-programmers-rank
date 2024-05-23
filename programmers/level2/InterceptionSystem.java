package programmers.level2;

// 프로그래머스 요격 시스템
import java.util.*;
public class InterceptionSystem {
    public int solution(int[][] targets) {
        // 1,4  4,5,3,7,4,8  5,12,11,13,10,14
        Arrays.sort(targets, (o1, o2)-> o1[1] - o2[1]);
        int cur = 0;
        int answer = 0;
        for(int i = 0; i < targets.length; i++){
            if(cur > targets[i][0]) continue;
            cur = targets[i][1];
            answer++;
        }
        return answer;
    }
}
