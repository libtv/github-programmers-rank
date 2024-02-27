package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12899
// 124 나라의 숫자
public class Number124OfCountries {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int [] memo = {1,2,4};
        while(n > 0){
            n--;
            sb.append(memo[n%3]);
            n /= 3;
        }
        return sb.reverse().toString();
    }
}
