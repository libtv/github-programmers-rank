package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181931
// 등차수열의 특정한 항만 더하기
public class AddingSpecificTermsOfAnArithmeticSequence {
    public static void main(String[] args) {

    }
    public int solution(int a, int d, boolean[] included) {
        // 1항 : a 2항 : a + d

        int sum = 0;
        for(int i = 0; i < included.length; i++){
            if(included[i]){
                sum += a + (d*i);
            }
        }
        return sum;

    }

}
