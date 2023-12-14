package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181938
// 두 수의 연산값 비교하기
public class ComparingTheOperationValueOfTwoNumbers {
    public static void main(String[] args) {

    }
    public int solution(int a, int b) {

        int sum =  Integer.parseInt(Integer.toString(a) + Integer.toString(b));

        if(sum >= 2 * a * b ){
            return sum;
        }
        else{
            return 2 * a * b;
        }

    }
}
