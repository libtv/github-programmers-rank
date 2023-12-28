package org.example.programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12954
// x만큼 간격이 있는 n개의 숫자
public class NnumbersSpacedApartByX {
    public static void main(String[] args) {

    }
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for(int i = 1; i < n; i++){
            answer[i] = answer[i-1] + x;
        }
        return answer;
    }

}
