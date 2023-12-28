package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/68935
// 3진법 뒤집기
public class TernaryReversal {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while( n >= 3 ){
            sb.append(n%3);
            n = n / 3;
        }
        sb.append(n);
        // System.out.println(sb);
        int cnt = 0;
        double sum = 0;
        for(int i = sb.length()-1; i >= 0; i--){
            int temp = sb.charAt(i) - '0';
            sum = sum + Math.pow(3, cnt) * temp;
            cnt++;
        }
        return (int)sum;
    }
}
