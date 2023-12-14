package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181936
// 공배수
public class CommonMultiple {
    public static void main(String[] args) {

    }

    public int solution(int number, int n, int m) {
        if(number%n==0 && number%m==0){
            return 1;
        }
        return 0;
    }
}
