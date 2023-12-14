package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181929
// 원소들의 곱과 합
public class MultiplicationAndSumOfElements {
    public static void main(String[] args) {

    }
    public int solution(int[] num_list) {
        int multiplication = num_list[0];
        int sum = num_list[0];
        for (int i = 1; i < num_list.length; i++) {
            multiplication *= num_list[i];
            sum += num_list[i];
        }
        return multiplication < sum*sum ? 1 : 0;
    }
}
