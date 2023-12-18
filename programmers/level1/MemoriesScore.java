package org.example.programmers.level1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/176963
// 추억 점수
public class MemoriesScore {
    public static void main(String[] args) {

    }
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }

        int [] result = new int[photo.length];

        for(int i = 0; i < photo.length; i++){
            result[i] = 0;
            for(int j = 0; j < photo[i].length; j++){
                if(map.containsKey(photo[i][j]))
                result[i] += map.get(photo[i][j]);
            }
        }
        return result;

    }

}

