package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/135808
// 과일 장수
public class Fruiterer {
    public static void main(String[] args) {

    }
    public int solution(int k, int m, int[] score) {

        int answer = 0;
        ArrayList<Integer> scores = new ArrayList<>();
        for(int i = 0; i < score.length; i++){
            scores.add(score[i]);
        }
        Collections.sort(scores, Collections.reverseOrder());
        // System.out.println(scores);

        int index = 0;
        for(int i = 0; i < score.length/m; i++){
            if(index+m-1 < scores.size()){
                int add = scores.get(index+m-1);
                if( add > k){
                    add = k;
                }
                answer += add * m;
                // System.out.println("answer = " + answer);
                index = index + m;
                // System.out.println("index  = " + index);
            }
            else if(index+m-1 > scores.size()){
                break;
            }
        }
        return answer;
    }
}
