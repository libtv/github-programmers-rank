package programmers.level1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// 해시 // 폰켓몬
public class Pokemon {
    public static void main(String[] args) {

    }
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int target : nums){
            if(!map.containsKey(target)){
                map.put(target, 1);
            }
            else{
                map.put(target, map.get(target) + 1);
            }
        }
        // System.out.println(map);
        int chance = nums.length / 2;
        int maps = map.size();

        if(chance >= maps){
            return maps;
        }
        else{
            return chance;
        }
    }

}
