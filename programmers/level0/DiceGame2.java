package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181930
// 주사위 게임 2
public class DiceGame2 {
    public static void main(String[] args) {

    }
    public int solution(int a, int b, int c) {
        if(a!=b && a!=c && b!=c){
            return a+b+c;
        }
        else if(a==b && b==c){
            return (a+b+c) * (a*a+b*b+c*c) * (a*a*a+b*b*b+c*c*c);
        }
        else
            return (a+b+c) * (a*a+b*b+c*c);
    }
}
