package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748
// K 번째수
public class KthNumber {
    public static void main(String[] args) {

    }
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = a; j <= b; j++){
                list.add(array[j-1]);
            }
            Collections.sort(list);
            answer[i] = list.get(c-1);
        }
        return answer;
    }


}
