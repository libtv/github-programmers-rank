package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/160586
// 대충 만든 자판
public class ARoughlyMadeKeyboard {
    public static void main(String[] args) {

    }
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < keymap.length; i++){
            String[] split = keymap[i].split("");
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                list.add(split[j]);
            }
            map.put(i , list);
        }

        // System.out.println(map);

        for(int i = 0; i < targets.length; i++){
            int cnt = 0;
            boolean flag = false;
            String[] split = targets[i].split("");
            for(int j=0; j < split.length; j++){
                String check = split[j];
                int min = 10000;
                for(int k = 0; k < map.size(); k++){
                    if(map.get(k).contains(check)){
                        int index = map.get(k).indexOf(check) + 1;
                        if (min > index){
                            min = index;
                        }
                    }
                    System.out.println(min);
                }
                if(min == 10000){
                    flag = true;
                    break;
                }
                else{
                    cnt += min;
                }
            }
            if(flag){
                answer[i] = -1;
            }
            else{
                answer[i] = cnt;
            }
        }

        return answer;
    }
}
