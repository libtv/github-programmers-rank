package org.example.programmers.level0;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/181944
// 홀짝 구분하기
public class DistinguishBetweenOddAndEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0){
            System.out.println(n + " is even");
        }
        else if(n%2!=0){
            System.out.println(n + " is odd");
        }
    }
}
