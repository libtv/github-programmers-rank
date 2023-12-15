package org.example.programmers.level0;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/181919
// 콜라츠 수열 만들기
public class CreatingAColatzSequence {
    public static void main(String[] args) {

    }
    public int[] solution(int n) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);

        while(n > 1){
            if(n%2==0){
                n = n / 2;
                list.add(n);
                if(n==1){
                    break;
                }
            }
            else{
                n = 3 * n + 1;
                list.add(n);
                if(n==1){
                    break;
                }
            }
        }
        int [] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
