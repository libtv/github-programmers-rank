package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181937
// n의 배수
public class MultipleOfN {
    public static void main(String[] args) {

    }
    public int solution(int num, int n) {
        if(num%n==0){
            return 1;
        }
        else{
            return 0;
        }
    }

}
