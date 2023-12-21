package org.example.programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/136798
// 기사단원의 무기
public class TemplarsWeapon {
    public static void main(String[] args) {
        // 16의 약수 1,2,4,8,16 5개
        // 제곱근 : 4
        // 2~4: 2,4 2개
        // 16 / 2 = 8 , 2가 아니니까 1개
        // 16 / 4 = 4 x
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            // 약수 구하기
            int cnt = 2; // 약수의 개수 (자기 자신 + 1) start
            for(int j=2; j <= i/2; j++){
                if(i%j==0){
                    cnt++;
                }
            }
            if(i==1){
                list.add(1);
            }
            else{
                list.add(cnt);
            }
        }
        // System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > limit){
                answer+= power;
            }
            else{
                answer+= list.get(i);
            }
        }
        return answer;
    }
}
/*
약수 구하기 구하는 수의 /2 까지 for문 = 제일 느린 속도  테스트 16: 9471.28ms

public int solution(int number, int limit, int power) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            // 약수 구하기
            int cnt = 2; // 약수의 개수 (자기 자신 + 1) start
            int sqrt = (int)Math.sqrt(i);
            // System.out.println(sqrt);
            for(int j=2; j <= sqrt; j++){
               if (i % j == 0) {
                cnt++;
                if (i / j != j) { // 중복 약수 방지
                    cnt++;
                }
            }
            }
            if(i==1){
                list.add(1);
            }
            else{
                list.add(cnt);
            }
        }
        // System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > limit){
                answer+= power;
            }
            else{
                answer+= list.get(i);
            }
        }
        return answer;
    }
제곱근을 사용하면 제일 느린게 84.37이다. 거의 100배차이

 */
