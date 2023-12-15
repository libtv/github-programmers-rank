package org.example.programmers.level0;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/181923
// 수열과 구간 쿼리 2
public class SequenceAndIntervalQueries2 {
    public static void main(String[] args) {

    }
    public static int[] solution (int[] arr, int[][]queries ){
        // 1. s <= i <= e
        // 2. k < 가장 작은 arr[i]
        // 없으면 -1 저장

        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            for(int a = queries[i][0]; a <= queries[i][1]; a++){
                if(queries[i][2] < arr[a]){
                    list.add(arr[a]);
                }
            }
            if (list.size()==0){
                answer[i] = -1;
            }
            else{
                answer[i] = Collections.min(list);
                list.clear();
            }
        }
        return answer;

    }
}
