package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/12935
// 제일 작은 수 제거하기
public class RemoveSmallestNumber {
    public static void main(String[] args) {

    }
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int [] answer = {-1};
            return answer;
        }
        else{
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                list.add(arr[i]);
            }
            int min = Collections.min(list);
            list.remove(Integer.valueOf(min));

            int [] answer = new int[list.size()];

            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
