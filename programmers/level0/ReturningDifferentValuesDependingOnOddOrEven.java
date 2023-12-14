package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181935
// 홀짝에 따라 다른 값 반환하기
public class ReturningDifferentValuesDependingOnOddOrEven {
    public static void main(String[] args) {

    }

    public int solution(int n) {

        if (n%2==0){
            int sum = 0;
            for(int i = n; i > 1; i=i-2){
                sum += i*i;
            }
            return sum;
        }
        else{
            int sum = 0;
            for(int i = n; i > 0; i=i-2){
                sum += i;
            }
            return sum;
        }

    }

}
