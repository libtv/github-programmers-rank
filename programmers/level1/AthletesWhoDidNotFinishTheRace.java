package programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// 완주하지 못한 선수
public class AthletesWhoDidNotFinishTheRace {
    public static void main(String[] args) {

    }
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap();
        for (String runner : participant) {
            map.put(runner, map.getOrDefault(runner, 0) + 1); // containskey보다 좋다
        }
        for (String runner : completion){
            if(!map.containsKey(runner)){
                return runner;
            }
            map.put(runner, map.get(runner)-1);
        }
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            int test = entry.getValue();
            String key = entry.getKey();
            if(test!=0){
                return key;
            }
        }
        return "0";
    }

}
/* 정확성 통과 효율성 x 코드
 public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap();
        Set<String> set = new HashSet();

         for(String target : participant){
            if(!map.containsKey(target)){
                map.put(target, 1);
            }
            else{
                map.put(target, map.get(target) + 1);
            }
            set.add(target);
         }

        HashMap<String, Integer> map2 = new HashMap();
         for(String target : completion){
            if(!map2.containsKey(target)){
                map2.put(target, 1);
            }
            else{
                map2.put(target, map2.get(target) + 1);
            }
        }
        for(String key : set){
            if(!map2.containsKey(key)){
                return key;
            }
            else if(map2.get(key)!=map.get(key)){
                return key;
            }
        }
        return "";

    }
 */