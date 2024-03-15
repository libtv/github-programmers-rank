package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086
// 가장 가까운 같은 글자
public class ClosestSameLetter {
    public static void main(String[] args) {

    }
    public int[] solution(String s) {

        int[] answer = new int [s.length()];
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            String check = Character.toString(s.charAt(i));
            if(!map.containsKey(check)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(check, list);
            }
            else{
                map.get(check).add(i);
            }
        }
        // System.out.println(map);

        for(int i = 0; i < s.length(); i++){
            String check = Character.toString(s.charAt(i));
            answer[map.get(check).get(0)] = -1;
        }
        // System.out.println(Arrays.toString(answer));

        for(int i = 0; i < s.length(); i++){ // 0~6
            String check = Character.toString(s.charAt(i)); // b
            if(answer[i] == -1){
                continue;
            }
            else{
                int min = 100000;
                for(int j = 0; j < map.get(check).size(); j++){ // 0 1 2
                    if(map.get(check).get(j)!=i){
                        if(map.get(check).get(j)>=i){
                            break;
                        }
                        int distance = Math.abs(i-map.get(check).get(j));
                        if(distance < min){
                            min = distance;
                            // System.out.println(min);
                        }
                    }
                }
                answer[i] = min;
            }
        }
        return answer;
    }

}
/*
입력값 〉 "error"
기댓값 〉 [-1, -1, 1, -1, 2]
 */