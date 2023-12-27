package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/12910
// 나누어 떨어지는 숫자 배열
public class ArrayOfNumbersThatFallApart {
    public static void main(String[] args) {

    }
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int temp  = arr[i];
            if(temp % divisor == 0){
                list.add(temp);
            }
        }
        Collections.sort(list);

        if(list.size()==0){
            int [] answer = {-1};
            return answer;
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
