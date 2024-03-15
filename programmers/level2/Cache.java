package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/17680
// [1차] 캐시
import java.util.*;
public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(String target : cities){
            target = target.toLowerCase();
            if(cache.contains(target)){
                cache.remove(target);
                cache.addLast(target);
                answer++;
            }
            else{
                if(cache.size() < cacheSize){
                    cache.addLast(target);
                }
                else if(cache.size() == cacheSize && cacheSize > 0){
                    cache.pollFirst();
                    cache.addLast(target);
                }

                answer += 5;
            }
        }
        return answer;
    }
}
