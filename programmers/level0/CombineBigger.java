package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181939
// 더 크게 합치기
public class CombineBigger {
    public static void main(String[] args) {

    }
    public int solution(int a, int b) {
        String Sum1 = Integer.toString(a) + Integer.toString(b);
        String Sum2 = Integer.toString(b) + Integer.toString(a);

        if (Integer.parseInt(Sum1)>= Integer.parseInt(Sum2)){
            return Integer.parseInt(Sum1);
        }
        else {
            return Integer.parseInt(Sum2);
        }
    }

}
