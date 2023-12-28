package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12931
// 자릿수 더하기
public class AddDigits {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        int sum = 0;
        String temp = Integer.toString(n);
        for(int i = 0; i < temp.length(); i++){
            sum += temp.charAt(i) - '0';
        }
        return sum;
    }
}
