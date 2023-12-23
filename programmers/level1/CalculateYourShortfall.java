package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/82612
// 부족한 금액 계산하기
public class CalculateYourShortfall {
    public static void main(String[] args) {

    }
    public long solution(int price, int money, int count) {
        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += price * i;
        }
        if(money-sum >=0){
            return 0;
        }
        else{
            return sum-money;
        }
    }
}
