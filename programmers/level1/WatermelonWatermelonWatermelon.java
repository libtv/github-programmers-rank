package org.example.programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12922
// 수박수박수박수박수박수?
public class WatermelonWatermelonWatermelon {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(true){
            sb.append("수");
            cnt++;
            if(cnt==n){
                break;
            }
            sb.append("박");
            cnt++;
            if(cnt==n){
                break;
            }
        }
        return sb.toString();
    }
}
