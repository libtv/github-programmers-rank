package org.example.programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12944
// 평균 구하기
public class FindTheAverage {
    public static void main(String[] args) {

    }
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;

        for(int target : arr){
            sum+= target;
        }
        answer = (double)sum / arr.length;

        return answer;
    }
}
